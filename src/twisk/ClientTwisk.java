package twisk;

import twisk.monde.Activite;
import twisk.monde.ActiviteRestreinte;
import twisk.monde.Guichet;
import twisk.monde.Monde;
import twisk.outils.ClassLoaderPerso;
import twisk.simulation.Simulation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClientTwisk {
    public Monde monde1() throws ClassNotFoundException {

        ClassLoaderPerso classLoaderPerso = new ClassLoaderPerso(this.getClass().getClassLoader());
        classLoaderPerso.loadClass("twisk.simulation.Simulation");

        Monde m = new Monde();
        Guichet guichet = new Guichet("Guichet1", 1);
        Activite activiteRestreinte = new ActiviteRestreinte("ActivitéR", 6, 4);
        Activite activite = new Activite("Activité1", 5, 1);

        guichet.ajouterSuccesseur(activiteRestreinte);
        activiteRestreinte.ajouterSuccesseur(activite);

        m.ajouter(guichet, activite, activiteRestreinte);

        m.aCommeEntree(guichet);
        m.aCommeSortie(activite);

        return m;
    }

    public static Monde monde2(){
        Monde m = new Monde();
        Guichet guichet = new Guichet("Guichet1", 1);
        Activite activiteRestreinte = new ActiviteRestreinte("ActivitéR", 6, 4);
        Activite zeubi = new Activite("Zeubi", 3, 2);
        Activite activite = new Activite("Activité1", 5, 1);

        guichet.ajouterSuccesseur(activiteRestreinte);
        activiteRestreinte.ajouterSuccesseur(zeubi);
        zeubi.ajouterSuccesseur(activite);

        m.ajouter(guichet, activite, zeubi, activiteRestreinte);

        m.aCommeEntree(guichet);
        m.aCommeSortie(activite);

        return m;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {


        Class<?> classe = Simulation.class;
        Simulation s = (Simulation)classe.newInstance();

        Class<?> argNbClient = int.class ;
        Method setNbClient = classe.getMethod("setNbClients", argNbClient);
        setNbClient.invoke(s, 3);

        Class<?> argSimuler = Monde.class ;
        Method simul = classe.getMethod("simuler", argSimuler);
        simul.invoke(s, new ClientTwisk().monde1());
        simul.invoke(s, new ClientTwisk().monde2());
    }
}

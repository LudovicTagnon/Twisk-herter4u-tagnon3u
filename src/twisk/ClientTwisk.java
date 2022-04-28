package twisk;

import twisk.monde.Activite;
import twisk.monde.ActiviteRestreinte;
import twisk.monde.Guichet;
import twisk.monde.Monde;
import twisk.outils.ClassLoaderPerso;
import twisk.outils.FabriqueNumero;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClientTwisk {
    private int nbMonde;
    public static Monde monde1() {
        Monde m = new Monde();
        Guichet guichet = new Guichet("Guichet1", 1);
        Activite activiteRestreinte = new ActiviteRestreinte("ActivitéR", 2, 1);
        Activite activite = new Activite("Activité1", 2, 1);

        guichet.ajouterSuccesseur(activiteRestreinte);
        activiteRestreinte.ajouterSuccesseur(activite);

        m.ajouter(guichet, activite, activiteRestreinte);

        m.aCommeEntree(guichet);
        m.aCommeSortie(activite);

        return m;
    }

    public static Monde monde2()  {
        Monde m = new Monde();
        Guichet guichet = new Guichet("Guichet1", 1);
        Activite activiteRestreinte = new ActiviteRestreinte("ActivitéR", 2, 1);
        Activite activite1 = new Activite("activite1", 2, 1);
        Activite activite = new Activite("Activité", 2, 1);

        guichet.ajouterSuccesseur(activiteRestreinte);
        activiteRestreinte.ajouterSuccesseur(activite1);
        activite1.ajouterSuccesseur(activite);

        m.ajouter(guichet, activite, activite1, activiteRestreinte);

        m.aCommeEntree(guichet);
        m.aCommeSortie(activite);

        return m;
    }

    public static Monde monde3()  {
        Monde m = new Monde();

        Guichet entreeParc = new Guichet("Entree parc");
        Activite parc = new Activite("parc");
        Guichet gtoilette = new Guichet("Guichet Toilette");
        Activite toilette = new Activite("toilette");
        Guichet attenteAttraction = new Guichet("Attente Attraction");
        Activite attraction = new Activite("Attraction");

        entreeParc.ajouterSuccesseur(parc);
        parc.ajouterSuccesseur(gtoilette, attenteAttraction);
        gtoilette.ajouterSuccesseur(toilette);
        attenteAttraction.ajouterSuccesseur(attraction);

        m.ajouter(entreeParc, parc, gtoilette, attenteAttraction, toilette, attraction);

        m.aCommeEntree(entreeParc);
        m.aCommeSortie(attraction, toilette);

        return m;
    }

    public static void lanceurClassLoader(Monde monde) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ClientTwisk client = new ClientTwisk();

        ClassLoaderPerso classLoaderPerso = new ClassLoaderPerso(client.getClass().getClassLoader());

        Class<?> classe = classLoaderPerso.loadClass("twisk.simulation.Simulation");
        Object s = classe.newInstance();

        Class<?> argNbClient = int.class ;
        Method setNbClient = classe.getMethod("setNbClients", argNbClient);
        setNbClient.invoke(s, 3);

        Class<?> argSimuler = Monde.class ;
        Method simul = classe.getMethod("simuler", argSimuler);
        simul.invoke(s, monde);

        FabriqueNumero.getInstance().setNbMonde();
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        lanceurClassLoader(monde1());
        lanceurClassLoader(monde2());
    }
}

package twisk.simulation;

import twisk.monde.Monde;
import twisk.outils.KitC;

public class Simulation {
    KitC kitC;
    public Simulation() {
        kitC = new KitC();
        kitC.creerEnvironnement();
    }

    public void simuler(Monde monde){
        kitC.creerFichier(monde.toC());
        kitC.compiler();
        kitC.construireLaLibrairie();
    }


    public native int[] start_simulation(int nbEtapes, int nbServices, int nbClients, int[] tabJetonsServices);
    public native int[] ou_sont_les_clients(int nbEtapes, int nbClients);
    public native void nettoyage();

    System.load("/tmp/twisk/libTwisk.so");
}

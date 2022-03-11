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
}

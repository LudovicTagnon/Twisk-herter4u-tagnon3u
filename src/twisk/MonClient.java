package twisk;

import twisk.monde.*;
import twisk.simulation.Simulation;

public class MonClient {
    public static void main(String[] args) {
        Monde m = new Monde();
        Guichet guichet = new Guichet("Guichet1", 1);
        Activite activiteRestreinte = new ActiviteRestreinte("ActivitéR", 6, 4);
        Activite activite = new Activite("Activité1", 5, 1);

        guichet.ajouterSuccesseur(activiteRestreinte);
        activiteRestreinte.ajouterSuccesseur(activite);

        m.ajouter(guichet, activite, activiteRestreinte);

        m.aCommeEntree(guichet);
        m.aCommeSortie(activite);

        Simulation s = new Simulation();
        s.setNbClients(10);
        s.simuler(m);
    }
}

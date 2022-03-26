package twisk;

import twisk.monde.*;
import twisk.simulation.Simulation;

public class MonClient {
    public static void main(String[] args) {
        Monde m = new Monde();
        Guichet guichet = new Guichet("SuperGuichet", 1);
        Activite waw = new Activite("Si tu le dis", 6, 4);
        Activite hehe = new Activite("pasdfezd", 5, 1);

        guichet.ajouterSuccesseur(waw);
        waw.ajouterSuccesseur(hehe);

        m.ajouter(guichet, waw, hehe);

        m.aCommeEntree(guichet);
        m.aCommeSortie(hehe);

        Simulation s = new Simulation();
        s.setNbClients(10);
        s.simuler(m);
    }
}

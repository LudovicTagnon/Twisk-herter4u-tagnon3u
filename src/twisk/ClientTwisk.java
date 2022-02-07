package twisk;

import twisk.monde.*;
import twisk.simulation.Simulation;

public class ClientTwisk {
    public static void main(String[] args) {
        Etape guichet1 = new Guichet("File 1");
        Etape guichet2 = new Guichet("File 2");
        Etape caisse1 = new Activite("Caisse 1");
        Etape caisse2 = new Activite("Caisse 2");
        Etape manege = new ActiviteRestreinte("Manege");
        Etape zoo = new Activite("Zoo");
        Etape file3 = new Guichet("File Toilette");
        Etape toilette = new Activite("Toilette");

        Monde m = new Monde();

        m.ajouter(guichet1, guichet2, caisse1, caisse2, manege, zoo, file3, toilette);
        m.aCommeEntree(guichet1, guichet2);
        m.aCommeSortie(manege, zoo, toilette);

        guichet1.ajouterSuccesseur(caisse1);
        guichet2.ajouterSuccesseur(caisse2);
        caisse1.ajouterSuccesseur(manege, zoo);
        caisse2.ajouterSuccesseur(zoo);
        manege.ajouterSuccesseur(file3);
        zoo.ajouterSuccesseur(file3);
        file3.ajouterSuccesseur(toilette);

        Simulation sim = new Simulation();

        sim.simuler(m);




        Monde monde = new Monde() ;

        Guichet guichet = new Guichet("ticket", 2) ;
        Activite act1 = new ActiviteRestreinte("toboggan", 2, 1) ;

        Etape etape1 = new Activite("musee") ;
        Etape etape2 = new Activite("boutique") ;

        etape1.ajouterSuccesseur(etape2) ;
        etape2.ajouterSuccesseur(guichet) ;
        guichet.ajouterSuccesseur(act1);

        monde.ajouter(etape1, etape2) ;
        monde.ajouter(act1) ;
        monde.ajouter(guichet) ;

        monde.aCommeEntree(etape1);
        monde.aCommeSortie(act1) ;

        //sim.simuler(monde);
    }
}

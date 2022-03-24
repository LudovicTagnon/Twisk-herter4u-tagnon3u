package twisk.simulation;

import twisk.monde.Monde;
import twisk.outils.KitC;

public class Simulation {
    KitC kitC;
    public Simulation() {
        kitC = new KitC();
        kitC.creerEnvironnement();
    }

    public native int[] start_simulation(int nbEtapes, int nbServices, int nbClients, int[] tabJetonsServices);
    public native int[] ou_sont_les_clients(int nbEtapes, int nbClients);
    public native void nettoyage();

    public void simuler(Monde monde) {
        kitC.creerFichier(monde.toC());
        kitC.compiler();
        kitC.construireLaLibrairie();
        System.load("/tmp/twisk/libTwisk.so");


        int nbClient = 10;

        int[] tabJetonsGuichet = new int[monde.nbGuichets()]; //ajouter nbjetons
        for (int i = 0; i < monde.nbGuichets(); i++) {
            tabJetonsGuichet[i] = 2;
        }

        int[] tab = start_simulation(monde.nbEtapes(), monde.nbGuichets(), nbClient, tabJetonsGuichet);

        System.out.println("Nombre des clients :");
        for (int i = 0; i < monde.nbEtapes(); i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println("");

        int[] client = ou_sont_les_clients(monde.nbEtapes(), nbClient);

        System.out.println("Emplacements des clients : ");

        while (client[(monde.nbEtapes() - 1) * (nbClient + 1)] < nbClient) {
            client = ou_sont_les_clients(monde.nbEtapes(), nbClient);    //Raffraichit le tableau avec la nouvelle position des clients

            for (int i = 0; i < monde.nbEtapes(); i++) {      //Affichage des clients en fonction du nombre de clients dans l'activité (ou le guichet)
                //Affichage de si i est un SAS ou une activité(ou guichet)
                if (i == 0) {
                    System.out.print("Etape " + i + " (SasEntree): " + client[nbClient * i + i] + " client : ");
                } else if (i == monde.nbEtapes() - 1) {
                    System.out.print("Etape " + i + " (SasSortie): " + client[nbClient * i + i] + " client : ");
                } else {
                    System.out.print("Etape " + i + " (" + monde.getNomEtape(i-1) + "): " + client[nbClient * i + i] + " client : ");
                }

                //Affichage des clients dans l'activité (ou guichet) i
                for (int j = 0; j < client[nbClient * i + i]; j++) {
                    System.out.print(client[nbClient * i + 1 + i + j] + " ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");

            //On met le prog en pause 1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        nettoyage();
    }
}

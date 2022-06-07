package twisk.simulation;

import twisk.monde.Etape;
import twisk.monde.Monde;
import twisk.outils.FabriqueNumero;
import twisk.outils.KitC;
import twisk.outils.SujetObserve;

/**
 * Class Simulation.
 */
public class Simulation extends SujetObserve {
    private KitC kitC;
    private int nbClients;
    private GestionnaireClients gestClients;

    /**
     * Instantiates a new Simulation.
     */
    public Simulation() {
        kitC = new KitC();
        kitC.creerEnvironnement();
        nbClients = 5;
        gestClients = new GestionnaireClients(this.nbClients);
    }

    /**
     * Start simulation int [ ].
     *
     * @param nbEtapes          Le nb etapes
     * @param nbServices        Le nb services
     * @param nbClients         Le nb clients
     * @param tabJetonsServices Le tab jetons services
     * @return Le int [ ]
     */
    public native int[] start_simulation(int nbEtapes, int nbServices, int nbClients, int[] tabJetonsServices);

    /**
     * Ou sont les clients int [ ].
     *
     * @param nbEtapes  Le nb etapes
     * @param nbClients Le nb clients
     * @return Le int [ ]
     */
    public native int[] ou_sont_les_clients(int nbEtapes, int nbClients);

    /**
     * Nettoyage.
     */
    public native void nettoyage();

    /**
     * Simuler.
     *
     * @param monde Le monde
     */
    public void simuler(Monde monde) {
        kitC.creerFichier(monde.toC());
        kitC.compiler();
        kitC.construireLaLibrairie();

        System.out.println(FabriqueNumero.getInstance().getNbMonde());
        System.load("/tmp/twisk/libTwisk" + FabriqueNumero.getInstance().getNbMonde() +".so");

        System.out.println("\tMonde Simulé :");
        System.out.println(monde);

        System.out.println();

        int nbClient = this.nbClients;

        int[] tabJetonsGuichet = new int[monde.nbGuichets()]; //ajouter nbjetons

        int k = 0;
        for (Etape etape : monde){
            if(etape.estUnGuichet()){
                tabJetonsGuichet[k] = etape.getNbJetons();
                k++;
            }
        }

        int[] tab = start_simulation(monde.nbEtapes(), monde.nbGuichets(), nbClient, tabJetonsGuichet);
        gestClients.setClients(tab);

        System.out.println("\tNombre des clients :");
        for (int i = 0; i < this.nbClients; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println("\n");

        int[] client = ou_sont_les_clients(monde.nbEtapes(), nbClient);

        System.out.println("\tEmplacements des clients : ");

        for (int i = 0; i < client.length; i++){
            System.out.print(client[i] + " ");
        }
        System.out.println();

        while (client[(monde.nbEtapes() - 1) * (nbClient + 1)] < nbClient) {
            client = ou_sont_les_clients(monde.nbEtapes(), nbClient);    //Raffraichit le tableau avec la nouvelle position des clients

            for (int i = 0; i < monde.nbEtapes(); i++) {      //Affichage des clients en fonction du nombre de clients dans l'activité (ou le guichet)
                //Affichage de si i est un SAS ou une activité(ou guichet)
                if (i == 0) {
                    System.out.print("Etape " + i + " (SasEntree): " + client[i] + " client : ");
                } else if (i == monde.nbEtapes() - 1) {
                    System.out.print("Etape " + i + " (SasSortie): " + client[nbClient * i + i] + " client : ");
                } else {
                    System.out.print("Etape " + i + " (" + monde.getNomEtape(i-1) + "): " + client[nbClient * i + i] + " client : ");
                }



                //Affichage des clients dans l'activité (ou guichet) i
                int rang = 1;
                for (int j = 0; j < client[nbClient * i + i]; j++) {
                    if(i != 0 && i < monde.nbEtapes()-1){
                        gestClients.allerA(client[nbClient * i + 1 + i + j], monde.getEtape(i-1), rang);
                    }
                    System.out.print(client[nbClient * i + 1 + i + j] +":" + rang + " ");
                    rang++;
                }
                System.out.println();
            }
            System.out.println();

            //On met le prog en pause 1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gestClients.nettoyer();
        nettoyage();

        FabriqueNumero.getInstance().reset();
    }

    /**
     * Set nb clients.
     *
     * @param nbClient Le nb client
     */
    public void setNbClients(int nbClient){
        this.nbClients = nbClient;
    }

    /**
     * Gets gest clients.
     *
     * @return Le gest clients
     */
    public GestionnaireClients getGestClients() {
        return gestClients;
    }
}

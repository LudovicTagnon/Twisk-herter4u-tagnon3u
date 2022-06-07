package twisk.simulation;

import twisk.monde.Etape;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class GestionnaireClients.
 */
public class GestionnaireClients implements Iterable<Client>{

    private ArrayList<Client> clients;
    private int nbClients;

    /**
     * Instantiates a new GestionnaireClients.
     *
     * @param nbClients the nb clients
     */
    public GestionnaireClients(int nbClients) {
        this.nbClients = nbClients;
        clients = new ArrayList<>(this.nbClients);
    }

    /**
     * Instantiates a new GestionnaireClients.
     */
    public GestionnaireClients() {
        clients = new ArrayList<>(this.nbClients);
    }

    /**
     * Modifie clients.
     *
     * @param tabClients the tab clients
     */
    public void setClients(int ... tabClients){
        for (int i = 0; i < tabClients.length; i++) {
            clients.add(new Client(tabClients[i]));
        }
    }

    /**
     * Modifie nb clients.
     *
     * @param nbClients the nb clients
     */
    public void setNbClients(int nbClients){
        this.nbClients = nbClients;
    }

    /**
     * Gets nb clients.
     *
     * @return the nb clients
     */
    public int getNbClients() {
        return nbClients;
    }

    /**
     * Get taille clients int.
     *
     * @return the int
     */
    public int getTailleClients(){
        return this.clients.size();
    }

    /**
     * Aller a.
     *
     * @param numeroClient the numero client
     * @param etape        the etape
     * @param rang         the rang
     */
    public void allerA(int numeroClient, Etape etape, int rang){
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getNumeroClients() == numeroClient){
                clients.get(i).allerA(etape, rang);
            }
        }
    }

    /**
     * Nettoyer.
     */
    public void nettoyer(){
        this.nbClients = 0;
        this.clients.clear();
    }

    @Override
    public Iterator<Client> iterator() {
        return clients.iterator();
    }

    /**
     * Gets clients.
     *
     * @return the clients
     */
    public ArrayList<Client> getClients() {
        return clients;
    }
}

package twisk.simulation;

import twisk.monde.Etape;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionnaireClients implements Iterable<Client>{

    private ArrayList<Client> clients;
    private int nbClients;

    public GestionnaireClients(int nbClients) {
        this.nbClients = nbClients;
        clients = new ArrayList<>(this.nbClients);
    }

    public GestionnaireClients() {
        clients = new ArrayList<>(this.nbClients);
    }

    public void setClients(int ... tabClients){
        for (int i = 0; i < tabClients.length; i++) {
            clients.add(new Client(tabClients[i]));
        }
    }

    public void setNbClients(int nbClients){
        this.nbClients = nbClients;
    }

    public int getNbClients() {
        return nbClients;
    }

    public int getTailleClients(){
        return this.clients.size();
    }

    public void allerA(int numeroClient, Etape etape, int rang){
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getNumeroClients() == numeroClient){
                clients.get(i).allerA(etape, rang);
            }
        }
    }

    public void nettoyer(){
        this.nbClients = 0;
        this.clients.clear();
    }

    @Override
    public Iterator<Client> iterator() {
        return clients.iterator();
    }

    public ArrayList<Client> getClients() {
        return clients;
    }
}

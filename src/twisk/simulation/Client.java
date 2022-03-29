package twisk.simulation;

import twisk.monde.Etape;

public class Client {
    private Etape etape;
    private int numeroClients;
    private int rang;

    public Client(int numero) {
        this.numeroClients = numero;
    }

    public int getNumeroClients() {
        return numeroClients;
    }

    public Etape getEtape() {
        return etape;
    }

    public int getRang() {
        return rang;
    }

    public void allerA(Etape etape, int rang){
        this.etape = etape;
        this.rang = rang;
    }
}

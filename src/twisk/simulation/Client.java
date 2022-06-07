package twisk.simulation;

import twisk.monde.Etape;

/**
 * Class Client.
 */
public class Client {
    private Etape etape;
    private int numeroClients;
    private int rang;

    /**
     * Instantiates a new Client.
     *
     * @param numero Le numero
     */
    public Client(int numero) {
        this.numeroClients = numero;
    }

    /**
     * Retourne le numero clients.
     *
     * @return Le numero clients
     */
    public int getNumeroClients() {
        return numeroClients;
    }

    /**
     * Retourne l'etape.
     *
     * @return L'etape
     */
    public Etape getEtape() {
        return etape;
    }

    /**
     * Retourne le rang.
     *
     * @return Le rang
     */
    public int getRang() {
        return rang;
    }

    /**
     * Aller a.
     *
     * @param etape Le etape
     * @param rang  Le rang
     */
    public void allerA(Etape etape, int rang){
        this.etape = etape;
        this.rang = rang;
    }
}

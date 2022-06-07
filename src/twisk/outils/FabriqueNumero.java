package twisk.outils;

/**
 * Class Fabrique numero.
 */
public class FabriqueNumero {
    private int cptEtape;
    private int cptSemaphore;
    private int nbMonde;

    private static FabriqueNumero instance = new FabriqueNumero();

    /**
     * Retourne instance fabrique numero.
     *
     * @return the fabrique numero
     */
    public static FabriqueNumero getInstance(){
        return instance;
    }

    private FabriqueNumero(){
        this.cptEtape = 0;
        this.cptSemaphore = 1;
        this.nbMonde = 0;
    }

    /**
     * Retourne numero etape int.
     *
     * @return the int
     */
    public int getNumeroEtape(){
        return cptEtape++;
    }

    /**
     * Retourne numero semaphore int.
     *
     * @return the int
     */
    public int getNumeroSemaphore(){
        return cptSemaphore++;
    }

    /**
     * Retourne nb monde.
     *
     * @return the nb monde
     */
    public int getNbMonde() {
        return nbMonde;
    }

    /**
     * Modifie nb monde.
     */
    public void setNbMonde() {
        this.nbMonde++;
    }

    /**
     * Reset.
     */
    public void reset(){
        this.cptEtape = 0;
        this.cptSemaphore = 1;
    }
}
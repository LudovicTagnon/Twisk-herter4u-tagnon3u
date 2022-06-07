package twisk.mondeIG;

/**
 * Class Guichet ig.
 */
public class GuichetIG extends EtapeIG{
    /**
     * Instantiates a new Guichet ig.
     *
     * @param nom  the nom
     * @param idf  the idf
     * @param larg the larg
     * @param haut the haut
     */
    public GuichetIG(String nom, String idf, int larg, int haut) {
        super(nom, idf, larg, haut);
    }

    @Override
    public boolean estUnGuichet() {
        return true;
    }
}

package twisk.mondeIG;

/**
 * Class Activite ig.
 */
public class ActiviteIG extends EtapeIG{
    private boolean actRestreinte;

    /**
     * Instantiates a new Activite ig.
     *
     * @param nom  the nom
     * @param idf  the idf
     * @param larg the larg
     * @param haut the haut
     */
    public ActiviteIG(String nom, String idf, int larg, int haut) {
        super(nom, idf, larg, haut);
        actRestreinte = false;
    }

    @Override
    public boolean estUneActivite() {
        return true;
    }

    @Override
    public boolean estUneActiviteRestreinte() {
        return actRestreinte;
    }

    /**
     * Set act restreinte.
     */
    public void setActRestreinte(){
        this.actRestreinte = true;
    }
}

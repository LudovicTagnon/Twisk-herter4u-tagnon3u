package twisk.mondeIG;

/**
 * Class Point de controle ig.
 */
public class PointDeControleIG {
    private int posCentreX;
    private int posCentreY;
    private EtapeIG etapeRattachee;
    private String idf;

    /**
     * Instantiates a new Point de controle ig.
     *
     * @param posCentreX     the pos centre x
     * @param posCentreY     the pos centre y
     * @param idf            the idf
     * @param etapeRattachee the etape rattachee
     */
    public PointDeControleIG(int posCentreX, int posCentreY, String idf, EtapeIG etapeRattachee) {
        this.posCentreX = posCentreX;
        this.posCentreY = posCentreY;
        this.etapeRattachee = etapeRattachee;
        this.idf = idf;
    }

    /**
     * Gets etape rattachee.
     *
     * @return the etape rattachee
     */
    public EtapeIG getEtapeRattachee() {
        return etapeRattachee;
    }

    /**
     * Gets pos centre x.
     *
     * @return the pos centre x
     */
    public int getPosCentreX() {
        return posCentreX;
    }

    /**
     * Gets pos centre y.
     *
     * @return the pos centre y
     */
    public int getPosCentreY() {
        return posCentreY;
    }

    /**
     * Set pos.
     *
     * @param x the x
     * @param y the y
     */
    public void setPos(int x, int y){
        this.posCentreX = x;
        this.posCentreY = y;
    }

    @Override
    public String toString() {
        return "PointDeControleIG{" +
                "posCentreX=" + posCentreX +
                ", posCentreY=" + posCentreY +
                ", etapeRattachee=" + etapeRattachee +
                '}';
    }
}

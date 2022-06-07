package twisk.mondeIG;

/**
 * Class Arc ig.
 */
public class ArcIG {
    private PointDeControleIG depart;
    private PointDeControleIG arrivee;

    /**
     * Instantiates a new Arc ig.
     *
     * @param depart  the depart
     * @param arrivee the arrivee
     */
    public ArcIG(PointDeControleIG depart, PointDeControleIG arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;
    }

    /**
     * Gets depart.
     *
     * @return the depart
     */
    public PointDeControleIG getDepart() {
        return depart;
    }

    /**
     * Gets arrivee.
     *
     * @return the arrivee
     */
    public PointDeControleIG getArrivee() {
        return arrivee;
    }

    @Override
    public String toString() {
        return "ArcIG{" +
                "depart=" + depart +
                ", arrivee=" + arrivee +
                '}';
    }
}

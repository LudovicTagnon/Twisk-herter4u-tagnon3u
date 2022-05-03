package twisk.mondeIG;

public class ArcIG {
    private PointDeControleIG depart;
    private PointDeControleIG arrivee;

    public ArcIG(PointDeControleIG depart, PointDeControleIG arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;
    }

    public PointDeControleIG getDepart() {
        return depart;
    }

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

package twisk.mondeIG;

public class PointDeControleIG {
    private int posCentreX;
    private int posCentreY;
    private EtapeIG etapeRattachee;

    public PointDeControleIG(int posCentreX, int posCentreY, String idf, EtapeIG etapeRattachee) {
        this.posCentreX = posCentreX;
        this.posCentreY = posCentreY;
        this.etapeRattachee = etapeRattachee;
    }

    public EtapeIG getEtapeRattachee() {
        return etapeRattachee;
    }

    public int getPosCentreX() {
        return posCentreX;
    }

    public int getPosCentreY() {
        return posCentreY;
    }

    @Override
    public String toString() {
        return "PointDeControleIG{" +
                "etapeRattachee=" + etapeRattachee +
                '}';
    }
}

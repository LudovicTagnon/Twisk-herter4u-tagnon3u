package twisk.mondeIG;

public class GuichetIG extends EtapeIG{
    public GuichetIG(String nom, String idf, int larg, int haut) {
        super(nom, idf, larg, haut);
    }

    @Override
    public boolean estUnGuichet() {
        return true;
    }
}

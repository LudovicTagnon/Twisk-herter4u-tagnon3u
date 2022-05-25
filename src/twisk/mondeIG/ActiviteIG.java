package twisk.mondeIG;

public class ActiviteIG extends EtapeIG{
    private boolean actRestreinte;

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

    public void setActRestreinte(){
        this.actRestreinte = true;
    }
}

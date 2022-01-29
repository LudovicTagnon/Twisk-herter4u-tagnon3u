package twisk.twisk;

public class Activite extends Etape{

    protected int tempps;
    protected int ecartTemps;

    public Activite(String nom) {
        super(nom);
    }


    public Activite(String nom, int tempps, int ecartTemps) {
        super(nom);
        this.tempps = tempps;
        this.ecartTemps = ecartTemps;
    }

    public Activite() {
    }

    public boolean estUneActivite(){
        return false;
    }
}

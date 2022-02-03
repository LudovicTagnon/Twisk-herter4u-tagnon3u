package twisk.monde;

public class Activite extends Etape{

    protected int temps;
    protected int ecartTemps;

    public Activite(String nom) {
        super(nom);
    }


    public Activite(String nom, int temps, int ecartTemps) {
        super(nom);
        this.temps = temps;
        this.ecartTemps = ecartTemps;
    }

    public Activite() {
    }

    public boolean estUneActivite(){
        return false;
    }

    @Override
    public String toString() {
        return "Activite{" +
                "temps=" + temps +
                ", ecartTemps=" + ecartTemps +
                ", nom='" + nom + '\'' +
                ", gestSucc=" + gestSucc +
                '}';
    }
}

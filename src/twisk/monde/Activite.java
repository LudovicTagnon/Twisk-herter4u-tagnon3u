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

    public boolean estUneActivite(){
        return true;
    }

    public String toC(){
        StringBuilder ligne = new StringBuilder();
        ligne.append("");
        return String.valueOf(ligne);
    }
}

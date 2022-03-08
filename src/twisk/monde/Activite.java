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
        for(Etape suivant : gestSucc){
            ligne.append( "transfert(" + this.nom + ", " + suivant.nom + ");\n" );
            if(suivant.estUnGuichet() == false && suivant.estUneSortie() == false){
                ligne.append("delai(" + suivant.getTemps() + ", " + suivant.getEcartTemps() + ");\n");
            }

            ligne.append(suivant.toC());
        }
        return String.valueOf(ligne);
    }

    @Override
    public int getTemps() {
        return temps;
    }

    @Override
    public int getEcartTemps() {
        return ecartTemps;
    }
}

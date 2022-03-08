package twisk.monde;

public class SasEntree extends Activite{

    public SasEntree() {
        super("Entree");
    }

    public boolean estUneEntree(){
        return true;
    }

    @Override
    public String toC() {
        ligne.append("entree(" + nom + ");\n");
        ligne.append("delai(" + this.getTemps() + ", " + this.getEcartTemps() + ");\n");

        for(Etape suivant : gestSucc){
            ligne.append("transfert(" + this.nom + ", " + suivant.nom + ");\n");
            if(suivant.estUnGuichet() == false){
                ligne.append("delai(" + suivant.getTemps() + ", " + suivant.getEcartTemps() + ");\n");
            }
            ligne.append(suivant.toC());
        }

        return String.valueOf(ligne);
    }
}

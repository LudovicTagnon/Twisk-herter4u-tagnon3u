package twisk.monde;

public class SasEntree extends Activite{

    public SasEntree() {
        super("Entree");
        this.temps = 5;
        this.ecartTemps = 2;
    }

    @Override
    public String toC() {
        ligne.append("\tentrer(" + nom + ");\n");
        ligne.append("\tdelai(" + this.getTemps() + ", " + this.getEcartTemps() + ");\n");

        for(Etape suivant : gestSucc){
            ligne.append("\ttransfert(" + this.changementNom() + ", " + suivant.changementNom() + ");\n");
            if(suivant.estUnGuichet() == false){
                ligne.append("\tdelai(" + suivant.getTemps() + ", " + suivant.getEcartTemps() + ");\n");
            }
            ligne.append(suivant.toC());
        }

        return String.valueOf(ligne);
    }
}

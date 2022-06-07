package twisk.monde;

/**
 * Class Sas entree.
 */
public class SasEntree extends Activite{

    /**
     * Instantiates a new Sas entree.
     */
    public SasEntree() {
        super("Entree");
        this.temps = 5;
        this.ecartTemps = 2;
    }

    @Override
    public String toC() {
        ligne.append("\tentrer(").append(nom).append(");\n");
        ligne.append("\tdelai(").append(this.getTemps()).append(", ").append(this.getEcartTemps()).append(");\n");

        for(Etape suivant : gestSucc){
            ligne.append("\ttransfert(").append(this.changementNom()).append(", ").append(suivant.changementNom()).append(");\n");
            if(!suivant.estUnGuichet()){
                ligne.append("\tdelai(").append(suivant.getTemps()).append(", ").append(suivant.getEcartTemps()).append(");\n");
            }
            ligne.append(suivant.toC());
        }

        return String.valueOf(ligne);
    }
}

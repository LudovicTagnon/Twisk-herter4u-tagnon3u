package twisk.monde;

/**
 * Class Activite.
 */
public class Activite extends Etape{

    /**
     * The Temps.
     */
    protected int temps;
    /**
     * The Ecart temps.
     */
    protected int ecartTemps;

    /**
     * Instantiates a new Activite.
     *
     * @param nom the nom
     */
    public Activite(String nom) {
        super(nom);
        this.temps = 5;
        this.ecartTemps = 3;
    }


    /**
     * Instantiates a new Activite.
     *
     * @param nom        the nom
     * @param temps      the temps
     * @param ecartTemps the ecart temps
     */
    public Activite(String nom, int temps, int ecartTemps) {
        super(nom);
        this.temps = temps;
        this.ecartTemps = ecartTemps;
    }

    public boolean estUneActivite(){
        return true;
    }

    @Override
    public String toDefine() {
        System.out.println(this.nom + " -> " + gestSucc);
        System.out.println();
        for(Etape suivant : gestSucc){
            ligneDefine.append("#define ").append(this.changementNom()).append(" ").append(this.cptEtape).append("\n");
            ligneDefine.append(suivant.toDefine());
        }
        return String.valueOf(ligneDefine);
    }

    @Override
    public String toC(){
        for(Etape suivant : gestSucc){
            ligne.append("\ttransfert(").append(this.changementNom()).append(", ").append(suivant.changementNom()).append(");\n");
            if(!suivant.estUnGuichet() && !suivant.estUneSortie()){
                ligne.append("\tdelai(").append(suivant.getTemps()).append(", ").append(suivant.getEcartTemps()).append(");\n");
            }
            ligne.append(suivant.toC());
        }
        return String.valueOf(ligne);
    }

    @Override
    public String toSem(){

        for(Etape suivant: gestSucc){
            ligneSem.append(suivant.toSem());
        }
        return String.valueOf(ligneSem);
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

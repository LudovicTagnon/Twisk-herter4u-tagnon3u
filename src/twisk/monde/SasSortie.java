package twisk.monde;

/**
 * The type Sas sortie.
 */
public class SasSortie extends Activite{
    /**
     * Instantiates a new Sas sortie.
     */
    public SasSortie() {
        super("Sortie");
    }

    public boolean estUneSortie(){
        return true;
    }

    @Override
    public String toDefine() {
        ligneDefine.append("#define ").append(this.nom).append(" ").append(this.cptEtape).append("\n");
        return String.valueOf(ligneDefine);
    }
}

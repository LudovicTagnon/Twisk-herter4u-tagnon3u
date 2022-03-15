package twisk.monde;

public class SasSortie extends Activite{
    public SasSortie() {
        super("Sortie");
    }

    public boolean estUneSortie(){
        return true;
    }

    @Override
    public String toDefine() {
        ligneDefine.append("#define " + this.nom + " " + this.cptEtape + "\n" );
        return String.valueOf(ligneDefine);
    }
}

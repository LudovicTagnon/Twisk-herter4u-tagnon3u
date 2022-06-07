package twisk.monde;

import twisk.outils.FabriqueNumero;

/**
 * Class Guichet.
 */
public class Guichet extends Etape{

    private int cptSemaphore;

    /**
     * Instantiates a new Guichet.
     *
     * @param nom the nom
     */
    public Guichet(String nom) {
        super(nom);
        this.nbJetons = 2;
        FabriqueNumero fabNum = FabriqueNumero.getInstance();
        this.cptSemaphore = fabNum.getNumeroSemaphore();
    }

    /**
     * Instantiates a new Guichet.
     *
     * @param nom      the nom
     * @param nbJetons the nb jetons
     */
    public Guichet(String nom, int nbJetons) {
        super(nom);
        this.nbJetons = nbJetons;
        FabriqueNumero fabNum = FabriqueNumero.getInstance();
        this.cptSemaphore = fabNum.getNumeroSemaphore();
    }

    public boolean estUnGuichet(){
        return true;
    }

    @Override
    public String toDefine() {
        for(Etape suivant : gestSucc){
            ligneDefine.append("#define ").append(this.changementNom()).append(" ").append(this.cptEtape).append("\n");
            ligneDefine.append(suivant.toDefine());
        }
        return String.valueOf(ligneDefine);
    }

    @Override
    public String toC() {
        for(Etape suivant : gestSucc) {
            ligne.append("\tP( ids, num_sem_guichet").append(this.cptSemaphore).append(");\n");
            ligne.append("\t\ttransfert(").append(this.changementNom()).append(", ").append(suivant.changementNom()).append(");\n");
            ligne.append("\t\tdelai(").append(suivant.getTemps()).append(", ").append(suivant.getEcartTemps()).append(");\n");
            ligne.append("\tV( ids, num_sem_guichet").append(this.cptSemaphore).append(");\n");
            ligne.append(suivant.toC());
        }
        return String.valueOf(ligne);
    }

    @Override
    public String toSem(){

        for(Etape suivant: gestSucc){
            ligneSem.append("#define num_sem_guichet").append(this.cptSemaphore).append(" ").append(this.cptSemaphore).append("\n");
            ligneSem.append(suivant.toSem());
        }
        return String.valueOf(ligneSem);
    }


}

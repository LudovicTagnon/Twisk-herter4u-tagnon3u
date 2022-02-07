package twisk.monde;

import twisk.outils.FabriqueNumero;

public class Guichet extends Etape{

    private int nbJetons;

    private int cptSemaphore;

    public Guichet(String nom) {
        super(nom);
        FabriqueNumero fabNum = FabriqueNumero.getInstance();
        this.cptSemaphore = fabNum.getNumeroSemaphore();
    }

    public Guichet(String nom, int nbJetons) {
        super(nom);
        this.nbJetons = nbJetons;
        FabriqueNumero fabNum = FabriqueNumero.getInstance();
        this.cptSemaphore = fabNum.getNumeroSemaphore();
    }

    public boolean estUnGuichet(){
        return true;
    }

}

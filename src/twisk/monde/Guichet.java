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

    @Override
    public String toC() {
        for(Etape suivant : gestSucc) {

            ligne.append( "P( ids, num_sem_guichet" + this.cptSemaphore + ");\n" );
            ligne.append("\ttransfert(" + this.nom + ", " + suivant.nom + ");\n" );
            ligne.append("\tdelai(" + suivant.getTemps() + ", " + suivant.getEcartTemps() + ");\n");            ligne.append( "V( ids, num_sem_guichet" + this.cptSemaphore + ");\n" );
            ligne.append(suivant.toC());
        }
        return String.valueOf(ligne);
    }

}

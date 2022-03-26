package twisk.monde;

import twisk.outils.FabriqueNumero;

public class Guichet extends Etape{

    private int cptSemaphore;

    public Guichet(String nom) {
        super(nom);
        this.nbJetons = 2;
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
    public String toDefine() {
        for(Etape suivant : gestSucc){
            ligneDefine.append("#define " + this.changementNom() + " " + this.cptEtape + "\n" );
            ligneDefine.append(suivant.toDefine());
        }
        return String.valueOf(ligneDefine);
    }

    @Override
    public String toC() {
        for(Etape suivant : gestSucc) {

            ligne.append( "\tP( ids, num_sem_guichet" + this.cptSemaphore + ");\n" );
            ligne.append("\t\ttransfert(" + this.changementNom() + ", " + suivant.changementNom() + ");\n" );
            ligne.append("\t\tdelai(" + suivant.getTemps() + ", " + suivant.getEcartTemps() + ");\n");
            ligne.append( "\tV( ids, num_sem_guichet" + this.cptSemaphore + ");\n" );
            ligne.append(suivant.toC());
        }
        return String.valueOf(ligne);
    }

    @Override
    public String toSem(){

        for(Etape suivant: gestSucc){
            ligneSem.append("#define num_sem_guichet" + this.cptSemaphore + " " + this.cptSemaphore + "\n");
            ligneSem.append(suivant.toSem());
        }
        return String.valueOf(ligneSem);
    }


}

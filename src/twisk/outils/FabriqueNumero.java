package twisk.outils;

public class FabriqueNumero {
    private int cptEtape;
    private int cptSemaphore;

    private static FabriqueNumero instance = new FabriqueNumero();

    public static FabriqueNumero getInstance(){
        return instance;
    }

    private FabriqueNumero(){
        this.cptEtape = 0;
        this.cptSemaphore = 1;
    }

    public int getNumeroEtape(){
        return cptEtape++;
    }

    public int getNumeroSemaphore(){
        return cptSemaphore++;
    }

    public void reset(){
        this.cptEtape = 0;
        this.cptSemaphore = 0;
    }
}
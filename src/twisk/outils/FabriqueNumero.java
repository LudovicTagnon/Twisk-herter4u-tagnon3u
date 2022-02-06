package twisk.outils;

public class FabriqueNumero {
    int cptEtape;

    private static FabriqueNumero instance = new FabriqueNumero();

    private FabriqueNumero(){
        this.cptEtape = 0;
    }

    public FabriqueNumero getInstance(){
        return instance;
    }

    public int getNumeroEtape(){
        return cptEtape;
    }

    public void reset(){
        this.cptEtape = 0;
    }

}

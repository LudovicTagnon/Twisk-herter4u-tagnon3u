package twisk.outils;

public class FabriqueIdentifiant {
    private int noEtape;

    private static FabriqueIdentifiant instance = new FabriqueIdentifiant();

    public static FabriqueIdentifiant getInstance(){
        return instance;
    }

    public String getIdentifiantEtape(){
        this.noEtape++;
        return "Etape" + this.noEtape;
    }
}

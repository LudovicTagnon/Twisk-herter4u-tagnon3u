package twisk.outils;

public class FabriqueIdentifiant {
    private int noEtape;
    private int noGuichet;

    private static FabriqueIdentifiant instance = new FabriqueIdentifiant();

    public static FabriqueIdentifiant getInstance(){
        return instance;
    }

    public String getIdentifiantEtape(){
        this.noEtape++;
        return "Etape" + this.noEtape;
    }

    public String getIdentifiantGuichet(){
        this.noGuichet++;
        return "Guichet" + this.noGuichet;
    }
}

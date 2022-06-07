package twisk.outils;

/**
 * Class Fabrique identifiant.
 */
public class FabriqueIdentifiant {
    private int noEtape;
    private int noGuichet;

    private static FabriqueIdentifiant instance = new FabriqueIdentifiant();

    /**
     * Retourne instance fabrique identifiant.
     *
     * @return the fabrique identifiant
     */
    public static FabriqueIdentifiant getInstance(){
        return instance;
    }

    /**
     * Retourne identifiant etape string.
     *
     * @return the string
     */
    public String getIdentifiantEtape(){
        this.noEtape++;
        return "Etape" + this.noEtape;
    }

    /**
     * Retourne identifiant guichet string.
     *
     * @return the string
     */
    public String getIdentifiantGuichet(){
        this.noGuichet++;
        return "Guichet" + this.noGuichet;
    }
}

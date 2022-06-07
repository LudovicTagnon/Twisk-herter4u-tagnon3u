package twisk.outils;

/**
 * Class Taille composants.
 */
public class TailleComposants {
    private int tailleXAct;
    private int tailleYAct;

    private int tailleXGui;
    private int tailleYGui;

    private int tailleEcranX;
    private int tailleEcranY;

    private int radiusCircle;

    private static TailleComposants instance = new TailleComposants();

    /**
     * Retourne instance taille composants.
     *
     * @return the taille composants
     */
    public static TailleComposants getInstance(){
        return instance;
    }

    private TailleComposants(){
        this.tailleXAct = 160;
        this.tailleYAct = 75;

        this.tailleXGui = 220;
        this.tailleYGui= 40;

        this.tailleEcranX = 1200;
        this.tailleEcranY = 800;

        this.radiusCircle = 7;
    }

    /**
     * Retourne taille x act.
     *
     * @return the taille x act
     */
    public int getTailleXAct() {
        return tailleXAct;
    }

    /**
     * Retourne taille y act.
     *
     * @return the taille y act
     */
    public int getTailleYAct() {
        return tailleYAct;
    }

    /**
     * Retourne taille ecran x.
     *
     * @return the taille ecran x
     */
    public int getTailleEcranX() {
        return tailleEcranX;
    }

    /**
     * Retourne taille ecran y.
     *
     * @return the taille ecran y
     */
    public int getTailleEcranY() {
        return tailleEcranY;
    }

    /**
     * Retourne radius circle.
     *
     * @return the radius circle
     */
    public int getRadiusCircle() {
        return radiusCircle;
    }

    /**
     * Retourne taille x gui.
     *
     * @return the taille x gui
     */
    public int getTailleXGui() {
        return tailleXGui;
    }

    /**
     * Retourne taille y gui.
     *
     * @return the taille y gui
     */
    public int getTailleYGui() {
        return tailleYGui;
    }
}

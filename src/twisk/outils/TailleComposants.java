package twisk.outils;

public class TailleComposants {
    private int tailleXAct;
    private int tailleYAct;

    private int tailleXGui;
    private int tailleYGui;

    private int tailleEcranX;
    private int tailleEcranY;

    private int radiusCircle;

    private static TailleComposants instance = new TailleComposants();

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

    public int getTailleXAct() {
        return tailleXAct;
    }

    public int getTailleYAct() {
        return tailleYAct;
    }

    public int getTailleEcranX() {
        return tailleEcranX;
    }

    public int getTailleEcranY() {
        return tailleEcranY;
    }

    public int getRadiusCircle() {
        return radiusCircle;
    }

    public int getTailleXGui() {
        return tailleXGui;
    }

    public int getTailleYGui() {
        return tailleYGui;
    }
}

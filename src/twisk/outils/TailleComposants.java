package twisk.outils;

public class TailleComposants {
    private int tailleXAct;
    private int tailleYAct;

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
}

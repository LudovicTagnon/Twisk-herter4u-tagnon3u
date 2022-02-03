package twisk.monde;

public class ActiviteRestreinte extends Activite{
    public ActiviteRestreinte(String nom) {
        super(nom);
    }

    public ActiviteRestreinte(String nom, int tempps, int ecartTemps) {
        super(nom, tempps, ecartTemps);
    }
}

package twisk.monde;

public class ActiviteRestreinte extends Activite{
    public ActiviteRestreinte(String nom) {
        super(nom);
    }

    public ActiviteRestreinte(String nom, int tempps, int ecartTemps) {
        super(nom, tempps, ecartTemps);
    }

    @Override
    public String toString() {
        return "ActiviteRestreinte{" +
                "temps=" + temps +
                ", ecartTemps=" + ecartTemps +
                ", nom='" + nom + '\'' +
                ", gestSucc=" + gestSucc +
                '}';
    }
}

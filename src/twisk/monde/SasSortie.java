package twisk.monde;

public class SasSortie extends Activite{

    public SasSortie() {
        super("Sortie");
    }

    @Override
    public String toString() {
        return "SasSortie{" +
                "temps=" + temps +
                ", ecartTemps=" + ecartTemps +
                ", nom='" + nom + '\'' +
                ", gestSucc=" + gestSucc +
                '}';
    }
}

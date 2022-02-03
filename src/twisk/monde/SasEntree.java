package twisk.monde;

public class SasEntree extends Activite{

    public SasEntree() {
    }

    @Override
    public String toString() {
        return "SasEntree{" +
                "temps=" + temps +
                ", ecartTemps=" + ecartTemps +
                ", nom='" + nom + '\'' +
                ", gestSucc=" + gestSucc +
                '}';
    }
}

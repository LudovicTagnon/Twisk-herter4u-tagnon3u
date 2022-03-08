package twisk.monde;

public class SasEntree extends Activite{

    public SasEntree() {
        super("Entrée");
    }

    @Override
    public String toC() {
        StringBuilder ligne = new StringBuilder();
        ligne.append("entree(" + nom + ");\n");
        return String.valueOf(ligne);
    }
}

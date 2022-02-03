package twisk.monde;

public class Guichet extends Etape{

    private int nbJetons;

    public Guichet(String nom) {
        super(nom);
    }

    public Guichet(String nom, int nbJetons) {
        super(nom);
        this.nbJetons = nbJetons;
    }

    public boolean estUnGuichet(){
        return false;
    }

    @Override
    public String toString() {
        return "Guichet{" +
                "nom='" + nom + '\'' +
                ", gestSucc=" + gestSucc +
                '}';
    }


}

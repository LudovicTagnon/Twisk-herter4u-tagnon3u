package twisk.twisk;

import java.util.Iterator;

public abstract class Etape implements Iterable<Etape>{

    protected String nom;
    protected GestionnaireSuccesseurs gestSucc;

    public Etape(String nom) {
        this.nom = nom;
    }

    protected Etape() {
    }


    public void ajouterSuccesseur(Etape ... etapes){

    }

    public boolean estUneActivite(){
        return false;
    }

    public boolean estUnGuichet(){
        return false;
    }

    @Override
    public Iterator<Etape> iterator() {
        return null;
    }
}

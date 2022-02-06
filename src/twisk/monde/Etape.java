package twisk.monde;

import java.util.Iterator;

public abstract class Etape implements Iterable<Etape>{

    protected String nom;
    protected GestionnaireSuccesseurs gestSucc;

    public Etape(String nom) {
        this.nom = nom;
        this.gestSucc = new GestionnaireSuccesseurs();
    }

    public void ajouterSuccesseur(Etape ... etapes){
        this.gestSucc.ajouter(etapes);
    }

    public boolean estUneActivite(){
        return false;
    }

    public boolean estUnGuichet(){
        return false;
    }

    public int nbEtapes(){              // utile pour test ajouterSuccesseur()
        return gestSucc.nbEtapes();
    }

    @Override
    public Iterator<Etape> iterator() {
        return this.iterator();
    }

    @Override
    public String toString() {
        return nom + " : " + nbEtapes() + " successeurs = " + gestSucc;
    }
}

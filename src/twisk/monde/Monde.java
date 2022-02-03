package twisk.monde;

import java.util.Iterator;

public class Monde implements Iterable<Etape>{

    private GestionnaireEtapes lesEtapes;
    private SasEntree entree;
    private SasSortie sortie;

    public Monde(){
        this.lesEtapes = new GestionnaireEtapes();
        this.entree = new SasEntree();
        this.sortie = new SasSortie();
    }

    public void aCommmeEntree(Etape ... etapes){
        this.entree.ajouterSuccesseur(etapes);
    }

    public void aCommmeSortie(Etape ... etapes){
        for(Etape e : etapes) {
            e.ajouterSuccesseur(this.sortie);
        }
    }

    public void ajouter(Etape ... etapes){
        this.lesEtapes.ajouter(etapes);
    }

    public int nbEtapes(){
        return this.lesEtapes.nbEtapes();
    }


    public int nbGuichets(){
        int S=0;
        for (Etape E : lesEtapes){
            if (E.estUnGuichet()){
                S++;
            }
        }
        return S;
    }


    @Override
    public Iterator<Etape> iterator() {
        return null;
    }

    @Override
    public String toString() {
        return "Monde{" +
                "gestEtap=" + gestEtap +
                '}';
    }
}

package twisk.monde;

import java.util.Iterator;

public class Monde implements Iterable<Etape>{

    private GestionnaireEtapes gestEtap;

    public Monde(){

    }

    public void aCommmeEntree(Etape ... etapes){

    }

    public void aCommmeSortie(Etape ... etapes){

    }

    public void ajouter(Etape ... etapes){

    }

    public int nbEtapes(){
        return 0;
    }


    public int nbGuichets(){
        return 0;
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

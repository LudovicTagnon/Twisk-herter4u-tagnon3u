package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionnaireSuccesseurs implements Iterable<Etape>{

    private ArrayList<Etape> etapes;

    public GestionnaireSuccesseurs() {
        this.etapes = new ArrayList<Etape>(10);
    }

    public void ajouter(Etape ... etapes){
        for (int i = 0; i < etapes.length; i++) {
            this.etapes.add(etapes[i]);
        }
    }

    public int nbEtapes(){
        return this.etapes.size();
    }

    @Override
    public Iterator<Etape> iterator() {
        return this.etapes.iterator();
    }

    @Override
    public String toString() {
        return "GestionnaireSuccesseurs{" +
                "etapes=" + etapes +
                '}';
    }
}

package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionnaireSuccesseurs implements Iterable<Etape>{

    private ArrayList<Etape> etapes;

    public GestionnaireSuccesseurs() {

    }

    public void ajouter(Etape ... etapes){

    }

    public int nbEtapes(){
        return 0;
    }

    @Override
    public Iterator<Etape> iterator() {
        return null;
    }

    @Override
    public String toString() {
        return "GestionnaireSuccesseurs{" +
                "etapes=" + etapes +
                '}';
    }
}

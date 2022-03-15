package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionnaireSuccesseurs implements Iterable<Etape>{

    private ArrayList<Etape> etapes;

    public GestionnaireSuccesseurs() {
        this.etapes = new ArrayList<>(10);
    }

    public void ajouter(Etape ... etapes){
        for (Etape etape : etapes) {
            this.etapes.add(etape);
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
        StringBuilder succ = new StringBuilder();
        for(int i = 0; i < nbEtapes(); i++){
            succ.append(this.etapes.get(i).nom);
            if(i < nbEtapes() - 1){
                succ.append(" - ");
            }
        }

        return succ.toString();
    }
}

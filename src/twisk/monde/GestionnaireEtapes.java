package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class Gestionnaire etapes.
 */
public class GestionnaireEtapes implements Iterable<Etape>{

    private ArrayList<Etape> etapes;

    /**
     * Instantiates a new Gestionnaire etapes.
     */
    public GestionnaireEtapes(){
        this.etapes = new ArrayList<>(10);
    }

    /**
     * Ajouter.
     *
     * @param etapes the etapes
     */
    public void ajouter(Etape ... etapes){
        for (Etape etape : etapes) {
            this.etapes.add(etape);
        }
    }

    /**
     * Get nom etape string.
     *
     * @param i the
     * @return the string
     */
    public String getNomEtape(int i){
        return this.etapes.get(i).getNom();
    }

    /**
     * Get etape etape.
     *
     * @param i the
     * @return the etape
     */
    public Etape getEtape(int i){
        return this.etapes.get(i);
    }

    /**
     * Nb etapes int.
     *
     * @return the int
     */
    public int nbEtapes(){
        return this.etapes.size();
    }

    @Override
    public Iterator<Etape> iterator() {
        return this.etapes.iterator();
    }

    @Override
    public String toString() {
        return "GestionnaireEtapes{" +
                "etapes=" + etapes +
                '}';
    }

}

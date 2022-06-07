package twisk.outils;

import twisk.monde.Etape;
import twisk.mondeIG.EtapeIG;

import java.util.HashMap;

/**
 * Class Correspondance etapes.
 */
public class CorrespondanceEtapes {

    private HashMap<EtapeIG, Etape> correspondance;
    private HashMap<Etape, EtapeIG> correspondanceInverse;

    /**
     * Instantiates a new Correspondance etapes.
     */
    public CorrespondanceEtapes() {
        correspondance = new HashMap<>();
        correspondanceInverse = new HashMap<>();
    }

    /**
     * Ajouter.
     *
     * @param etig the etig
     * @param et   the et
     */
    public void ajouter(EtapeIG etig, Etape et){
        correspondance.put(etig, et);
        correspondanceInverse.put(et, etig);
    }

    /**
     * Retourne etape etape.
     *
     * @param e the e
     * @return the etape
     */
    public Etape getEtape(EtapeIG e){
        return correspondance.get(e);
    }

    /**
     * Retourne etape ig etape ig.
     *
     * @param e the e
     * @return the etape ig
     */
    public EtapeIG getEtapeIG(Etape e){
        return correspondanceInverse.get(e);
    }

    /**
     * Modifie entree.
     *
     * @param eg the eg
     */
    public void setEntree(EtapeIG eg){
        correspondance.get(eg).estUneEntree();
    }

    /**
     * Modifie sortie.
     *
     * @param eg the eg
     */
    public void setSortie(EtapeIG eg){
        correspondance.get(eg).estUneSortie();
    }


}


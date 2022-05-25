package twisk.outils;

import twisk.monde.Etape;
import twisk.mondeIG.EtapeIG;

import java.util.HashMap;

public class CorrespondanceEtapes {

    private HashMap<EtapeIG, Etape> correspondance;

    public CorrespondanceEtapes() {
        correspondance = new HashMap<>();
    }

    public void ajouter(EtapeIG etig, Etape et){
        correspondance.put(etig, et);
    }

    public Etape get(EtapeIG e){
        return correspondance.get(e);
    }

    public void setEntree(EtapeIG eg){
        correspondance.get(eg).estUneEntree();

    }

    public void setSortie(EtapeIG eg){
        correspondance.get(eg).estUneSortie();
    }


}


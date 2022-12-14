package twisk.outils;

import twisk.vues.Observateur;

import java.util.ArrayList;

/**
 * Class Sujet observe.
 */
public class SujetObserve {
    private ArrayList<Observateur> o = new ArrayList<>(10);

    /**
     * Ajouter observateur.
     *
     * @param o the o
     */
    public void ajouterObservateur(Observateur o){
        this.o.add(o);
    }

    /**
     * Notifier observateur.
     */
    public void notifierObservateur(){
        for (int i = 0; i < this.o.size(); i++) {
            o.get(i).reagir();
        }
    }
}

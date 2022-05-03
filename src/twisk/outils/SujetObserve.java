package twisk.outils;

import twisk.vues.Observateur;

import java.util.ArrayList;

public class SujetObserve {
    private ArrayList<Observateur> o = new ArrayList<>(10);

    public void ajouterObservateur(Observateur o){
        this.o.add(o);
    }

    public void notifierObservateur(){
        for (int i = 0; i < this.o.size(); i++) {
            o.get(i).reagir();
        }
    }
}

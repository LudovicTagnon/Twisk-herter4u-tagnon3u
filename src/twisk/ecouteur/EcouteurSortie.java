package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurSortie implements EventHandler {
    private MondeIG mondeIG;

    public EcouteurSortie(MondeIG mondeIG) {
        this.mondeIG = mondeIG;
    }

    @Override
    public void handle(Event event) {
        this.mondeIG.changementSortie();
        this.mondeIG.enleverTouteSelectionEtape();
    }
}
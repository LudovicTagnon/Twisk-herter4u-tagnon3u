package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurEffacerSelection implements EventHandler {
    private MondeIG mondeIG;
    public EcouteurEffacerSelection(MondeIG monde) {
        this.mondeIG = monde;
    }

    @Override
    public void handle(Event event) {
        this.mondeIG.enleverTouteSelectionEtape();
    }
}

package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

/**
 * Class Ecouteur effacer selection.
 */
public class EcouteurEffacerSelection implements EventHandler {
    private MondeIG mondeIG;

    /**
     * Instantiates a new Ecouteur effacer selection.
     *
     * @param monde the monde
     */
    public EcouteurEffacerSelection(MondeIG monde) {
        this.mondeIG = monde;
    }

    @Override
    public void handle(Event event) {
        this.mondeIG.enleverTouteSelectionEtape();
    }
}

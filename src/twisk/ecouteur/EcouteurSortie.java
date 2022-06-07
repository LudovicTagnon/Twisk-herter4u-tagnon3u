package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

/**
 * The type Ecouteur sortie.
 */
public class EcouteurSortie implements EventHandler {
    private MondeIG mondeIG;

    /**
     * Instantiates a new Ecouteur sortie.
     *
     * @param mondeIG the monde ig
     */
    public EcouteurSortie(MondeIG mondeIG) {
        this.mondeIG = mondeIG;
    }

    @Override
    public void handle(Event event) {
        this.mondeIG.changementSortie();
        this.mondeIG.enleverTouteSelectionEtape();
    }
}

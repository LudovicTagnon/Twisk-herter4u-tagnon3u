package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

/**
 * Class Ecouteur entree.
 */
public class EcouteurEntree implements EventHandler {
    private MondeIG mondeIG;

    /**
     * Instantiates a new Ecouteur entree.
     *
     * @param mondeIG the monde ig
     */
    public EcouteurEntree(MondeIG mondeIG) {
        this.mondeIG = mondeIG;
    }

    @Override
    public void handle(Event event) {
        this.mondeIG.changementEntree();

        this.mondeIG.enleverTouteSelectionEtape();
    }
}

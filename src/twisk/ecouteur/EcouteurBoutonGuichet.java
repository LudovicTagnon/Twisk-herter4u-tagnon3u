package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

/**
 * Class Ecouteur bouton guichet.
 */
public class EcouteurBoutonGuichet implements EventHandler {
    private MondeIG mondeIG;

    /**
     * Instantiates a new Ecouteur bouton guichet.
     *
     * @param mondeIG the monde ig
     */
    public EcouteurBoutonGuichet(MondeIG mondeIG) {
        this.mondeIG = mondeIG;
    }

    @Override
    public void handle(Event event) {
        mondeIG.ajouter("Guichet");
    }
}

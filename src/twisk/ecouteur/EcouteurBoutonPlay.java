package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.exceptions.MondeException;
import twisk.mondeIG.MondeIG;

/**
 * Class Ecouteur bouton play.
 */
public class EcouteurBoutonPlay implements EventHandler {
    /**
     * The Monde.
     */
    MondeIG monde;

    /**
     * Instantiates a new Ecouteur bouton play.
     *
     * @param monde the monde
     */
    public EcouteurBoutonPlay(MondeIG monde) {
        this.monde = monde;
    }

    @Override
    public void handle(Event event) {
        try {
            monde.simuler();
        } catch (MondeException ignored) {

        }
    }
}

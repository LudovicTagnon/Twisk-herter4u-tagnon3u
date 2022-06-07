package twisk.ecouteur;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * The type Ecouteur quitter.
 */
public class EcouteurQuitter implements EventHandler {
    @Override
    public void handle(Event event) {
        Platform.exit();
    }
}

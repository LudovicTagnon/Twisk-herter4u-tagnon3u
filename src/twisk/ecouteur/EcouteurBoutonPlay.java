package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.exceptions.MondeException;
import twisk.mondeIG.MondeIG;

public class EcouteurBoutonPlay implements EventHandler {
    MondeIG monde;

    public EcouteurBoutonPlay(MondeIG monde) {
        this.monde = monde;
    }

    @Override
    public void handle(Event event) {
        try {
            monde.simuler();
        } catch (MondeException e) {

        }
    }
}

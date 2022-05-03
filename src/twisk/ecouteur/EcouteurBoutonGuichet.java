package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurBoutonGuichet implements EventHandler {
    private MondeIG mondeIG;

    public EcouteurBoutonGuichet(MondeIG mondeIG) {
        this.mondeIG = mondeIG;
    }

    @Override
    public void handle(Event event) {
        mondeIG.ajouter("Guichet");
    }
}

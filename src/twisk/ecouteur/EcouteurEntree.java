package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurEntree implements EventHandler {
    private MondeIG mondeIG;

    public EcouteurEntree(MondeIG mondeIG) {
        this.mondeIG = mondeIG;
    }

    @Override
    public void handle(Event event) {
        this.mondeIG.changementEntree();
    }
}

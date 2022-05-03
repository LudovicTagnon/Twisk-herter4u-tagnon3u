package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurBoutonActivite implements EventHandler {
    private MondeIG mondeIG;

    public EcouteurBoutonActivite(MondeIG mondeIG) {
        this.mondeIG = mondeIG;
    }

    @Override
    public void handle(Event event) {
        mondeIG.ajouter("Activité");
    }
}

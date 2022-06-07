package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

/**
 * Class Ecouteur bouton activite.
 */
public class EcouteurBoutonActivite implements EventHandler {
    private MondeIG mondeIG;

    /**
     * Instantiates a new Ecouteur bouton activite.
     *
     * @param mondeIG the monde ig
     */
    public EcouteurBoutonActivite(MondeIG mondeIG) {
        this.mondeIG = mondeIG;
    }

    @Override
    public void handle(Event event) {
        mondeIG.ajouter("Activité");
    }
}

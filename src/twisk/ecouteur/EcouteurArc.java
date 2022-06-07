package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;

/**
 * Class Ecouteur arc.
 */
public class EcouteurArc implements EventHandler {
    private ArcIG arcIG;
    private MondeIG mondeIG;

    /**
     * Instantiates a new Ecouteur arc.
     *
     * @param arcIG   the arc ig
     * @param mondeIG the monde ig
     */
    public EcouteurArc(ArcIG arcIG, MondeIG mondeIG) {
        this.arcIG = arcIG;
        this.mondeIG = mondeIG;
    }

    @Override
    public void handle(Event event) {
        if (this.mondeIG.estSelectionneeArc(this.arcIG)){
            this.mondeIG.enleverSelectionArc(arcIG);
        }else{
            this.mondeIG.ajouterSelectionArc(arcIG);
        }
    }
}

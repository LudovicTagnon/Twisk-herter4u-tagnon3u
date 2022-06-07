package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The type Ecouteur supprimer selection.
 */
public class EcouteurSupprimerSelection implements EventHandler {
    private MondeIG monde;

    /**
     * Instantiates a new Ecouteur supprimer selection.
     *
     * @param monde the monde
     */
    public EcouteurSupprimerSelection(MondeIG monde) {
        this.monde = monde;
    }

    @Override
    public void handle(Event event) {
        Iterator<EtapeIG> it = this.monde.iteratorEtapesSelectionnees();
        while (it.hasNext()){
            EtapeIG etape = it.next();

            this.monde.supprimerEtape(etape);
            ArrayList<ArcIG> arcAttachee = this.monde.arcRattachee(etape);
            for (ArcIG arcIG : arcAttachee) {
                this.monde.supprimerArc(arcIG);
            }
            this.monde.setDepart(null);
        }
        this.monde.enleverTouteSelectionEtape();

        Iterator<ArcIG> itArc = this.monde.iteratorArcSelectionnees();
        while (itArc.hasNext()){
            ArcIG arc = itArc.next();

            this.monde.supprimerArc(arc);
        }
        this.monde.enleverTouteSelectionArc();
    }
}

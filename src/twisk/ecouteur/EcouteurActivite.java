package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurActivite implements EventHandler {
    private MondeIG monde;
    private EtapeIG etape;

    public EcouteurActivite(MondeIG monde, EtapeIG etape) {
        this.monde = monde;
        this.etape = etape;
    }

    @Override
    public void handle(Event event) {
        if(this.monde.estSelectionneeEtape(etape)){
            this.monde.enleverSelectionEtape(etape);
        }else{
            this.monde.ajouterSelectionEtape(etape);
        }
    }
}

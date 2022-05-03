package twisk.vues;

import javafx.scene.shape.Circle;
import twisk.ecouteur.EcouteurPointDeControle;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.outils.TailleComposants;

public class VuePointDeControleIG extends Circle implements Observateur {
    public VuePointDeControleIG(MondeIG m, PointDeControleIG pointDeControleIG){
        m.ajouterObservateur(this);

        this.setCenterX(pointDeControleIG.getPosCentreX());
        this.setCenterY(pointDeControleIG.getPosCentreY());

        this.setRadius(TailleComposants.getInstance().getRadiusCircle());

        this.setOnMouseClicked(new EcouteurPointDeControle(m, pointDeControleIG, this));
    }

    @Override
    public void reagir() {

    }
}

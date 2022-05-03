package twisk.vues;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import twisk.ecouteur.EcouteurArc;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;

public class VueArcIG extends Pane implements Observateur{
    private Line ligne;
    private Polyline fleche;
    private ArcIG arcIG;
    private MondeIG monde;

    public VueArcIG(MondeIG monde, ArcIG arc){
        monde.ajouterObservateur(this);

        this.monde = monde;
        this.arcIG = arc;

        this.ligne = new Line();
        ligne.setStartX(arc.getDepart().getPosCentreX());
        ligne.setStartY(arc.getDepart().getPosCentreY());

        ligne.setEndX(arc.getArrivee().getPosCentreX());
        ligne.setEndY(arc.getArrivee().getPosCentreY());

        ligne.setStrokeWidth(3);
        ligne.setStroke(Color.web("#275461"));

        this.fleche = new Polyline();

        double debutX = ligne.getStartX();
        double debutY = ligne.getStartY();
        double finX = ligne.getEndX();
        double finY = ligne.getEndY();

        double slope = (debutY-finY)/(debutX-finX);
        double angle = Math.atan(slope);
        double arrowAngle;
        if(debutX > finX){
            arrowAngle = Math.toRadians(45);
        }else{
            arrowAngle = -Math.toRadians(225);
        }
        double arrowLength = 19;

        double P1X = finX + arrowLength * Math.cos(angle-arrowAngle);
        double P1Y = finY + arrowLength * Math.sin(angle-arrowAngle);
        double P2X = finX + arrowLength * Math.cos(angle+arrowAngle);
        double P2Y = finY + arrowLength * Math.sin(angle+arrowAngle);

        fleche.getPoints().addAll(finX, finY,
                P1X, P1Y,
                P2X, P2Y,
                finX, finY);

        fleche.setStyle("-fx-fill : #869DA3;");

        if (this.monde.estSelectionneeArc(this.arcIG)){
            this.ligne.setStroke(Color.WHITE);
            this.fleche.setStroke(Color.WHITE);
        }

        this.ligne.setOnMouseClicked(new EcouteurArc(this.arcIG, monde));

        this.getChildren().addAll(ligne, fleche);
    }

    @Override
    public void reagir() {
    }
}

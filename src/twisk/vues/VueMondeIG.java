package twisk.vues;

import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.outils.TailleComposants;

import java.util.Iterator;

public class VueMondeIG extends Pane implements Observateur {
    private MondeIG mondeIG;

    public VueMondeIG(MondeIG mondeIG){
        mondeIG.ajouterObservateur(this);
        this.mondeIG = mondeIG;

        this.setBackground(new Background(new BackgroundFill(Color.web("#B8D8E0"), null, null)));

        for(EtapeIG etape : mondeIG){
            VueEtapeIG vueEtapeIG = new VueActiviteIG(mondeIG, etape);

            TailleComposants tailleComposants = TailleComposants.getInstance();

            vueEtapeIG.setMinWidth(tailleComposants.getTailleXAct());
            vueEtapeIG.setMaxWidth(tailleComposants.getTailleXAct());

            vueEtapeIG.setMinHeight(tailleComposants.getTailleYAct());
            vueEtapeIG.setMaxHeight(tailleComposants.getTailleYAct());

            vueEtapeIG.setStyle("-fx-background-color: #275461; -fx-border-color: #4F5D61; -fx-background-radius: 3px, 3px, 0px, 0px; -fx-border-radius: 3 3 0 0;");

            vueEtapeIG.relocate(etape.getPosX(), etape.getPosY());


            this.getChildren().add(vueEtapeIG);
        }

        this.setOnDragDropped((DragEvent dragEvent) -> {
            boolean success = false;
            try {
                Dragboard dragBroard = dragEvent.getDragboard();
                mondeIG.setPosEtape(dragBroard.getString(), (int) dragEvent.getX(), (int) dragEvent.getY());
                success = true;
            } catch (Exception ignored) {
            } finally {
                dragEvent.setDropCompleted(success);
                dragEvent.consume();
            }
        });

        this.setOnDragOver((DragEvent dragEvent) -> {
            dragEvent.acceptTransferModes(TransferMode.MOVE);
            dragEvent.consume();
        });

    }

    @Override
    public void reagir() {
        this.getChildren().clear();

        Iterator<ArcIG> it = mondeIG.iteratorArc();
        while (it.hasNext()){
            ArcIG arc = it.next();

            this.getChildren().add(new VueArcIG(mondeIG, arc));
        }

        for(EtapeIG etape : mondeIG){
            VueEtapeIG vueEtapeIG = new VueActiviteIG(mondeIG, etape);

            TailleComposants tailleComposants = TailleComposants.getInstance();

            vueEtapeIG.setMinWidth(tailleComposants.getTailleXAct());
            vueEtapeIG.setMaxWidth(tailleComposants.getTailleXAct());

            vueEtapeIG.setMinHeight(tailleComposants.getTailleYAct());
            vueEtapeIG.setMaxHeight(tailleComposants.getTailleYAct());

            if (this.mondeIG.estSelectionneeEtape(etape)){
                vueEtapeIG.setStyle("-fx-background-color: #275461; -fx-border-color: #FFFFFF; -fx-background-radius: 3px, 3px, 0px, 0px; -fx-border-radius: 3 3 0 0;");
            }else{
                vueEtapeIG.setStyle("-fx-background-color: #275461; -fx-border-color: #4F5D61; -fx-background-radius: 3px, 3px, 0px, 0px; -fx-border-radius: 3 3 0 0;");
            }

            vueEtapeIG.relocate(etape.getPosX(), etape.getPosY());

            for(PointDeControleIG point: etape){
                VuePointDeControleIG vue = new VuePointDeControleIG(mondeIG, point);
                this.getChildren().add(vue);
            }
            this.getChildren().add(vueEtapeIG);
        }
    }
}
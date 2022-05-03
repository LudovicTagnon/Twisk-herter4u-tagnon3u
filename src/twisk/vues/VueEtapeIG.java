package twisk.vues;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import twisk.ecouteur.EcouteurActivite;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.outils.TailleComposants;

public abstract class VueEtapeIG extends VBox implements Observateur {
    protected EtapeIG etapes;
    protected Label label;

    public VueEtapeIG(MondeIG mondeIG, EtapeIG etapeIG){
        mondeIG.ajouterObservateur(this);
        this.etapes = etapeIG;

        this.label = new Label(this.etapes.getNom() + " (t = " + this.etapes.getDelai() + ", e-t = " + this.etapes.getEcartTemps() + ")");
        this.label.setMinWidth(TailleComposants.getInstance().getTailleXAct());
        this.label.setAlignment(Pos.CENTER);
        this.label.setMinHeight(17);
        this.label.setStyle("-fx-text-fill:white");

        this.setOnMouseClicked(new EcouteurActivite(mondeIG, this.etapes));

        this.setOnDragDetected(mouseEvent -> {
            Dragboard dragboard = this.startDragAndDrop(TransferMode.MOVE);

            ClipboardContent content = new ClipboardContent();
            content.putString(this.etapes.getIdentifiant());

            WritableImage capture = this.snapshot(null, null);
            content.putImage(capture);

            dragboard.setContent(content);
            mouseEvent.consume();
        });

        this.getChildren().add(label);
    }
}

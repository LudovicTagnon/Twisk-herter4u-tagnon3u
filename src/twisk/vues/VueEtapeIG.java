package twisk.vues;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import twisk.ecouteur.EcouteurEtape;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.outils.TailleComposants;

/**
 * Class VueEtapeIG.
 */
public abstract class VueEtapeIG extends VBox implements Observateur {
    /**
     * Les étapes.
     */
    protected EtapeIG etapes;
    /**
     * Le Label.
     */
    protected Label label;

    /**
     * Instantiates a new VueEtapeIG.
     *
     * @param mondeIG Le monde
     * @param etapeIG L'etape
     */
    public VueEtapeIG(MondeIG mondeIG, EtapeIG etapeIG){
        mondeIG.ajouterObservateur(this);
        this.etapes = etapeIG;

        if (this.etapes.estUneActivite()){
            this.label = new Label(this.etapes.getNom() + " (t = " + this.etapes.getDelai() + ", e-t = " + this.etapes.getEcartTemps() + ")");
            this.label.setMinWidth(TailleComposants.getInstance().getTailleXAct());
        }else if(this.etapes.estUnGuichet()){
            this.label = new Label(this.etapes.getNom() + " (Jetons = " + this.etapes.getNbJetons() + ")");
            this.label.setMinWidth(TailleComposants.getInstance().getTailleXGui());
        }

        this.label.setAlignment(Pos.CENTER);
        this.label.setMinHeight(17);
        this.label.setStyle("-fx-text-fill:white");

        this.setOnMouseClicked(new EcouteurEtape(mondeIG, this.etapes));

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

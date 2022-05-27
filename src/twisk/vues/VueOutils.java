package twisk.vues;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import twisk.ecouteur.EcouteurBoutonActivite;
import twisk.ecouteur.EcouteurBoutonGuichet;
import twisk.mondeIG.MondeIG;

public class VueOutils extends TilePane implements Observateur{

    public VueOutils(MondeIG monde){
        monde.ajouterObservateur(this);

        this.setBackground(new Background(new BackgroundFill(Color.web("#869DA3"), null, null)));

        Button boutonActivite = new Button("Ajouter Activité");
        boutonActivite.setFont(new Font(15));

        Tooltip tooltip = new Tooltip("Ajouter une activité");
        tooltip.setShowDelay(Duration.millis(250));
        boutonActivite.setTooltip(tooltip);

        boutonActivite.setOnAction(new EcouteurBoutonActivite(monde));

        Button boutonGuichet = new Button("Ajouter Guichet");
        boutonGuichet.setFont(new Font(15));

        Tooltip tooltipGui = new Tooltip("Ajouter un guichet");
        tooltip.setShowDelay(Duration.millis(250));
        boutonGuichet.setTooltip(tooltipGui);

        boutonGuichet.setOnAction(new EcouteurBoutonGuichet(monde));

        Rectangle[] rectangles = new Rectangle[2];

        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new Rectangle(30, 20);
        }

        rectangles[0].setStyle("-fx-fill : #8F7AFA;");
        rectangles[1].setStyle("-fx-fill : #FAD77A;");

        Label[] legende = new Label[2];
        legende[0] = new Label("Entrée");
        legende[1] = new Label("Sortie");

        for (Label label : legende) {
            label.setStyle("-fx-font-size: 15;-fx-font-weight: bold");
        }

        Button play = new Button();
        play.setBackground(Background.EMPTY);

        ImageView imageBoutonPlay = new ImageView(new Image("/image/boutonPlay.png"));
        imageBoutonPlay.setFitWidth(70);
        imageBoutonPlay.setFitHeight(70);

        play.setGraphic(imageBoutonPlay);

        this.getChildren().addAll(boutonActivite, rectangles[0], legende[0], play, rectangles[1], legende[1], boutonGuichet);
    }

    @Override
    public void reagir() {

    }
}

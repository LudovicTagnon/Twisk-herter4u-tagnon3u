package twisk.vues;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import twisk.ecouteur.EcouteurBouton;
import twisk.mondeIG.MondeIG;

public class VueOutils extends TilePane implements Observateur{

    public VueOutils(MondeIG monde){
        monde.ajouterObservateur(this);

        this.setBackground(new Background(new BackgroundFill(Color.web("#869DA3"), null, null)));

        Button button = new Button("Ajouter");
        button.setFont(new Font(15));

        Tooltip tooltip = new Tooltip("Ajouter une activité");
        tooltip.setShowDelay(Duration.millis(250));
        button.setTooltip(tooltip);

        button.setOnAction(new EcouteurBouton(monde));

        Rectangle[] ronds = new Rectangle[4];

        for (int i = 0; i < ronds.length; i++) {
            ronds[i] = new Rectangle(30, 20);
        }

        ronds[0].setStyle("-fx-fill : #7ADEFA;");
        ronds[1].setStyle("-fx-fill : #8F7AFA;");
        ronds[2].setStyle("-fx-fill : #FAD77A;");
        ronds[3].setStyle("-fx-fill : #82FA7A;");

        Label[] canardEnchante = new Label[4];

        canardEnchante[0] = new Label("Activité");
        canardEnchante[1] = new Label("Entrée");
        canardEnchante[2] = new Label("Sortie");
        canardEnchante[3] = new Label("Entrée et Sortie");

        for (int i = 0; i < canardEnchante.length; i++) {
            canardEnchante[i].setStyle("-fx-font-size: 15;-fx-font-weight: bold");
        }

        this.getChildren().addAll(ronds[0], canardEnchante[0], ronds[1], canardEnchante[1], button, ronds[2], canardEnchante[2], ronds[3], canardEnchante[3]);
    }

    @Override
    public void reagir() {

    }
}

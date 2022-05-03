package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.exceptions.TwiskException;
import twisk.mondeIG.MondeIG;

public class EcouteurRenommerSelection implements EventHandler {
    private MondeIG monde;

    public EcouteurRenommerSelection(MondeIG monde) {
        this.monde = monde;
    }

    @Override
    public void handle(Event event) {
        if(this.monde.nbSelectionEtape() == 1){
            String nouveauNom;

            TextInputDialog textInputDialog = new TextInputDialog(this.monde.getNomPremiereEtapeSelectionnee());
            textInputDialog.setTitle("Changement de nom");
            textInputDialog.setHeaderText("Nouveau nom de l'étape :");
            textInputDialog.setContentText("Nom : ");

            textInputDialog.showAndWait();

            nouveauNom = textInputDialog.getResult();

            this.monde.setNomPremiereEtapeSelectionnee(nouveauNom);

            this.monde.enleverTouteSelectionEtape();

        }else{
            try {
                throw new TwiskException("Il doit avoir qu'une seule étape de sélectionnée");
            } catch (TwiskException ignored) {}
        }

    }
}

package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.exceptions.ArgumentException;
import twisk.exceptions.DelaiException;
import twisk.mondeIG.MondeIG;

/**
 * Class Ecouteur jetons.
 */
public class EcouteurJetons implements EventHandler {
    private MondeIG mondeIG;

    /**
     * Instantiates a new Ecouteur jetons.
     *
     * @param monde the monde
     */
    public EcouteurJetons(MondeIG monde) {
        this.mondeIG = monde;
    }

    @Override
    public void handle(Event event) {
        if(this.mondeIG.nbSelectionEtape() == 1){
            if(this.mondeIG.getPremiereEtape().estUnGuichet()){
                TextInputDialog inputJetons = new TextInputDialog();
                inputJetons.setTitle("Ajouter Jetons");
                inputJetons.setHeaderText("Nombre de jetons :");
                inputJetons.setContentText("Nombre : ");

                inputJetons.showAndWait();

                int nbJetons;
                nbJetons = Integer.parseInt(inputJetons.getResult());

                try {
                    if(nbJetons < 0){
                        throw new DelaiException("Le délai ne doit pas être inferieur à 0");
                    }else{
                        this.mondeIG.setJetons(nbJetons, this.mondeIG.getIdentifiantPremiereEtapeSelectionnee());
                    }
                } catch (DelaiException ignored) {}

                this.mondeIG.enleverTouteSelectionEtape();
            }else{
                try {
                    throw new ArgumentException("L'étape doit etre un guichet");
                } catch (ArgumentException ignored) {}
            }
        }else{
            try {
                throw new ArgumentException("Une seule étape doit être selectionné");
            } catch (ArgumentException ignored) {}
        }
    }
}

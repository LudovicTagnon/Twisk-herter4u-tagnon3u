package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.exceptions.ArgumentException;
import twisk.exceptions.DelaiException;
import twisk.mondeIG.MondeIG;

public class EcouteurDelai implements EventHandler {
    private MondeIG mondeIG;

    public EcouteurDelai(MondeIG monde) {
        this.mondeIG = monde;
    }

    @Override
    public void handle(Event event) {
        if(this.mondeIG.nbSelectionEtape() == 1){
            if(this.mondeIG.getPremiereEtape().estUneActivite()){
                TextInputDialog inputDelai = new TextInputDialog();
                inputDelai.setTitle("Ajouter delai");
                inputDelai.setHeaderText("Valeur du délai :");
                inputDelai.setContentText("Valeur : ");

                inputDelai.showAndWait();


                TextInputDialog inputeEcartTemps = new TextInputDialog();
                inputeEcartTemps.setTitle("Ajouter ecart-temps");
                inputeEcartTemps.setHeaderText("Valeur de l'écart-temps :");
                inputeEcartTemps.setContentText("Valeur : ");

                inputeEcartTemps.showAndWait();


                int delai, ecartTemps;
                delai = Integer.parseInt(inputDelai.getResult());
                ecartTemps = Integer.parseInt(inputeEcartTemps.getResult());

                try {
                    if(delai < 0){
                        throw new DelaiException("Le délai ne doit pas être inferieur à 0");
                    }else if(ecartTemps < 0){
                        throw new DelaiException("L'écart-temps ne doit pas être inferieur à 0");
                    }else if (delai < ecartTemps){
                        throw new DelaiException("L'écart-temps ne doit pas être supérieur au délai");
                    }else{
                        this.mondeIG.setDelaiEcartTemps(delai, ecartTemps, this.mondeIG.getIdentifiantPremiereEtapeSelectionnee());
                    }
                } catch (DelaiException ignored) {}

                this.mondeIG.enleverTouteSelectionEtape();
            }else{
                try {
                    throw new ArgumentException("L'étape doit etre une activité");
                } catch (ArgumentException ignored) {}
            }
        }else{
            try {
                throw new ArgumentException("Une seule étape doit être selectionné");
            } catch (ArgumentException ignored) {}
        }
    }
}

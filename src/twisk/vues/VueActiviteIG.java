package twisk.vues;

import javafx.scene.layout.HBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.outils.TailleComposants;

/**
 * Class VueActiviteIG.
 */
public class VueActiviteIG extends VueEtapeIG implements Observateur {

    /**
     * Instantiates a new VueActiviteIG.
     *
     * @param mondeIG Le monde
     * @param etapeIG L'etape
     */
    public VueActiviteIG(MondeIG mondeIG, EtapeIG etapeIG) {
        super(mondeIG, etapeIG);

        HBox clients = new HBox();
        if(etapeIG.getEstEntree()){
            clients.setStyle("-fx-border-color: #4F5D61; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 0px, 0px; -fx-border-radius: 3 3 0 0; -fx-background-color: #8F7AFA");
        }else if(etapeIG.getEstSortie() ){
            clients.setStyle("-fx-border-color: #4F5D61; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 0px, 0px; -fx-border-radius: 3 3 0 0; -fx-background-color: #FAD77A");
        }else{
            clients.setStyle("-fx-border-color: #4F5D61; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 0px, 0px; -fx-border-radius: 3 3 0 0; -fx-background-color: #7ADEFA");
        }
        clients.setMinHeight(TailleComposants.getInstance().getTailleYAct() - this.label.getMinHeight());
        this.getChildren().add(clients);
    }

    @Override
    public void reagir() {

    }
}

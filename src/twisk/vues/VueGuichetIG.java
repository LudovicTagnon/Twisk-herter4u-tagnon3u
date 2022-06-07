package twisk.vues;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.outils.TailleComposants;

/**
 * Class VueGuichetIG.
 */
public class VueGuichetIG extends VueEtapeIG implements Observateur{
    /**
     * Instantiates a new VueGuichetIG.
     *
     * @param mondeIG Le monde
     * @param etapeIG L'etape
     */
    public VueGuichetIG(MondeIG mondeIG, EtapeIG etapeIG) {
        super(mondeIG, etapeIG);

        HBox clients = new HBox();
        clients.setSpacing(2);
        for(int i = 0; i < 10; i++){
            Pane carre = new Pane();
            if(etapeIG.getEstEntree()){
                carre.setStyle("-fx-background-color: #8F7AFA;");
            }else if(etapeIG.getEstSortie() ){
                carre.setStyle("-fx-background-color: #FAD77A;");
            }else{
                carre.setStyle("-fx-background-color: #7ADEFA;");
            }
            carre.setMinHeight(20);
            carre.setMaxHeight(20);
            carre.setMinWidth(20);
            carre.setMaxWidth(20);
            clients.getChildren().add(carre);
        }

        clients.setMinHeight(TailleComposants.getInstance().getTailleYGui() - this.label.getMinHeight());
        this.getChildren().add(clients);
    }

    @Override
    public void reagir() {

    }
}

package twisk.ecouteur;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.exceptions.TwiskException;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.vues.VuePointDeControleIG;

/**
 * Class Ecouteur point de controle.
 */
public class EcouteurPointDeControle implements EventHandler {
    private MondeIG monde;
    private PointDeControleIG point;
    private VuePointDeControleIG vue;

    /**
     * Instantiates a new Ecouteur point de controle.
     *
     * @param monde the monde
     * @param point the point
     * @param vue   the vue
     */
    public EcouteurPointDeControle(MondeIG monde, PointDeControleIG point, VuePointDeControleIG vue) {
        this.monde = monde;
        this.point = point;
        this.vue = vue;
    }

    @Override
    public void handle(Event event) {
        if(monde.getDepart() == null){
            this.vue.setStyle("-fx-fill : turquoise");
            monde.setDepart(point);
        }else{
            monde.setArrivee(point);
            try {
                monde.ajouter(monde.getDepart(), monde.getArrivee());
            } catch (TwiskException ignored) {

            }
        }
    }
}

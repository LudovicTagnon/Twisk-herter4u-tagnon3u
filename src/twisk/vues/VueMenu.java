package twisk.vues;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import twisk.ecouteur.*;
import twisk.mondeIG.MondeIG;

/**
 * Class VueMenu.
 */
public class VueMenu extends MenuBar implements Observateur{

    /**
     * Instantiates a new Vue menu.
     *
     * @param mondeIG Le monde
     */
    public VueMenu(MondeIG mondeIG) {
        mondeIG.ajouterObservateur(this);

        Menu fichier = new Menu("Fichier");
        Menu edition = new Menu("Edition");
        Menu monde = new Menu("Monde");
        Menu parametre = new Menu("Paramètres");

        MenuItem quitter = new MenuItem("Quitter");
        quitter.setOnAction(new EcouteurQuitter());

        MenuItem suppSelection = new MenuItem("Supprimer la sélection");
        suppSelection.setOnAction(new EcouteurSupprimerSelection(mondeIG));
        suppSelection.setAccelerator(new KeyCodeCombination(KeyCode.DELETE));
        MenuItem rennomerSelection = new MenuItem("Renommer la sélection");
        rennomerSelection.setOnAction(new EcouteurRenommerSelection(mondeIG));
        MenuItem effacerSelection = new MenuItem("Effacer la selection");
        effacerSelection.setOnAction(new EcouteurEffacerSelection(mondeIG));

        MenuItem entree = new MenuItem("Entrée");
        entree.setOnAction(new EcouteurEntree(mondeIG));
        entree.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.ALT_DOWN));

        MenuItem sortie = new MenuItem("Sortie");
        sortie.setOnAction(new EcouteurSortie(mondeIG));
        sortie.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.ALT_DOWN));

        MenuItem delaiEcartTemps = new MenuItem("Ajouter delai");
        delaiEcartTemps.setOnAction(new EcouteurDelai(mondeIG));
        delaiEcartTemps.setAccelerator(new KeyCodeCombination(KeyCode.T, KeyCombination.CONTROL_DOWN));
        MenuItem jetons = new MenuItem("Ajouter Jetons");
        jetons.setOnAction(new EcouteurJetons(mondeIG));

        fichier.getItems().add(quitter);
        edition.getItems().addAll(suppSelection, rennomerSelection, effacerSelection);
        monde.getItems().addAll(entree, sortie);
        parametre.getItems().addAll(delaiEcartTemps, jetons);

        this.getMenus().addAll(fichier, edition, monde, parametre);
    }

    @Override
    public void reagir() {

    }
}

package twisk;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import twisk.mondeIG.MondeIG;
import twisk.outils.TailleComposants;
import twisk.vues.VueMenu;
import twisk.vues.VueMondeIG;
import twisk.vues.VueOutils;

/**
 * Main.
 */
public class MainTwisk extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        MondeIG mondeIG = new MondeIG();

        VueOutils vueOutils = new VueOutils(mondeIG);
        VueMondeIG vueMondeIG = new VueMondeIG(mondeIG);
        VueMenu vueMenu = new VueMenu(mondeIG);

        root.setCenter(vueMondeIG);

        root.setTop(vueMenu);

        root.setBottom(vueOutils);
        vueOutils.setAlignment(Pos.TOP_CENTER);

        stage.setScene(new Scene(root, TailleComposants.getInstance().getTailleEcranX(), TailleComposants.getInstance().getTailleEcranY()));
        stage.setOnCloseRequest(windowEvent -> Platform.exit());
        stage.show();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

package twisk.exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class TwiskException extends Exception {
    public TwiskException(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);

        alert.show();
        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        pause.play();
        pause.setOnFinished(actionEvent -> alert.close());

    }
}

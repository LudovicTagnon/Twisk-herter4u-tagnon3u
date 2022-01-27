module twisk.twisk {
    requires javafx.controls;
    requires javafx.fxml;


    opens twisk.twisk to javafx.fxml;
    exports twisk.twisk;
}
package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertBox {
    public static void createAlertBox(String warning) {
        Alert alert = new Alert(Alert.AlertType.WARNING, warning,ButtonType.CLOSE);
        alert.showAndWait();
    }
}

package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alerts {

    public static void alertError(String prompt) {
        Alert alert = new Alert(Alert.AlertType.ERROR, prompt);
        alert.showAndWait();
    }

    public static Optional<ButtonType> alertConfirm(String prompt) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, prompt);
        Optional<ButtonType> result = alert.showAndWait();
        return result;
    }
}

package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alerts {

    /** Produces an error alert for the user.
     * @param prompt Fix needed for action to continue
     */
    public static void alertError(String prompt) {
        Alert alert = new Alert(Alert.AlertType.ERROR, prompt);
        alert.showAndWait();
    }

    /** Produces a confirmation for the user
     * @param prompt Confirmation needed for action to continue
     * @return whether OK or cancel was clicked
     */
    public static Optional<ButtonType> alertConfirm(String prompt) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, prompt);
        Optional<ButtonType> result = alert.showAndWait();
        return result;
    }
}

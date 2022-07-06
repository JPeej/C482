package controller;

import javafx.stage.Stage;
import java.util.Optional;
import javafx.scene.Scene;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

/** Handles all navigation across program.*/
public class Navigation {

    Stage stage;
    Parent scene;

    /** Handles navigation for all buttons, excluding cancel buttons.
     * Creates "location" string to pass into FXMLLoader.
     * Uses casting to get information out of ActionEvent object.
     * Uses regex to properly split "formLocation" param into a usuable title.
     * Loads next screen.
     * @param event ActionEvent object holding information on the button pressed
     * @param formLocation string for fxml file name
     * @throws IOException
     */
    public void button(ActionEvent event, String formLocation) throws IOException {
        String view = "/view/";
        String fxml = ".fxml";
        String location = view.concat(formLocation.concat(fxml));
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource(location));
        formLocation = formLocation.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");
        stage.setTitle(formLocation);
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /** Handles navigation for cancel buttons.
     * Prompts user with confirmation as cancelling will delete all changes made.
     * OK continues to Main Menu and cancel keeps user on current screen.
     * Uses button method to handle screen change.
     * @param event ActionEvent object holding information on the button pressed
     * @param formLocation string for fxml file name
     * @throws IOException
     */
    public void cancel(ActionEvent event, String formLocation) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "All changes will be cleared and not saved, do you want to continue?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            button(event, "MainMenu");
        }
    }
}

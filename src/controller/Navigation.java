package controller;

import javafx.scene.control.TableView;
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
import model.Part;

import javax.swing.*;

/** Handles all navigation across program.*/
public class Navigation {

    Stage stage;
    Parent scene;

    public String location(String formLocation) {
        String view = "/view/";
        String fxml = ".fxml";
        String location = view.concat(formLocation.concat(fxml));
        return location;
    }

    public void setTitle(String formLocation) {
        formLocation = formLocation.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");
        stage.setTitle(formLocation);
    }

    /** Handles navigation for all buttons, excluding cancel buttons.
     * Creates "location" string to pass into FXMLLoader.
     * Uses casting to get information out of ActionEvent object.
     * Uses regex to properly split "formLocation" param into a usuable title.
     * Loads next screen.
     * @param event ActionEvent object holding information on the button pressed
     * @param formLocation string for fxml file name
     * @throws IOException
     */
    public void navigate(ActionEvent event, String formLocation) throws IOException {
        String location = location(formLocation);
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource(location));
        setTitle(location);
        stage.setScene(new Scene(scene));
        stage.show();
    }

    //Work in progress - please disregard.

    /*public void navWithData(ActionEvent event, String formLocation) throws IOException {
        String location = location(formLocation);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(location));
        loader.load();

        if (formLocation.equals("ModifyPartForm")) {
            ModifyPartFormController MDFController = loader.getController();
            MDFController.sendPart(MainMenuController.partTableView.getSelectionModel().getSelectedItem());
        }

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        setTitle(location);
        stage.setScene(new Scene(scene));
        stage.showAndWait();
    }*/

    /** Handles navigation for cancel buttons.
     * Prompts user with confirmation as cancelling will delete all changes made.
     * OK continues to Main Menu and cancel keeps user on current screen.
     * Uses button method to handle screen change.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    public void cancel(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "All changes will be cleared and not saved, do you want to continue?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            navigate(event, "MainMenu");
        }
    }
}

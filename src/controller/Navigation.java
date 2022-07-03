package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Navigation {

    Stage stage;
    Parent scene;

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

    public void cancel(ActionEvent event, String formLocation) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "All changes will be cleared and not saved, do you want to continue?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            button(event, "MainMenu");
        }
    }
}

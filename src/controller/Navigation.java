package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

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
}

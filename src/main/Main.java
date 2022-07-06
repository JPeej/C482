package main;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;

/** Main class for program.*/
public class Main extends Application {

    /** Start life cycle method of JavaFX.
     * Sets root via location of MainMenu.fxml
     * Creates initial JavaFX stage.
     * @param primaryStage Stage object that will be presented upon program start
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
        primaryStage.setTitle(("Main Menu"));
        primaryStage.setScene(new Scene(root, 900, 325));
        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);
    }
}

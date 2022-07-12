package main;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;

/** Main class for program.
 * FUTURE ENHANCEMENT - Under the Navigation class there is a method called navWithData.
 * I was trying to create a nav class that would move to either modify screen.
 * This would cut down on some redundant code.
 * I ran into some problems getting the selection via the Navigation class.
 * I couldn't make the table views static and if I made a new MainMenuController within the Nav class I would crash via an infinite loop.
 * Need look more into this.
 * For a feature I would like to add communication to an online store.
 * This would automatically adjust stock and therefore parts available.
 * Once a part hits a min stock value a request to purchase more is prompted to the user.*/
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

    /** Main method that starts program.
     * @param args
     */
    public static void main(String[] args) {launch(args);
    }
}

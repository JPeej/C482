package controller;

import java.net.URL;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import model.InHouse;
import model.Outsourced;
import model.Part;

/** Controls user input to modify part screen.*/
public class ModifyPartFormController implements Initializable {

    Navigation nav = new Navigation();

    private String partMutableLabel;
    private RadioButton inHouse;
    private RadioButton outSourced;
    @FXML
    private TextField partIdTxt;
    @FXML
    private TextField partInvTxt;
    @FXML
    private TextField partMaxTxt;
    @FXML
    private TextField partMinTxt;
    @FXML
    private TextField partNameTxt;
    @FXML
    private TextField partPriceTxt;
    @FXML
    private RadioButton radioInhouse;
    @FXML
    private RadioButton radioOutsourced;
    @FXML
    private Label partConstructLabel;
    @FXML
    private TextField partConstructTxt;

    @FXML
    void onActionInHouse(ActionEvent event) {

    }

    @FXML
    void onActionOutsourced(ActionEvent event) {

    }

    /** Event handler for cancel button.
     * Cancel button will pass ActionEvent object that is created when the button is pressed.
     * Calls cancel method via Navigation object. Passes event and string, "MainMenu", for FXMLLoader to use.
     * Confirmation prompts user to cancel or return to modify part screen. Canceling returns user to main menu.
     * See Controller package > Navigation class > cancel method.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        nav.cancel(event);
    }

    @FXML
    void onActionSavePart(ActionEvent event) throws IOException {
        nav.navigate(event, "MainMenu");
    }

    /** Initializes controller for use once root element has been set.
     * Override for Initializable class initialize method.
     * First method called for controller when screen is loaded.
     * @param url location used for the root to find relative paths
     * @param resourceBundle resources to find root object
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /** Parses through data of Part object to populate UI of modify part screen.
     * @param part Part object to be parsed for populating text fields
     */
    public void sendPart(Part part) {
        partIdTxt.setText(String.valueOf(part.getId()));
        partNameTxt.setText(part.getName());
        partInvTxt.setText(String.valueOf(part.getStock()));
        partPriceTxt.setText(String.valueOf(part.getPrice()));
        partMaxTxt.setText(String.valueOf(part.getMax()));
        partMinTxt.setText(String.valueOf(part.getMin()));

        if (part instanceof InHouse) {
            partConstructLabel.setText("MachineID");
            partConstructTxt.setText(String.valueOf(((InHouse) part).getMachineId()));
            radioInhouse.setSelected(true);
            radioOutsourced.setSelected(false);
        } else if (part instanceof Outsourced) {
            partConstructLabel.setText("Company Name");
            partConstructTxt.setText(String.valueOf(((Outsourced) part).getCompanyName()));
            radioInhouse.setSelected(false);
            radioOutsourced.setSelected(true);
        }
    }
}

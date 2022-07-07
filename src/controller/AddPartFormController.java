package controller;

import model.InHouse;
import model.Outsourced;
import model.Part;
import java.net.URL;
import model.Inventory;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


/** Controls user input to the add part screen.*/
public class AddPartFormController implements Initializable {

    Navigation nav = new Navigation();

    @FXML
    private RadioButton inHouseRadio;

    @FXML
    private RadioButton outsourcedRadio;

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
    private ToggleGroup partRadioGroup;

    @FXML
    private Label partConstructLabel;

    @FXML
    private TextField partConstructText;

    @FXML
    void onActionInHouse(ActionEvent event) {
        partConstructLabel.setText("MachineID");
    }

    @FXML
    void onActionOutsourced(ActionEvent event) {
        partConstructLabel.setText("Company Name");
    }

    @FXML
    void onActionSavePart(ActionEvent event) throws IOException {
        int id  = Inventory.populatePartId();
        String name = partNameTxt.getText();
        double price = Double.parseDouble(partPriceTxt.getText());
        int stock = Integer.parseInt(partInvTxt.getText());
        int min = Integer.parseInt(partMinTxt.getText());
        int max = Integer.parseInt(partMaxTxt.getText());

        if(inHouseRadio.isSelected()) {
            int machineId = Integer.parseInt(partConstructText.getText());
            Part newPart = new InHouse(id, name, price, stock, min, max, machineId);
            Inventory.addPart(newPart);
        } else if(outsourcedRadio.isSelected()) {
            String companyName = partConstructText.getText();
            Part newPart = new Outsourced(id, name, price, stock, min, max, companyName);
            Inventory.addPart(newPart);
        }

        nav.button(event, "MainMenu");
    }

    /** Event handler for cancel button.
     * Cancel button will pass ActionEvent object that is created when the button is pressed.
     * Calls cancel method via Navigation object. Passes event and string, "MainMenu", for FXMLLoader to use.
     * Confirmation prompts user to cancel or return to add part screen. Canceling returns user to main menu.
     * See Controller package > Navigation class > cancel method.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        nav.cancel(event, "MainMenu");
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
}

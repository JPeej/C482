package controller;

import model.Part;
import java.net.URL;
import model.InHouse;
import model.Inventory;
import javafx.fxml.FXML;
import model.Outsourced;
import java.io.IOException;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/** Controls user input to modify part screen.*/
public class ModifyPartFormController implements Initializable {

    Navigation nav = new Navigation();

    private int index;
    @FXML
    private RadioButton inHouseRadio;
    @FXML
    private RadioButton outsourcedRadio;
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
    private Label partConstructLabel;
    @FXML
    private TextField partConstructTxt;

    /** Sets the final user input text field's label to "MachineID".
     * Upon selecting the In House radio the label will change to "MachineID".
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML
    void onActionInHouse(ActionEvent event) {
        partConstructLabel.setText("MachineID");
    }

    /** Sets the final user input text field's label to "Company Name".
     * Upon selecting the Outsourced radio the label will change to "Company Name".
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML
    void onActionOutsourced(ActionEvent event) {
        partConstructLabel.setText("Company Name");
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

    /** Saves changes to part.
     * Parses data, checks data types, and creates part based on radio selection.
     * Inserts into original Parts index in allParts.
     * @param event ActionEvent object holding information on the button pressed
     * @throws ArithmeticException
     * @throws NumberFormatException
     */
    @FXML
    void onActionSavePart(ActionEvent event)  throws ArithmeticException, NumberFormatException {
        try {
            int stock = Integer.parseInt(partInvTxt.getText());
            int min = Integer.parseInt(partMinTxt.getText());
            int max = Integer.parseInt(partMaxTxt.getText());
            if (stock < min || stock > max || min > max) {
                throw new ArithmeticException();
            }

            String name = partNameTxt.getText();
            if (name.isBlank()) {
                throw new Exception();
            }

            double price = Double.parseDouble(partPriceTxt.getText());
            int id  = Integer.parseInt(partIdTxt.getText());

            if(inHouseRadio.isSelected()) {
                int machineId = Integer.parseInt(partConstructTxt.getText());
                Part newPart = new InHouse(id, name, price, stock, min, max, machineId);
                Inventory.updatePart(index, newPart);
            } else if(outsourcedRadio.isSelected()) {
                String companyName = partConstructTxt.getText();
                if (companyName.isBlank()) {
                    throw new Exception();
                }
                Part newPart = new Outsourced(id, name, price, stock, min, max, companyName);
                Inventory.updatePart(index, newPart);
            }

            nav.navigate(event, "MainMenu");

        } catch (NumberFormatException e) {
            Alerts.alertError("Please enter numeric values in the following fields: Inv, Price, Max, Min, and MachineID (if prompted).");
        } catch (ArithmeticException e) {
            Alerts.alertError("Inventory stock amount must be between the min and max values.");
        } catch (Exception e) {
            Alerts.alertError("Please enter a name and company name (if prompted) for the part.");
        }
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
            inHouseRadio.setSelected(true);
            outsourcedRadio.setSelected(false);
        } else if (part instanceof Outsourced) {
            partConstructLabel.setText("Company Name");
            partConstructTxt.setText(String.valueOf(((Outsourced) part).getCompanyName()));
            inHouseRadio.setSelected(false);
            outsourcedRadio.setSelected(true);
        }

        index = Inventory.getAllParts().indexOf(part);
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

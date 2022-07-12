package controller;

import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Inventory;
import model.Part;
import model.Product;

/** Controls user input to the add product screen.*/
public class AddProductFormController implements Initializable {

    Navigation nav = new Navigation();

    private ObservableList<Part> partsTemp = FXCollections.observableArrayList();
    @FXML
    private TableView<Part> allPartsTableView;
    @FXML
    private TableView<Part> assocPartsTableView;
    @FXML
    private TableColumn<Part, Integer> allPartIdCol;
    @FXML
    private TableColumn<Part, Integer> allPartInvCol;
    @FXML
    private TableColumn<Part, String> allPartNameCol;
    @FXML
    private TableColumn<Part, Double> allPartPriceCol;
    @FXML
    private TableColumn<Part, Integer> assocPartIdCol;
    @FXML
    private TableColumn<Part, Integer> assocPartInvCol;
    @FXML
    private TableColumn<Part, String> assocPartNameCol;
    @FXML
    private TableColumn<Part, Double> assocPartPriceCol;
    @FXML
    private TextField productAddPartSearch;
    @FXML
    private TextField productInvTxt;
    @FXML
    private TextField productMaxTxt;
    @FXML
    private TextField productMinTxt;
    @FXML
    private TextField productNameTxt;
    @FXML
    private TextField productPriceTxt;

    /** Searches all available parts for a name or id query.
     * Uses Search class method searchFor to display parts queried.
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML
    void onActionSearchParts(ActionEvent event) {
        Search.searchFor("Part", productAddPartSearch, allPartsTableView);
    }

    /** Adds part to temp associated parts list.
     * Updates associated parts table view.
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML
    void onActionAddAssocPart(ActionEvent event) {
        Part selectedPart = allPartsTableView.getSelectionModel().getSelectedItem();
        partsTemp.add(selectedPart);
        Populate.tableView(assocPartsTableView, partsTemp, assocPartIdCol, assocPartInvCol, assocPartNameCol, assocPartPriceCol);
    }

    /** Removes part from temp associated parts list.
     * Updates associated parts table view.
     * No permanent changes made until save is clicked.
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML
    void onActionRemoveAssocPart(ActionEvent event) {
        Optional<ButtonType> result = Alerts.alertConfirm("Click OK to confirm removal of part.");
        if(result.get() == ButtonType.OK) {
            Part selectedPart = assocPartsTableView.getSelectionModel().getSelectedItem();
            partsTemp.remove(selectedPart);
            Populate.tableView(assocPartsTableView, partsTemp, assocPartIdCol, assocPartInvCol, assocPartNameCol, assocPartPriceCol);
        }
    }

    /** Event handler for cancel button.
     * Cancel button will pass ActionEvent object that is created when the button is pressed.
     * Calls cancel method via Navigation object. Passes event and string, "MainMenu", for FXMLLoader to use.
     * Confirmation prompts user to cancel or return to add product screen. Canceling returns user to main menu.
     * See Controller package > Navigation class > cancel method.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        nav.cancel(event);
    }

    /** Event handler for save button.
     *  Saves new product to the inventory.
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML
    void onActionSaveProduct(ActionEvent event) {
        try {
            int stock = Integer.parseInt(productInvTxt.getText());
            int min = Integer.parseInt(productMinTxt.getText());
            int max = Integer.parseInt(productMaxTxt.getText());
            if (stock < min || stock > max || min > max) {
                throw new ArithmeticException();
            }

            String name = productNameTxt.getText();
            if (name.isBlank()) {
                throw new Exception();
            }

            double price = Double.parseDouble(productPriceTxt.getText());
            int id = Inventory.populateProductId();

            Product newProduct = new Product(id, name, price, stock, min, max);
            for (Part associatedPart : partsTemp) {
                newProduct.addAssociatedPart(associatedPart);
            }
            Inventory.addProduct(newProduct);
            nav.navigate(event, "MainMenu");

        } catch (NumberFormatException e) {
            Alerts.alertError("Please enter numeric values in the following fields: Inv, Price, Max, and Min");
        } catch (ArithmeticException e) {
            Alerts.alertError("Inventory stock amount must be between the min and max values.");
        } catch (Exception e) {
            Alerts.alertError("Please enter a name for the product.");
        }
    }

    /** Initializes controller for use once root element has been set.
     * Override for Initializable class initialize method.
     * First method called for controller when screen is loaded.
     * @param url location used for the root to find relative paths
     * @param resourceBundle resources to find root object
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Populate.tableView(allPartsTableView, Inventory.getAllParts(), allPartIdCol, allPartInvCol, allPartNameCol, allPartPriceCol);
    }
}

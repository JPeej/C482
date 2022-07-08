package controller;

import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
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

    /** Adds part to temp associated parts list.
     * Updates associated parts table view.
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML
    void onActionAddAssocPart(ActionEvent event) {
        Part selectedPart = allPartsTableView.getSelectionModel().getSelectedItem();
        partsTemp.add(selectedPart);
        assocPartsTableView.setItems(partsTemp);
        assocPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        assocPartInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        assocPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        assocPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /** Removes part from temp associated parts list.
     * Updates associated parts table view.
     * No permanent changes made until save is clicked.
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML
    void onActionRemoveAssocPart(ActionEvent event) {
        Part selectedPart = assocPartsTableView.getSelectionModel().getSelectedItem();
        partsTemp.remove(selectedPart);
        assocPartsTableView.setItems(partsTemp);
        assocPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        assocPartInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        assocPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        assocPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
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
     * @throws IOException
     */
    @FXML
    void onActionSaveProduct(ActionEvent event) throws IOException {
        try {
            int stock = Integer.parseInt(productInvTxt.getText());
            int min = Integer.parseInt(productMinTxt.getText());
            int max = Integer.parseInt(productMaxTxt.getText());
            if (stock < min || stock > max) {
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
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter numeric values in the following fields: Inv, Price, Max, Min, and MachineID (if prompted).");
            alert.showAndWait();
        } catch (ArithmeticException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Inventory stock amount must be between the min and max values.");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a name and company name (if prompted) for the part.");
            alert.showAndWait();
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
        allPartsTableView.setItems(Inventory.getAllParts());
        allPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}

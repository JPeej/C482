package controller;

import model.Part;
import java.net.URL;
import model.Inventory;
import javafx.fxml.FXML;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/** Controls user input to the main menu screen.*/
public class MainMenuController implements Initializable {

    Navigation nav = new Navigation();

    @FXML
    private TableView<Part> partTableView;

    @FXML
    private TableColumn<?, ?> partIdCol;

    @FXML
    private TableColumn<?, ?> partNameCol;

    @FXML
    private TableColumn<?, ?> partStockCol;

    @FXML
    private TableColumn<?, ?> partPriceCol;

    @FXML
    private TextField partSearchBar;

    @FXML
    private TableView<?> productTableView;

    @FXML
    private TableColumn<?, ?> productIdCol;

    @FXML
    private TableColumn<?, ?> productNameCol;

    @FXML
    private TableColumn<?, ?> productStockCol;

    @FXML
    private TableColumn<?, ?> productPriceCol;

    @FXML
    private TextField productSearchBar;

    /** Event handler for add part button.
     * Add part button will pass ActionEvent object that is created when the button is pressed.
     * Calls button method via Navigation object. Passes event and string, "AddPartForm", for FXMLLoader to use.
     * See Controller package > Navigation class > button method.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        nav.button(event, "AddPartForm");
    }

    /** Event handler for modify part button.
     * Modify part button will pass ActionEvent object that is created when the button is pressed.
     * Calls button method via Navigation object. Passes event and string, "ModifyPartForm", for FXMLLoader to use.
     * See Controller package > Navigation class > button method.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    @FXML
    void onActionModifyPart(ActionEvent event) throws IOException {
        nav.button(event, "ModifyPartForm");
    }


    @FXML
    void onActionDeletePart(ActionEvent event) {

    }

    /** Event handler for add product button.
     * Add product button will pass ActionEvent object that is created when the button is pressed.
     * Calls button method via Navigation object. Passes event and string, "AddProductForm", for FXMLLoader to use.
     * See Controller package > Navigation class > button method.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    @FXML
    void onActionAddProduct(ActionEvent event) throws IOException {
        nav.button(event, "AddProductForm");
    }

    /** Event handler for modify product button.
     * Modify prodcut button will pass ActionEvent object that is created when the button is pressed.
     * Calls button method via Navigation object. Passes event and string, "ModifyProductForm", for FXMLLoader to use.
     * See Controller package > Navigation class > button method.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    @FXML
    void onActionModifyProduct(ActionEvent event) throws IOException {
        nav.button(event, "ModifyProductForm");
    }

    @FXML
    void onActionDeleteProduct(ActionEvent event) {

    }


    /** Properly closes running program.
     * Terminates JVM. Zero passed into exit method indicates normal termination.
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML
    void onActionExitProgram(ActionEvent event) {
        System.exit(0);
    }

    /** Initializes controller for use once root element has been set.
     * Override for Initializable class initialize method.
     * First method called for controller when screen is loaded.
     * @param url location used for the root to find relative paths
     * @param resourceBundle resources to find root object
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partTableView.setItems(Inventory.getAllParts());
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
}

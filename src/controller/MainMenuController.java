package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
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
import model.Product;

/** Controls user input to the main menu screen.*/
public class MainMenuController implements Initializable {

    Stage stage;
    Navigation nav = new Navigation();

    @FXML
    protected TableView<Part> partTableView;
    @FXML
    private TableColumn<Part, Integer> partIdCol;
    @FXML
    private TableColumn<Part, String> partNameCol;
    @FXML
    private TableColumn<Part, Integer> partStockCol;
    @FXML
    private TableColumn<Part, Double> partPriceCol;
    @FXML
    private TextField partSearchBar;
    @FXML
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, Integer> productIdCol;
    @FXML
    private TableColumn<Product, String> productNameCol;
    @FXML
    private TableColumn<Product, Integer> productStockCol;
    @FXML
    private TableColumn<Product, Double> productPriceCol;
    @FXML
    private TextField productSearchBar;

    /** Event handler for add part button, opens add part screen.
     * Add part button will pass ActionEvent object that is created when the button is pressed.
     * Calls button method via Navigation object. Passes event and string, "AddPartForm", for FXMLLoader to use.
     * See Controller package > Navigation class > button method.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        nav.navigate(event, "AddPartForm");
    }

    /** Event handler for modify part button.
     * Gets the selected item from the main menu parts table.
     * Passes part in sendPart method to parse data for population on modify part menu.
     * Opens modify part menu.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    @FXML
    void onActionModifyPart(ActionEvent event) throws IOException {
        String location = "/view/ModifyPartForm.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(location));
        loader.load();

        ModifyPartFormController MDFController = loader.getController();
        MDFController.sendPart(partTableView.getSelectionModel().getSelectedItem());

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        //nav.setTitle(location);
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionDeletePart(ActionEvent event) {

    }

    /** Event handler for add product button, opens add product screen.
     * Add product button will pass ActionEvent object that is created when the button is pressed.
     * Calls button method via Navigation object. Passes event and string, "AddProductForm", for FXMLLoader to use.
     * See Controller package > Navigation class > button method.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    @FXML
    void onActionAddProduct(ActionEvent event) throws IOException {
        nav.navigate(event, "AddProductForm");
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
        nav.navigate(event, "ModifyProductForm");
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

    /** Initializes controller for use once a main menu screen is instantiated.
     * Gets all objects for both table views, parses object data, and sets data to appropriate column.
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

        productTableView.setItems(Inventory.getAllProducts());
        productIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
}

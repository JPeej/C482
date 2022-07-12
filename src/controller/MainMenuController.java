package controller;

import model.Part;
import java.net.URL;
import model.Product;
import model.Inventory;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Optional;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/** Controls user input to the main menu screen.*/
public class MainMenuController implements Initializable {

    Stage stage;
    Navigation nav = new Navigation();

    @FXML
    private TableView<Part> partTableView;
    @FXML
    private TableColumn<Part, Integer> partIdCol;
    @FXML
    private TableColumn<Part, String> partNameCol;
    @FXML
    private TableColumn<Part, Integer> partStockCol;
    @FXML
    private TableColumn<Part, Double> partPriceCol;
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
    private TextField partSearchBar;
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

    /** Event handler for modify part button.
     * Gets the selected item from the main menu parts table.
     * Passes part in sendPart method to parse data for population on modify part menu.
     * Opens modify part menu.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    @FXML
    void onActionModifyPart(ActionEvent event) throws IOException {
        try {
            String formLocation = nav.location("ModifyPartForm");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(formLocation));
            loader.load();

            ModifyPartFormController MDFController = loader.getController();
            MDFController.sendPart(partTableView.getSelectionModel().getSelectedItem());

            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();

        } catch (NullPointerException e) {
            Alerts.alertError("Please select a part first.");
        }
    }

    /** Event handler for modify product button.
     * Modify product button will pass ActionEvent object that is created when the button is pressed.
     * Calls button method via Navigation object. Passes event and string, "ModifyProductForm", for FXMLLoader to use.
     * See Controller package > Navigation class > button method.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    @FXML
    void onActionModifyProduct(ActionEvent event)  throws IOException {
        String location = "/view/ModifyProductForm.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(location));
        loader.load();

        ModifyProductFormController MPFController = loader.getController();
        MPFController.sendProduct(productTableView.getSelectionModel().getSelectedItem());

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /** Controls deletion of part from the allParts list and tableview.
     * Confirms deletion is wanted and successful.
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML
    void onActionDeletePart(ActionEvent event) {
        Optional<ButtonType> result = Alerts.alertConfirm("Click OK to confirm deletion of part.");
        if(result.get() == ButtonType.OK) {
            Part partToDelete = partTableView.getSelectionModel().getSelectedItem();
            Inventory.deletePart(partToDelete);

            if (Inventory.getAllParts().contains(partToDelete)) {
                Alerts.alertError("Part not deleted.");
            }
        }
    }

    /** Controls deletion of product from the allProducts list and tableview.
     * Confirms deletion is wanted and successful.
     * Denies deletion if product has associated parts.
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML
    void onActionDeleteProduct(ActionEvent event) {
        Optional<ButtonType> result = Alerts.alertConfirm("Click OK to confirm deletion of product.");
        if(result.get() == ButtonType.OK) {
            Product productToDelete = productTableView.getSelectionModel().getSelectedItem();
            if (productToDelete.getAllAssociatedParts().isEmpty()) {
                Inventory.deleteProduct(productToDelete);
            }
            else {
                Alerts.alertError("Product not deleted. Remove all associated parts.");
            }
        }
    }

    /** Searches all available parts for a name or id query.
     * Uses Search class method searchFor to display parts queried.
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML
    void onActionSearchParts(ActionEvent event) {
        Search.searchFor("Part", partSearchBar, partTableView);
    }

    /** Searches all available products for a name or id query.
     * Uses Search class method searchFor to display products queried.
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML void onActionSearchProducts(ActionEvent event) {
        Search.searchFor("Product", productSearchBar, productTableView);
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
        Populate.tableView(partTableView, Inventory.getAllParts(), partIdCol, partStockCol, partNameCol, partPriceCol);
        Populate.tableView(productTableView, Inventory.getAllProducts(), productIdCol, productStockCol, productNameCol, productPriceCol);
    }
}

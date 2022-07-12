package controller;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Part;
import java.net.URL;
import model.Inventory;
import javafx.fxml.FXML;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Product;

/** Controls user input to the main menu screen.*/
public class MainMenuController implements Initializable {

    Navigate nav = new Navigate();

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
        nav.moveScreen(event, "AddPartForm");
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
        nav.toModify(event, "ModifyPartForm", partTableView);
    }

    @FXML
    void onActionDeletePart(ActionEvent event) {
        deletion("Part");
    }

    @FXML
    void onActionSearchParts(ActionEvent event) {
        try {
            String queryName = partSearchBar.getText().toLowerCase(Locale.ROOT);
            ObservableList<Part> partQueryResult = Inventory.lookupPart(queryName);

            if (!(partQueryResult.isEmpty())) {
                partTableView.setItems(partQueryResult);
            } else {
                int queryId = Integer.parseInt(partSearchBar.getText());
                Part result = Inventory.lookupPart(queryId);
                if (result != null) {
                    partQueryResult.add(result);
                    partTableView.setItems(partQueryResult);
                } else {
                    Alerts.alertError("No parts found from query.");
                }
            }
        } catch (NumberFormatException e) {
            Alerts.alertError("No parts found from query.");
        }
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
        nav.moveScreen(event, "AddProductForm");
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
        nav.toModify(event, "ModifyProductForm", productTableView);
    }

    @FXML
    void onActionDeleteProduct(ActionEvent event) {
        deletion("Product");
    }

    @FXML void onActionSearchProducts(ActionEvent event) {
        try {
            String queryName = productSearchBar.getText().toLowerCase(Locale.ROOT);
            ObservableList<Product> productQueryResult = Inventory.lookupProduct(queryName);

            if (!(productQueryResult.isEmpty())) {
                productTableView.setItems(productQueryResult);
            } else {
                int queryId = Integer.parseInt(productSearchBar.getText());
                Product result = Inventory.lookupProduct(queryId);
                if (result != null) {
                    productQueryResult.add(result);
                    productTableView.setItems(productQueryResult);
                } else {
                    Alerts.alertError("No products found from query.");
                }
            }
        } catch (NumberFormatException e) {
            Alerts.alertError("No products found from query.");
        }
    }

    /** Properly closes running program.
     * Terminates JVM. Zero passed into exit method indicates normal termination.
     * @param event ActionEvent object holding information on the button pressed
     */
    @FXML
    void onActionExitProgram(ActionEvent event) {
        System.exit(0);
    }

    public void deletion(String item) {
        Optional<ButtonType> result = Alerts.alertConfirm("Click OK to confirm deletion.");
        if(result.get() == ButtonType.OK) {
            if (item.equals("Product")) {
                Product productToDelete = productTableView.getSelectionModel().getSelectedItem();
                if (productToDelete.getAllAssociatedParts().isEmpty()) {
                    Inventory.deleteProduct(productToDelete);
                }
                else {
                    Alerts.alertError("Product not deleted. Remove all associated parts.");
                }
            }
            else if (item.equals("Part")) {
                Part partToDelete = partTableView.getSelectionModel().getSelectedItem();
                Inventory.deletePart(partToDelete);
                if (Inventory.getAllParts().contains(partToDelete)) {
                    Alerts.alertError("Part not deleted.");
                }
            }
        }
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

package controller;

import java.net.URL;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.InHouse;
import model.Inventory;
import model.Outsourced;
import model.Part;


public class MainMenuController implements Initializable {

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

    @FXML
    void onActionAddPart(ActionEvent event) {

    }

    @FXML
    void onActionModifyPart(ActionEvent event) {

    }

    @FXML
    void onActionDeletePart(ActionEvent event) {

    }

    @FXML
    void onActionAddProduct(ActionEvent event) {

    }

    @FXML
    void onActionModifyProduct(ActionEvent event) {

    }

    @FXML
    void onActionDeleteProduct(ActionEvent event) {

    }

    @FXML
    void onActionExitProgram(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partTableView.setItems(Inventory.getAllParts());
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
}

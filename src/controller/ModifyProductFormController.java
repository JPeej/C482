package controller;

import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import model.Part;

/** Controls user input to modify product screen.*/
public class ModifyProductFormController implements Initializable {

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

    @FXML
    void onActionAddAssocPart(ActionEvent event) {

    }

    @FXML
    void onActionRemoveAssocPart(ActionEvent event) {

    }

    /** Event handler for cancel button.
     * Cancel button will pass ActionEvent object that is created when the button is pressed.
     * Calls cancel method via Navigation object. Passes event and string, "MainMenu", for FXMLLoader to use.
     * Confirmation prompts user to cancel or return to modify product screen. Canceling returns user to main menu.
     * See Controller package > Navigation class > cancel method.
     * @param event ActionEvent object holding information on the button pressed
     * @throws IOException
     */
    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        nav.cancel(event);
    }

    @FXML
    void onActionSaveProduct(ActionEvent event) throws IOException {
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
}

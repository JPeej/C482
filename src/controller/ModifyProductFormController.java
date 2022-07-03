package controller;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.net.URL;

public class ModifyProductFormController implements Initializable {

    Navigation nav = new Navigation();

    @FXML
    private TableColumn<?, ?> allPartIdCol;

    @FXML
    private TableColumn<?, ?> allPartInvCol;

    @FXML
    private TableColumn<?, ?> allPartNameCol;

    @FXML
    private TableColumn<?, ?> allPartPriceCol;

    @FXML
    private TableColumn<?, ?> assocPartIdCol;

    @FXML
    private TableColumn<?, ?> assocPartInvCol;

    @FXML
    private TableColumn<?, ?> assocPartNameCol;

    @FXML
    private TableColumn<?, ?> assocPartPriceCol;

    @FXML
    private TextField productAddPartSearch;

    @FXML
    private TextField productIdTxt;

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
    void onActionCancel(ActionEvent event) throws IOException {
        nav.button(event, "MainMenu");
    }

    @FXML
    void onActionRemoveAssocPart(ActionEvent event) {

    }

    @FXML
    void onActionSaveProduct(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}

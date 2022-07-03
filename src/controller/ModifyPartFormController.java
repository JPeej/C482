package controller;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.net.URL;

public class ModifyPartFormController implements Initializable {

    Navigation nav = new Navigation();

    private String partMutableLabel;
    private RadioButton inHouse;
    private RadioButton outSourced;

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
    private ToggleGroup partRadioGroup;

    @FXML
    private Label partRadioLabel;

    @FXML
    private TextField partRadioTxt;

    @FXML
    void onActionInHouse(ActionEvent event) {

    }

    @FXML
    void onActionOutsourced(ActionEvent event) {

    }

    @FXML
    void onActionSavePart(ActionEvent event) {

    }

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        nav.button(event, "MainMenu");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}

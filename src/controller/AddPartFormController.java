package controller;

import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.net.URL;

public class AddPartFormController implements Initializable {

    Navigation nav = new Navigation();

    private String partMutableLabel;
    private RadioButton inHouse;
    private RadioButton outSourced;

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
    void onActionSavePart(ActionEvent event) throws IOException {
        nav.button(event, "MainMenu");
    }

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        nav.cancel(event, "MainMenu");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


}

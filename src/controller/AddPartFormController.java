package controller;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.net.URL;

public class AddPartFormController implements Initializable {

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
    void onActionSavePart(ActionEvent event) {

    }

    @FXML
    void onActionCancel(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


}

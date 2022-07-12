package controller;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Populate {

    public static void tableView(TableView tableToPop, ObservableList list, TableColumn id, TableColumn inv, TableColumn name, TableColumn price) {
        tableToPop.setItems(list);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        inv.setCellValueFactory(new PropertyValueFactory<>("stock"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}

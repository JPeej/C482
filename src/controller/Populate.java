package controller;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

/** Handles population of table views in all screens.*/
public class Populate {

    /** Populates desired table view with provided list.
     * Parses through each object's fields to populate respective columns.
     * Each row consists of one object.
     * @param tableToPop table view in screen to populate
     * @param list list to set to table view
     * @param id idColumn to set parsed id values
     * @param inv invColumn to set parsed inv values
     * @param name nameColumn to set parsed name values
     * @param price priceColumn to set parsed price values
     */
    public static void tableView(TableView tableToPop, ObservableList list, TableColumn id, TableColumn inv, TableColumn name, TableColumn price) {
        tableToPop.setItems(list);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        inv.setCellValueFactory(new PropertyValueFactory<>("stock"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}

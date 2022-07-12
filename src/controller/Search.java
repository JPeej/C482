package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Inventory;
import model.Part;
import model.Product;

import java.awt.*;
import java.util.Locale;

public class Search {

    public static void searchFor(String itemToSearch, TextField searchBar, TableView tableToSearch) {
        try {
            String queryName = searchBar.getText();
            if (itemToSearch.equals("Part")) {
               ObservableList<Part> queryResult = Inventory.lookupPart(queryName);
               if (queryResult.isEmpty()) {
                   int queryID = Integer.parseInt(searchBar.getText());
                   Part result = Inventory.lookupPart(queryID);
                   if (result != null) {
                       queryResult.add(result);
                       tableToSearch.setItems(queryResult);
                   }
                   else {
                       Alerts.alertError("No results found from query.");
                   }
               }
               else {
                   tableToSearch.setItems(queryResult);
               }
            }
            else if (itemToSearch.equals("Product")) {
                ObservableList<Product> queryResult = Inventory.lookupProduct(queryName);
                if (queryResult.isEmpty()) {
                    int queryID = Integer.parseInt(searchBar.getText());
                    Product result = Inventory.lookupProduct(queryID);
                    if (result != null) {
                        queryResult.add(result);
                        tableToSearch.setItems(queryResult);
                    }
                    else {
                        Alerts.alertError("No results found from query.");
                    }
                }
                else {
                    tableToSearch.setItems(queryResult);
                }
            }
        } catch (NumberFormatException e) {
            Alerts.alertError("No results found from query.");
        }
    }
}

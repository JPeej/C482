package controller;

import model.Part;
import model.Product;
import model.Inventory;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;

/** Handles all search queries.*/
public class Search {

    /** Searches parts or products by name or id.
     * Determines if user is searching for part or product.
     * Determines if user is searching by name or id.
     * Returns filtered query list in table view or if not found, the original list.
     * @param itemToSearch user provided query
     * @param searchBar search bar being used for query
     * @param tableToSearch table the search bar is linked to
     */
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

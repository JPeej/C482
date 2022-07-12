package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.util.Locale;

/** Manages all Parts and Products within the company. */
public class Inventory {

    private static int partId = -1;
    private static int productId = 0;
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /** Gets the static partId field to autopopulate part Ids.
     * Post increments the static partId field.
     * RUNTIME ERROR - For some reason I had the return line read as, "return partId++".
     * I was having issues with ID autopopulation as it was incrementing by 3.
     * I used the debugger and a watcher to find the logic bug.
     * The same occurred for populateProductId.
     * @return int partId for use in part creation
     */
    public static int populatePartId() {
        partId += 2;
        return partId;
    }

    /** Gets the static productId field to autopopulate product Ids.
     * Post increments the static productId field.
     * @return int productId for use in product creation
     */
    public static int populateProductId() {
        productId += 2;
        return productId;
    }

    /** Add a Part to the allParts list.
     * allParts manages all Parts within inventory.
     * @param newPart Part to add*/
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    /** Add a Product to the allProducts list.
     * allProducts manages all Products within inventory.
     * @param newProduct Product to add*/
    public static void addProduct(Product newProduct){
        allProducts.add(newProduct);
    }

    /** Search for Part by id.
     * Looks through allParts list for a Part object with desired id.
     * @param partId The desired id to search for
     * @return If found, the desired Part object. If not, null.*/
    public static Part lookupPart(int partId){
        for (Part part : allParts)
            if (part.getId() == partId)
                return part;
        return null;
    }

    /** Search for Product by id.
     * Looks through allProducts list for a Product object with desired id.
     * @param productId The desired id to search for
     * @return If found, the desired Product object. If not, null.*/
    public static Product lookupProduct(int productId){
        for (Product product : allProducts)
            if (product.getId() == productId)
                return product;
        return null;
    }

    /** Search for Part by name substring.
     * Filters allParts list by the name. Searches for sequence of characters.
     * @param partName Sequence of characters to search for
     * @return If found, new filtered list of desired Part object(s). If not, default allParts list.*/
    public static ObservableList<Part> lookupPart(String partName){
        ObservableList<Part> filteredPartList = FXCollections.observableArrayList();

        for (Part part : allParts)
            if (part.getName().toLowerCase(Locale.ROOT).contains(partName))
                filteredPartList.add(part);
            return filteredPartList;
    }

    /** Search for Product by name substring.
     * Filters allProducts list by the name. Searches for sequence of characters.
     * @param productName Sequence of characters to search for
     * @return If found, new filtered list of desired Product object(s). If not, default allProducts list.*/
    public static ObservableList<Product> lookupProduct(String productName){
        ObservableList<Product> filteredProductList = FXCollections.observableArrayList();

        for (Product product : allProducts)
            if (product.getName().contains(productName))
                filteredProductList.add(product);
            return filteredProductList;
    }

    /**Updates a Part within the allParts list.
     * Replaces the Part at the specified position.
     * @param index The Part to replace
     * @param selectedPart The new or updated Part to be added*/
    public static void updatePart(int index, Part selectedPart){
        allParts.set(index, selectedPart);
    }

    /**Updates a Product within the allProducts list.
     * Replaces the Product at the specified position.
     * @param index The Product to replace
     * @param newProduct The new or updated Product to be added*/
    public static void updateProduct(int index, Product newProduct){
        allProducts.set(index, newProduct);
    }

    /** Deletes a Part within the allParts list.
     * Removes first occurrence of desired Part to delete.
     * @param selectedPart The Part to delete
     * @return If found and deleted, true. If not, false.*/
    public static boolean deletePart(Part selectedPart){
        return allParts.remove(selectedPart);
    }

    /** Deletes a Product within the allProducts list.
     * Removes first occurrence of desired Product to delete.
     * @param selectedProduct The Product to delete
     * @return If found and deleted, true. If not, false.*/
    public static boolean deleteProduct(Product selectedProduct){
        return allProducts.remove(selectedProduct);
    }

    /** Show the list of allParts.
     * Returns the list of all Part objects within the Inventory.
     * @return allParts list*/
    public static ObservableList<Part> getAllParts(){
        return allParts;
    }

    /** Show the list of allProducts.
     * Returns the list of all Products objects within the Inventory.
     * @return allProducts list*/
    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    }

    //The following two methods were used for adding test data.
    /*
    static {
        addTestData();
    }

    public static void addTestData(){
        InHouse bolt = new InHouse(1, "Bolt", 1.25, 10, 5, 15, 19);
        Inventory.addPart(bolt);
        Outsourced pipe = new Outsourced(2, "Pipe", 10.00, 3, 1, 5, "Pipes-R-Us");
        Inventory.addPart(pipe);
        InHouse bracket = new InHouse(3, "Bracket", 5.00, 7, 3, 11, 10);
        Inventory.addPart((bracket));
    }
    */
}

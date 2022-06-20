package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    public static void addPart(Part newPart){
        allParts.add(newPart);
    }

    public static void addProduct(Product newProduct){
        allProducts.add(newProduct);
    }

    public static Part lookupPart(int partId){
        for (Part part : allParts)
            if (part.getId() == partId)
                return part;
        return null;
    }

    public static Product lookupProduct(int productId){
        for (Product product : allProducts)
            if (product.getId() == productId)
                return product;
        return null;
    }

    public static ObservableList<Part> lookupPart(String partName){

    }

    public static ObservableList<Product> lookupProduct(String productName){

    }

    public static void updatePart(int index, Part selectedPart){

    }

    public static void updatePart(int index, Product newProduct){

    }

    public static boolean deletePart(Part selectedPart){

    }

    public static boolean deleteProduct(Product selectedProduct){

    }

    public static ObservableList<Part> getAllParts(){

    }

    public static ObservableList<Product> getAllProducts(){

    }
}

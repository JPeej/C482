package model;

import javafx.collections.ObservableList;

/** A Product object that is to be tracked within the inventory, made up of Part objects. */
public class Product {

    private ObservableList<Part> associatedParts;
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    /** Constructor for Product object.
     * Creates a new Product object and populates private fields with provided arguments.
     * @param id The Product's id number
     * @param name The Product's name
     * @param price The Product's price
     * @param stock The amount of Product in stock
     * @param min The minimum amount of Product in stock
     * @param max The maximum amount of Product in stock*/
    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /** Get the id field of the Product.
     * Returns the id field of the desired Product.
     * @return Product id*/
    public int getId() {
        return id;
    }

    /** Set the id field for the Product.
     * Explicitly set the id field for the Product.
     * @param id The new id to set to the Product's id field*/
    public void setId(int id) {
        this.id = id;
    }

    /** Get the name field of the Product.
     * Returns the name field of the desired Product.
     * @return Product name*/
    public String getName() {
        return name;
    }

    /** Set the name field for the Product.
     * Explicitly set the name field for the Product.
     * @param name The new name to set to the Product's name field*/
    public void setName(String name) {
        this.name = name;
    }

    /** Get the price field of the Product.
     * Returns the price field of the desired Product.
     * @return Product price*/
    public double getPrice() {
        return price;
    }

    /** Set the price field for the Product.
     * Explicitly set the price field for the Product.
     * @param price The new price to set to the Product's price field*/
    public void setPrice(double price) {
        this.price = price;
    }

    /** Get the stock field of the Product.
     * Returns the stock field of the desired Product.
     * @return Product stock*/
    public int getStock() {
        return stock;
    }

    /** Set the stock field for the Product.
     * Explicitly set the stock field for the Product.
     * @param stock The new stock to set to the Product's stock field*/
    public void setStock(int stock) {
        this.stock = stock;
    }

    /** Get the min field of the Product.
     * Returns the min field of the desired Product.
     * @return Product min*/
    public int getMin() {
        return min;
    }

    /** Set the min field for the Product.
     * Explicitly set the min field for the Product.
     * @param min The new min to set to the Product's min field*/
    public void setMin(int min) {
        this.min = min;
    }

    /** Get the max field of the Product.
     * Returns the max field of the desired Product.
     * @return Product max*/
    public int getMax() {
        return max;
    }

    /** Set the max field for the Product.
     * Explicitly set the max field for the Product.
     * @param max The new max to set to the Product's max field*/
    public void setMax(int max) {
        this.max = max;
    }

    /** Adds a Part into the Product's list of associatedParts.
     * During Product creation, user can add Parts to the list associatedParts.
     * @param part The Part object to add*/
    public void addAssociatedPart(Part part){
        associatedParts.add(part);
    }

    /** Deletes a Part in the Product's list of associatedParts.
     * User can delete Parts in the list of associatedParts.
     * @param selectedAssociatedPart The Part object to delete
     * @return boolean value if delete was successful or not*/
    public boolean deleteAssociatedPart(Part selectedAssociatedPart){
        return associatedParts.remove(selectedAssociatedPart);
    }

    /** Show the list of associatedParts.
     * Returns the Product's list of all Part objects within the associatedParts list.
     * @return Product list of associatedParts*/
    public ObservableList<Part> getAllAssociatedParts(){
        return associatedParts;
    }
}

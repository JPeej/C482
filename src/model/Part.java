package model;

/** An abstract Part object to be tracked within the inventory.*/
public abstract class Part {

    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    /** Constructor for Part object.
     * Creates a new Part object and populates private fields with provided arguments.
     * @param id The Part's id number
     * @param name The Part's name
     * @param price The Part's price
     * @param stock The amount of Parts in stock
     * @param min The minimum amount of Parts in stock
     * @param max The maximum amount of Parts in stock*/
    public Part(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /** Get the id field of the Part.
     * Returns the id field of the desired Part.
     * @return Part id*/
    public int getId() {
        return id;
    }

    /** Set the id field for the Part.
     * Explicitly set the id field for the Part.
     * @param id The new id to set to the Part's id field*/
    public void setId(int id) {
        this.id = id;
    }

    /** Get the name field of the Part.
     * Returns the name field of the desired Part.
     * @return Part name*/
    public String getName() {
        return name;
    }

    /** Set the name field for the Part.
     * Explicitly set the name field for the Part.
     * @param name The new name to set to the Part's name field*/
    public void setName(String name) {
        this.name = name;
    }

    /** Get the price field of the Part.
     * Returns the price field of the desired Part.
     * @return Part price*/
    public double getPrice() {
        return price;
    }

    /** Set the price field for the Part.
     * Explicitly set the price field for the Part.
     * @param price The new price to set to the Part's price field*/
    public void setPrice(double price) {
        this.price = price;
    }

    /** Get the stock field of the Part.
     * Returns the stock field of the desired Part.
     * @return Part stock*/
    public int getStock() {
        return stock;
    }

    /** Set the stock field for the Part.
     * Explicitly set the stock field for the Part.
     * @param stock The new stock to set to the Part's stock field*/
    public void setStock(int stock) {
        this.stock = stock;
    }

    /** Get the min field of the Part.
     * Returns the min field of the desired Part.
     * @return Part min*/
    public int getMin() {
        return min;
    }

    /** Set the min field for the Part.
     * Explicitly set the min field for the Part.
     * @param min The new min to set to the Part's min field*/
    public void setMin(int min) {
        this.min = min;
    }

    /** Get the max field of the Part.
     * Returns the max field of the desired Part.
     * @return Part max*/
    public int getMax() {
        return max;
    }

    /** Set the max field for the Part.
     * Explicitly set the max field for the Part.
     * @param max The new max to set to the Part's max field*/
    public void setMax(int max) {
        this.max = max;
    }
}

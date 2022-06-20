package model;

/** An Outsourced object that extends the Part object, part is outsourced.*/
public class Outsourced extends Part{

    private String companyName;

    /** Constructor for Outsourced object.
     * Use's the Part's class constructor via the super method and populates fields with provided arguments.
     * @param id The Outsourced Part's id number
     * @param name The Outsourced Part's name
     * @param price The Outsourced Part's price
     * @param stock The amount of Outsourced Parts in stock
     * @param min The minimum amount of Outsourced Parts in stock
     * @param max The maximum amount of Outsourced Parts in stock
     * @param companyName The Outsourced Part's company name*/
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    /** Get the companyName field of the Outsourced Part.
     * Returns the companyName field of the desired Outsourced Part.
     * @return Part companyName*/
    public String getCompanyName() {
        return companyName;
    }

    /** Set the companyName field for the Outsourced Part.
     * Explicitly set the companyName field for the Outsourced Part.
     * @param companyName The new companyName to set to the Outsourced Part's companyName field*/
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

package model;

/** An Inhouse part object that extends the Part abstract object, part made in house.*/
public class InHouse extends Part{

    private int machineId;

    /** Constructor for Inhouse object.
     * Use's the Part's class constructor via the super method and populates fields with provided arguments.
     * @param id The InHouse Part's id number
     * @param name The InHouse Part's name
     * @param price The InHouse Part's price
     * @param stock The amount of InHouse Parts in stock
     * @param min The minimum amount of InHouse Parts in stock
     * @param max The maximum amount of InHouse Parts in stock
     * @param machineId The Inhouse Part's machine id number*/
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    /** Get the machineId field of the Inhouse Part.
     * Returns the machineId field of the desired Inhouse Part.
     * @return Part machineId*/
    public int getMachineId() {
        return machineId;
    }

    /** Set the machineId field for the Inhouse Part.
     * Explicitly set the machineId field for the Inhouse Part.
     * @param machineId The new machineId to set to the Inhouse Part's machineId field*/
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
}

public class Building {
    //Attributes
    protected String name = "<Name Unknown>";
    protected String address = "<Address Unknown>";
    protected int nFloors = 1;
    /**
     * constructor for the building
     * @param name takes in the name of the building
     * @param address for the address of the building
     * @param nFloors for the number of the floors of the building, throws a runtime exception
     *         if one tries to make a house with less than 1 floors
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; }
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
            this.nFloors = nFloors;
    }
    /**
     * An accessor for the building name
     * @return the names of the building
     */
    public String getName() {
        return this.name;
    }
    /**
     * accessor for the address of the building
     * @return the address of the building
     */
    public String getAddress() {
        return this.address;
    }
    /**
     * accessor for the number of floors of a building
     * @return the number of the floors that the building has
     */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * toString method to print information about the building
     * @return the building's name, floors number and its address
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }
    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }
}

import java.util.ArrayList;
public class House extends Building {
    /**
     * Attributes
     * Arraylist for the residents
     *Boolean attribute for whether the house has a dining room or not
     */
    private ArrayList<String> residents;
    private final boolean hasDiningRoom;
    private int maxcapacity, initialCapacity;

    /**
     *  Constructor for the House subclass
     * @param name takes in the name of the house
     * @param address takes in the adress of the house
     * @param nFloors takes in the number of floors in the house
     * @param hasDiningRoom checking whether it has a dining hall or not with boolean
     * @param initialCapacity  takes in the initial capacity of the house
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom, int initialCapacity) {
        super(name, address, nFloors);
        this.hasDiningRoom = hasDiningRoom;
        this.initialCapacity = initialCapacity;
        residents = new ArrayList<>(initialCapacity);
        System.out.println("You have built a house: 🏠 called " + this.getName());
    }

    /**
     * method to  verify if the house has a dining room
     * @return true if it has a dining room or false if otherwise
     */
    public boolean hasDiningRoom(){
        if(this.hasDiningRoom){
            System.out.println("The house has a dining room");
            return true;
        } else{
            System.out.println(name+" has no dining room");
            return false;
        }
    }
    /**
     * method to show the number of residents currently living in the house
     * @return the size of the house
     */
    public int nResidents(){
        if(residents == null){
            System.out.println("There are no residents in the house.");
            return 0;
        } else{
            return residents.size();
        }
    }
    /**
     * method for adding a new resident
     * @param name takes in the name of the resident
     * notifies user that the resident can't be added if the houselist contains the resident or
     * if the house is full
     * adds the new resident if otherwise
     */
    public void moveIn(String name){
        if(residents.contains(name)){
            System.out.println("Resident is already in the house.");
        } else{
            if(residents.size()>=maxcapacity){
                System.out.println("The house is full, cannot add this person to this house");
            } else{
                residents.add(name);
            }
        }
    }

    /**
     * the method for moving out a resident
     * @param name take the name of the resident
     * notifies when the resident is not found
     * @return their name with whether they were removed from the house or not
     */
    public String moveOut(String name){
        if(!residents.contains(name)){
            throw new RuntimeException("Resident "+name+" does not live in this house.");
        } else{
            residents.remove(name);
            System.out.println(name+" has been removed from the house.");
            return name;
        }
    }

    /**
     * method to verify if someone if a resident of the house
     * @param person takes in the name of the person
     * @return true if the person lives there or false if otherwise
     */
    public boolean isResident(String person){
        return residents.contains(person);
    }
    /**
     * toString function for formatted output
     * @return the house details
     */
    public String toString() {
        return super.toString() + " which can house "+maxcapacity+" students and it's " + hasDiningRoom + " that it has a dining room";
    }
    public static void main(String[] args) {
        House tyler=new House("Tyler house", "4 Green St", 2, true, 60);
        House washburn= new House("Washburn House", "2 Seelye Drive",4,false, 45);
        System.out.println(tyler);
        System.out.println(washburn);
        String resident1="Keza";
        String resident2="Amy";
        String resident3="Bob";
        String resident4="Boba";
        String resident5="Lyse";
        washburn.moveIn(resident1);
        washburn.moveIn(resident2);
        tyler.residents.add(resident4);
        tyler.residents.add(resident5);
        tyler.moveOut(resident1);
        washburn.nResidents();
        washburn.hasDiningRoom();

    }
}

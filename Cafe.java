import java.util.Scanner;
public class Cafe extends Building {
    //Attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups;// The number of cups remaining in inventory
    Scanner scan = new Scanner(System.in);
    /**
     * Constructor for the cafe class
     * @param name takes in the name of the cafe
     * @param address takes in the address of the cafe
     * @param nFloors takes in the number of its floors
     * @param coffeeOunces takes in the coffee ounces  in the stock
     * @param sugarPackets takes in the sugar packets in the stock
     * @param creams takes in the number of creams in the stock
     * @param cups takes in the number of cups in the stock
     */
    public Cafe(String name, String address, int nFloors,int coffeeOunces, int sugarPackets, int creams, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffeeOunces;
        this.nSugarPackets = sugarPackets;
        this.nCreams = creams;
        this.nCups = cups;
    }
    /**
     * method to reduce the stock when coffee is sold
     * @param size takes in the number of coffee ounces used to be reduced from stock
     * @param nSugarPackets takes in the number of sugar packets used in the coffee
     * @param nCreams takes in the number of creams used in the coffee
     * notifies the user when the materials are not enough and restocks
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(((this.nCoffeeOunces-size>=0)&&(this.nSugarPackets-nSugarPackets>=0)&&(this.nCreams-nCreams>=0)&&(nCups>=0))){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("Enjoy your coffee.");
        } else{
            System.out.println("");
            System.out.println("You don't have enough materials to make good coffee. Let's restock");
            System.out.println("Enter the number of coffee ounces to restock:");
            int nCoffeeOunce= scan.nextInt();
            System.out.println("Enter the number of sugar packets to restock:");
            int nSugarPacket= scan.nextInt();
            System.out.println("Enter the number of creams to restock:");
            int nCream= scan.nextInt();
            System.out.println("Enter the number of cups to restock:");
            int nCup= scan.nextInt();
            restock(nCoffeeOunce, nSugarPacket, nCream, nCup);
        }
    }
    /**
     * Method to restock the materials
     * @param nCoffeeOunces takes in number of coffee ounces to be added
     * @param nSugarPackets takes in number of sugarpackets added
     * @param nCreams takes in the number of creams added to stock
     * @param nCups takes in the number of cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }
    public static void main(String[]args){
        Cafe ccCafe=new Cafe("Campus Center Cafe", " 1 Chapin Way",3,50, 120,150,100);
        System.out.println(ccCafe);
        ccCafe.sellCoffee(2, 10, 20);
        ccCafe.sellCoffee(2, 1700, 20);
    }
}

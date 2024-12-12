import java.util.Hashtable;
public class Library extends Building {
    /**
     * Attributes
     * The hashtable to contain the books
     */
    private Hashtable<String, Boolean> collection;
    /**
     * Constructor of the library
     * @param name takes in the name of the library
     * @param address takes in the address of the library
     * @param nFloors takes in the number of the floors of the library
     */
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        collection = new Hashtable<>();
    }

    /**
     * Method for adding a new book to the library
     * @param title takes in the name of the book to be added to the library
     */
    public void addTitle(String title){
        collection.put(title, true);
    }
    /**
     * Method for removing a book in the library
     * @param title takes in the name of the book to be removed
     * verifies if the book is in the library
     * @return the title if it has been found and removed
     * verifies if the book is not in the library
     * @return that the title has not been found if it was not
     */
    public String removeTitle(String title){
        if(collection.containsKey(title)){
            collection.remove(title);
        System.out.println( title + " removed");
        return title;
        } else{
            System.out.println( title + " not found in library");
            return null;
        }
    }

    /**
     * Method to check out the book
     * @param title takes in the name of the book
     * allows one to borrow the book if it is available and changes it's statues to false
     * else notifies them if it is not available for borrowing
     */
    public void checkOut(String title){
        if(collection.containsKey(title)&&(collection.get(title)==true)){
            collection.put(title,false);
        } else{
            System.out.println(title + " is not available to be borrowed");
        }
     }
    /**
     * method for returning a borrowed book
     * @param title takes in the name and author of the book
     * if the status is false, it is updated to true hence returned
     * else notifies the user that the book was already returned
     */
    public void returnBook(String title){
        if(collection.containsKey(title)){
            if(collection.get(title)==(false)){
                collection.put(title,true);
            } else{
                System.out.println(title + "was already returned");
            }
        }
    }
    /**
     * method to verify if the library has a certain book
     * @param title takes in the name and the author of the book to be checked
     * @return  true if the book is owned or false if it is not owned by the library
     */
    public boolean containsTitle(String title){
        if (collection.containsKey(title)){
            return true;
        } else{
            return false;
        }
    }

    /**
     * method to verify whether the book is available i.e not borrowed
     * @param title takes in the name and author of the book to be checked
     * @return true if its current availabilty status is true or false if it is borrowed
     */
    public boolean isAvailable(String title){
        if(collection.containsKey(title)){
            if ((collection.get(title)==true)){
                System.out.println(title + " is available");
                return true;
            } else{
                System.out.println(title + " is not currently available");
                return false;
            }
        } else{
            System.out.println(title + " is not owned by the library");
            return false;
        }
    }

    /**
     * Method to print the books in the collection with their availability status
     */
    public void printCollection(){
        System.out.println("");
        System.out.println("The list of books in the library are: ");
        System.out.println(collection);
    }

    /**
     * toString method to print the size of the library collection
     * @return the size of the library books
     */
    public String toString(){
        return super.toString()+" with "+collection.size()+" books";
    }
    public static void main(String[] args) {
        Library library = new Library("Neilson Library", "7 Neilson Drive", 3);
        System.out.println(library);
        library.addTitle("Divergent by Veronica Ruth");
        library.addTitle("Insurgent by Veronica Ruth");
        library.checkOut("Allegiance by Veronica Ruth");
        library.checkOut("Divergent by Veronica Ruth");
        library.isAvailable("Allegiance by Veronica Ruth");
        library.isAvailable("Carve the Mark by Veronica Ruth");
        library.isAvailable("Divergent by Veronica Ruth");
        library.printCollection();
    }
}

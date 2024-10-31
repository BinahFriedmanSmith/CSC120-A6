/* This is a stub for the Library class */

import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors); 
      collection = new Hashtable<>();
      System.out.println("You have built a library: 📖");
    }
    
    /**
     * adds a book to the collection
     * @param title book to add
     */
    public void addTitle(String title){
      collection.put(title, true);
    }

    /**
     * removes a book from the collection
     * @param title title of book to remove
     * @return title of removed book
     */
    public String removeTitle(String title){
      if (this.containsTitle(title)){
        if (isAvailable(title)){
          collection.remove(title);
          return title;
        }
        else {
          throw new RuntimeException("Cannot remove book which is checked out");
        }
      }
      else {
        throw new RuntimeException("Cannot remove book which is not in collection");
      }
    }

    /**
     * checks out a book (sets the associated value to false)
     * @param title book to check out
     */
    public void checkOut(String title){
      if (this.containsTitle(title)){
        if (isAvailable(title)){
          collection.put(title, false);
        }
        else {
          throw new RuntimeException("Cannot check out book which is already checked out");
        }
      }
      else {
        throw new RuntimeException("Cannot check out book which is not in collection");
      }
    }

    /**
     * returns a book (sets the associated value to true)
     * @param title book to return
     */
    public void returnBook(String title){
      if (this.containsTitle(title)){
        if (!isAvailable(title)){
          collection.put(title, true);
        }
        else {
          throw new RuntimeException("Cannot return book which is already at location");
        }
      }
      else {
        throw new RuntimeException("Cannot return book which is not in collection");
      }
    }

    /**
     * returns true if the title appears as a key in the Libary's collection, false otherwise
     * @param title book to check
     * @return true if the title appears as a key in the Libary's collection, false otherwise
     */
    public boolean containsTitle(String title){
      return collection.containsKey(title);
    } 

    /**
     * returns true if the title is currently available, false otherwise
     * @param title book to check availiability
     * @return  true if the title is currently available, false otherwise
     */
    public boolean isAvailable(String title){
      if (this.containsTitle(title)){
        return collection.get(title);
      }
      else {
        return false;
      }
    } 

    /**
     * prints out the entire collection in an easy-to-read way (including checkout status)
     */
    public void printCollection(){
      collection.forEach(
        (k, v) -> System.out.println(k + " \n\tAvaliable? " + v));
    } 

    public static void main(String[] args) {
      Library neilson = new Library("Neilson Library", "7 Neilson Drive", 4);
      System.out.println(neilson);
      System.out.println("adding books to collection");
      neilson.addTitle("Fables: Legends in exile");
      neilson.addTitle("Galactus");
      neilson.addTitle("Soldier's Heart");
      System.out.println("checking out a book");
      neilson.checkOut("Soldier's Heart");
      System.out.println("printing collection");
      neilson.printCollection();
    }
  
  }
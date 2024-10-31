import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building{

  ArrayList<String> residents;
  Boolean hasDining;

  public House(String name, String address, int nFloors, boolean hasDining) {
    super(name, address, nFloors);
    this.hasDining = hasDining;
    this.residents = new ArrayList<>();
    System.out.println("You have built a house: 🏠");
  }

  /**
   * returns whether the hose has a dining hall
   * @return true if there is a dining hall, false if not
   */
  public boolean hasDiningRoom() {
    return hasDining;
  }

  /**
   * Getter for number of current residents
   * @return number of current residents
   */
  public int nResidents(){
    return residents.size();
  }

  /**
   * adds a person to the arraylist of residents
   * @param name person to add
   */
  public void moveIn(String name){
    if (isResident(name)){     
      throw new RuntimeException(name + " is already a resident of " + this.getName());
    }
    else {
      residents.add(name);
    }
  }

  /**
   * removes a resident from the arraylist of residents
   * @param name name of the person to move out
   * @return the name of the person who moved out
   */
  public String moveOut(String name){
    if (isResident(name)){
      residents.remove(residents.indexOf(name));
      return name;
    }
    else {
      throw new RuntimeException("Cannot remove person who is not a resident");
    }
  } 

  /**
   * 
   * @param person
   * @return whether input person is a resident (in the instance's residents ArrayList)
   */
  public boolean isResident(String person){
    return residents.contains(person);
  }


  public static void main(String[] args) {
    House gillett = new House("Gillett House", "47 Elm street",5, true);
    System.out.println(gillett + ". It is " + gillett.hasDiningRoom() + " that it has a dining room.");
    String binah = "Binah";
    System.out.println("checking if Binah is a resident: " + gillett.isResident(binah));
    System.out.println("attempting to move in Binah");
    gillett.moveIn(binah);
    System.out.println("checking if Binah is a resident: " + gillett.isResident(binah));
    System.out.println("attempting to move out Binah");
    gillett.moveOut(binah);
    System.out.println("checking if Binah is a resident: " + gillett.isResident(binah));
    System.out.println("attempting to move out Binah a second time");
    gillett.moveOut(binah);
    System.out.println("checking if Binah is a resident: " + gillett.isResident(binah));
  }
}
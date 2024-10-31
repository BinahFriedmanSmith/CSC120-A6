/* This is a stub for the Cafe class */
public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    
    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors); 
        System.out.println("You have built a cafe: ☕");
        nCoffeeOunces = coffee;
        nSugarPackets = sugar;
        nCreams = cream;
        nCups = cups;
    }

    /**
     * removes ingredients for a requested coffee from the inventory
     * @param size ounces of coffee in the order
     * @param nSugarPackets # of packets of sugar in the order
     * @param nCreams # of creams in the order
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (size > nCoffeeOunces){
            restock(size+100, 0,0,0);
        }
        if (nSugarPackets > this.nSugarPackets){
            restock(0, nSugarPackets + 10,0,0);
        }
        if (nCreams > this.nCreams){
            restock(0, 0,nSugarPackets + 10,0);
        }
        if (1 > this.nCups){
            restock(0, 0, 0,10);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }
    
    /**
     * increases inventory levels by input amounts
     * @param nCoffeeOunces oz coffee to buy
     * @param nSugarPackets packets sugar to buy
     * @param nCreams creams to buy
     * @param nCups # cups to buy
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups)
    {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "7 Neilson Drive", 1, 150, 50, 50, 50);
    }
    
}

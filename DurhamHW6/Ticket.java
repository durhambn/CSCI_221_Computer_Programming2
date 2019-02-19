
/**
 * 
 * Brandi Durham
 * 
 * The abstract Ticket class with the constructor and methods 
 */
public abstract class Ticket
{
    private int ticketNum;
    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(int a)
    {
        ticketNum = a;
    }
    /** 
     * Every subclass must implement this method, to compute price
     */
    public abstract int getPrice();
    /**
     * The toString must be implmented for each subclass to return a
     * string with ticket num and price
     */
    public String toString()
    {
        return "Ticket Number: " + ticketNum + ", Price: $";
    }
}

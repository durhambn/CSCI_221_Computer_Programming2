import java.text.NumberFormat;
/**
 * A WalkupTicket is a Ticket bought on day of event.
 * 
 * @author (McCauley) 
 */
public class WalkupTicket extends Ticket
{
    // Current set price
    final double price = 50;
 
    // Every ticket has a number, and a set price
    public WalkupTicket(int number) throws BadTicketNumberException{
        super(number);
    }
    
    /**
     * Returns the price for walk-up ticket 
     */
    public double getPrice()
    {
        // put your code here
        return price;
    }
    
    /**
     * Returns a Strings that represents WalkupTicket objects
     *   Form: Number: XX, Price $XX.XX
     */
    public String toString(){
        
        return super.toString() + ", Price: " + NumberFormat.getCurrencyInstance().format(getPrice());
        
    }
//     public Ticket compareTo(WalkupTicket a){
//      return super.compareTo(a);
//     }
}

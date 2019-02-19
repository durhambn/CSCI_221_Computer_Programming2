import java.text.NumberFormat;
/**
 * Models a ticket bought in advance (a # of days in
 * advance).
 * 
 * @author (McCauley) 
 */
public class AdvanceTicket extends Ticket// implements Comparable
{
    // must record days
    private int days;
    // prices and cutOff for price difference
    final double regular = 40.0;
    final double early = 30.0;
    final int earlyCutOff = 10;

    /**
     * Constructor for objects of class AdvanceTicket, 
     * requires a ticket number and the days before the event
     */
    public AdvanceTicket(int number, int days) throws BadTicketNumberException, BadDaysRangeException
    {
        super(number);
        if(days < 180 && days >= 0)
        this.days = days;
        else
        throw new BadDaysRangeException(days);
    }
        
    

    /**
     * Returns the appropriate price
     *   for a ticket, based on the days until the event
     */
    public double getPrice()
    {
        double price;
        if (days <= earlyCutOff)
           price = regular;
        else
           price = early;
        // put your code here
        return price;
    }
    
    /**
     * Returns a Strings that represents AdvanceTicket objects
     *   Form: Number: XX, Price $XX.XX
     */
    public String toString(){
        
        return super.toString() + ", Price: " + NumberFormat.getCurrencyInstance().format(getPrice());
    }
//     public Ticket compareTo(Ticket a){
//         return super.compareTo(a);
//     }
}

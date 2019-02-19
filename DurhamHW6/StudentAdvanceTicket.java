
/**
 * 
 * Brandi Durham
 * 
 * StudentAdvanceTicket is a subclass of AdvanceTicket
 * is used when a student buys a ticket in advance
 * 
 */
public class StudentAdvanceTicket extends AdvanceTicket
{
    private int ticketPrice;
    public StudentAdvanceTicket(int num, int days)
    {
        super(num, days);
        
    }
    public int getPrice()
    {
        if(numDays >= 10)
        ticketPrice = PRICE_10MORE/2;
        else if(numDays < 10)
        ticketPrice = PRICE_10LESS/2;
        return ticketPrice;
    }
    public String toString()
    {
        return super.toString() + " (Bring ID)";
    }
}

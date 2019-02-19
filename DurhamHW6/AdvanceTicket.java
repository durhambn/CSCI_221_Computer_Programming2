
/**
 * 
 * Brandi Durham
 * 
 * AdvanceTicket is an subclass of Ticket that
 * has the options of prices if a person buys 
 * their ticket early
 * 
 */
public class AdvanceTicket extends Ticket
{
    int PRICE_10MORE = 30;
    int PRICE_10LESS = 40;
    private int ticketPrice;
    int numDays;
    public AdvanceTicket(int num, int days)
    {   
        super(num);
        numDays = days;  
    }
    public int getPrice()
    {
        if(numDays >= 10)
        ticketPrice = PRICE_10MORE;
        if(numDays < 10)
        ticketPrice = PRICE_10LESS; 
        return ticketPrice;
    }
    public String toString()
    {
        return super.toString() + getPrice();
    }
}

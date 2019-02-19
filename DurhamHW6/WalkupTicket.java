
/**
 * 
 * Brandi Durham
 * 
 * The walkupTicket is a subclass of Ticket that 
 * is when a person buys a ticket at the door
 * 
 */
public class WalkupTicket extends Ticket
{
    int WALKUP_PRICE = 50;
    private int ticketPrice;
    public WalkupTicket(int a)
    {
        super(a);
        
    }
    public int getPrice()
    {
        ticketPrice = WALKUP_PRICE;
        return ticketPrice;
    }
    public String toString()
    {
        return super.toString() + getPrice();
    }
}

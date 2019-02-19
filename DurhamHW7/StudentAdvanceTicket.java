
/**
 * Students get a discount, hence StudentAdvanceTicket.
 * 
 * @author (McCauley) 
 */
public class StudentAdvanceTicket extends AdvanceTicket
{
    
    /**
     * Construct a StudentAdvanceTicket with ticket number
     * and days in advance
     */
    public StudentAdvanceTicket(int number, int days) throws BadTicketNumberException, BadDaysRangeException
    {
        
            super(number, days);
       
    }

    /**
     * Return the price, half of the AdvanceTicket price
     */
    public double getPrice()
    {
        // put your code here
        return super.getPrice()/2;
    }
    public String toString()
    {
        return super.toString() + " (ID required)";
    }
   
}

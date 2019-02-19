
/**
 * Write a description of class BadTicketNumberException here.
 * 
 * Brandi Durham
 */
public class BadTicketNumberException extends Exception
{
    

    /**
     * Constructor for objects of class BadTicketNumberException
     */
    public BadTicketNumberException(int e)
    {
        if(e<0)
                System.out.println("Exception: Cannon sell ticket number " + e + ". Invalid number provided");
        else
                System.out.println("Exception: Cannon sell ticket number " + e + ". Ticket number already in use.");
    }
}

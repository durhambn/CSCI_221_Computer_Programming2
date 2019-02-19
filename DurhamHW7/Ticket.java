import java.util.*;
/**
 * Abstract super class for event Ticket.
 * 
 * @author (McCauley) 
 * @version (a version number or a date)
 */
public abstract class Ticket //implements Comparable
{
    // every ticket has a number
    private int number;
    //int[] numHolder = new int[10];
    static ArrayList<Integer> numHolder = new ArrayList();
    private int i = 0;

    /**
     * Construct a Ticket with given number
     */
    public Ticket(int number) throws BadTicketNumberException
    {
        // initialise instance variables

        if(number < 0)
            throw new BadTicketNumberException(number);
        else 
        {

            for(int j = 0; j < numHolder.size(); j++)
            {
                
                if(number == numHolder.get(j))
                {
                    
                throw new BadTicketNumberException(number);
            }
               
    
            }
            this.number = number;
            numHolder.add(i, number);
            
            //System.out.println(numHolder.get(i));
            i++;
            //System.out.println(number + " " + numHolder.get(0));
        }
        
    }
    // Every Ticket type will determine price
    public abstract double getPrice();
    
    // string representation of general Ticket
    public String toString(){
        return "Number " + number;
    }
    /*
    public Ticket compareTo(Ticket a)
    {
        if((a != null) && (a instanceof Ticket))
        {
            Ticket newTic = (Ticket) a;
            if(this.number >= a.number)
            return this;
            else //if ( this.number < a.number)
            return a;
        }
        else
            return null;
    }
    */
    
    
}

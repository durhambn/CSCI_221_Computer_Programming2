
/**
 * Write a description of class BadDaysRangeException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadDaysRangeException extends Exception
{



    /**
     * Constructor for objects of class BadDaysRangeException
     */
    public BadDaysRangeException(int days)
    {
        if (days>180)
            System.out.println("Exception: Cannot sell ticket with " + days + " days in advance");
        else if(days <0)
            System.out.println("Exception: " + days + " days in advance specified must be positive"); 
    }
}

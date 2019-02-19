
/**
 * Write a description of class BadInputCodeException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadInputCodeException extends Exception
{
    /**
     * Constructor for objects of class BadInputCodeException
     */
    public BadInputCodeException(int a, int b)
    {
        System.out.println("Bad code #" + a + " encountered on line " + b + " of input.txt. Line ignored."); 
    }
}

import java.io.*; // for use of files
import java.util.*; // for use of Scanner class
/**
 * TicketTester exercises the Ticket hierarchy 
 * and the exception classes in creating an ordered 
 * list of Tickets.
 * 
 * My code has everything except the compareTo method
 * 
 * Brandi Durham
 */
public class TicketTester
{

    public static void main(String [] args) {
        
        WalkupTicket a;
        AdvanceTicket b;
        StudentAdvanceTicket c;
        int ticketNum = 0;
        int days = 0;
        /*
         * This try/catch block checks the input from the file and catches FileNotFoundException
         */
        try{
            
            // the following line will throw a FileNotFoundException if 
            // the file specified cannot be found. 
            // DO NOT CHANGE FILE NAME when you submit
            File inputFile = new File("inputFile.txt");
            
            // add the code that reads from the input file and throws
            Scanner input = new Scanner(inputFile);
            
            // valid tickets will be stored, in order, in list
            ArrayList<Ticket> list = new ArrayList();
            // The following code reads from the file and 
            // stores Ticket data into an ordered list
            
            // The loop to read the data encloses a 
            // try-catch block to process input from input file
            // and continue reading until every line from the file
            // is read and processed.
            int i = 0;

            while(input.hasNext()){
                /*
                 * This try/catch block reads the input and catches BadInputCodeExceptions, BadTicketNumberException, 
                 * and BadDaysRangeException. 
                 */
                try{
                
                int inInt = input.nextInt();
                //System.out.println(inInt);
                ticketNum = input.nextInt();
                
                if( inInt != 1 && inInt != 2 && inInt != 3){
                  new BadInputCodeException(inInt, i);
                }
                if(inInt == 1){
                a = new WalkupTicket(ticketNum);
                int counter = 0;
                //                     while(counter <= list.size()){
                //                         if(a.compareTo(list.get(counter)) == a)
                //                         list.add(counter, a);
                //                         else if(counter == list.size())
                //                         list.add(a);
                //                         else
                //                         counter++;
                //                     }
                list.add(a);
                //System.out.println(list.get(i));
                i++;
                }
                else if(inInt == 2){
                days = input.nextInt();
                b = new AdvanceTicket(ticketNum, days);
                int counter = 0;
                //                     while(counter <= list.size()){
                //                     if(b.compareTo(list.get(counter)) == b)
                //                     list.add(counter, b);
                //                     else if(counter == list.size())
                //                     list.add(b);
                //                     else
                //                     counter++;
                //                 }
                list.add(b);
                //System.out.println(list.get(i));
                i++;
                }
                else if(inInt == 3){
                days = input.nextInt();
                c = new StudentAdvanceTicket(ticketNum, days);
                int counter = 0;
                //                     while(counter <= list.size()){
                //                     if(c.compareTo(list.get(counter)) == c)
                //                     list.add(counter, c);
                //                     else if(counter == list.size())
                //                     list.add(c);
                //                     else
                //                     counter++;
                //                 }
                list.add(c);
                //System.out.println(list.get(i));
                i++;
                }
                //System.out.println(list.get(i));
                
                //else
                //{
                    //int extra = input.nextInt();
                //}
                //String restOfLine = input.next();
                
                
                // You may add other methods, as necessary, to solve
                // this problem.
                }
                catch (BadTicketNumberException e){
                //BadTicketNumberException k = new BadTicketNumberException(ticketNum);
                /*if(ticketNum<0)
                System.out.println("Exception: Cannon sell ticket number " + ticketNum + ". Invalid number provided");
                else
                System.out.println("Exception: Cannon sell ticket number " + ticketNum + ". Ticket number already in use.");
                */
                 }
                catch (BadDaysRangeException e) {
                //BadDaysRangeException d = new BadDaysRangeException(days);
               /*if (days<0)
                System.out.println("Exception: Cannot sell ticket with" + days + "days in advance");
                else
                System.out.println("Exception:" + days + " days in advance specified must be positive"); 
                */
                 }
                  
           }
           /*
            * This prints out all the tickets in the arraylist list. Wasn't sure if you wanted it to print
            * as it went or at the end.
            */
           for(int num = 0; num < list.size(); num++)
           {
               System.out.println(list.get(num));
            }
           
        }
       catch (FileNotFoundException e) {
           System.out.println("No file found!");
           // Program terminates, as there is not input to process      
        }  

       
    }
}

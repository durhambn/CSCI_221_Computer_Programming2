
/**
 * 
 * Brandi Durham
 * 
 * TestTickets is a class that tests all the ticket buying options
 * 
 */
public class TestTickets
{
    public static void main(String [] args)
    {
        WalkupTicket a = new WalkupTicket(1);
        System.out.println(a);
        System.out.println(a.getPrice());
        
        AdvanceTicket b = new AdvanceTicket(2, 5);
        System.out.println(b);
        System.out.println("Should be 40 : " + b.getPrice());
        
        AdvanceTicket c = new AdvanceTicket(3, 10);
        System.out.println(c);
        System.out.println("Should be 30 : " + c.getPrice());
        
        AdvanceTicket d = new AdvanceTicket(4, 15);
        System.out.println(d);
        System.out.println("Should be 30 : " + d.getPrice());
        
        StudentAdvanceTicket e = new StudentAdvanceTicket(5, 5);
        System.out.println(e);
        System.out.println("Should be 20 : " + e.getPrice());
        
        StudentAdvanceTicket f = new StudentAdvanceTicket(6, 10);
        System.out.println(f);
        System.out.println("Should be 15 : " + f.getPrice());
        
        StudentAdvanceTicket g = new StudentAdvanceTicket(7, 15);
        System.out.println(g);
        System.out.println("Should be 15 : " + g.getPrice());
    }
}

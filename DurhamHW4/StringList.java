
/**
 *class String is a class that stores an array of stings that the user adds. 
 *The class have different methods to add, delete, and insert. As well as 
 *methods to get the size of the array, see if the array contains a certian string, 
 *and to display the array.
 * 
 * Brandi Durham
 * 3/17/17
 * HW4
 * 
 * 
 */
public class StringList
{
    //     public static void main(String [] args)
    //     {
    //         StringList myList = new StringList();
    //         myList.displayList();
    //         myList.add("1");
    //         myList.add("2");
    //         myList.add("3");
    //         myList.add("4");
    //         myList.add("5");
    //         myList.add("6");
    //         myList.add("7");
    //         myList.add("8");
    //         myList.add("9");
    //         myList.add("10");
    //         myList.displayList();
    //         System.out.println(myList.size());
    //         myList.insert("new", 5);
    //         System.out.println(myList.size());
    //         myList.displayList();
    //         System.out.println(myList.size());
    //         System.out.println(myList.contains("new"));
    //         System.out.println(myList.contains("55"));
    //         System.out.println(myList.find("new"));
    //         System.out.println(myList.find("55"));
    //         myList.delete("8");
    //         myList.displayList();
    //         
    //     }
    //size give tha number of ints in the array
    private int size = 0;
    //capacity gives the number of places availible in the array
    private int capacity = 0;
    private String[] list;
    //Instantiates an empty StringsList with maximum capacity of 
    //10, that will store strings (String values).
    public StringList()
    {
        this.list = new String[10];
        this.capacity = 10;
        //System.out.print(list);
    }
    //Returns the number of elements currently stored in the list. 
    public int size()
    {
        int i = 0;
        while((i < list.length) && (list[i] != null))
        {
            i++;
        }
        this.size = i;  
        System.out.print("The size of this list is ");
        return this.size;
    }
    //Inserts String a at the end of the list.
    public void add(String a)
    {
        int i = this.size;
        if(i == capacity)
            this.enlarge();
        list[i] = a;
        this.size ++;
    }
    //Inserts String a in the specific user-numbered location in the list. 
    public void insert(String a, int location)
    {
        if(size + 1 > capacity)
            this.enlarge();
        for(int i = size; i >= location; i--)
        {
            String store = list[i-1];
            list[i] = store;
        }
        list[location-1] = a;
        size++;
    }
    //Returns true if String a is in the list, false otherwise.
    public boolean contains (String a)
    {
        boolean contain = false;
        for(int i = 0; i<size; i++)
        {
            if(list[i].equals(a))
                contain = true;
        }
        return contain;
    }
    //Returns the index (a value from 1 to size) 
    //of a in the list,or-1if aisnotinthelist.
    public int find(String a)
    {
        int i = -1;
        for(int j = 0; j<size; j++)
        {
           if(list[j].equals(a))
                i= j+1;
        }
        return i;
    }
    //Removes the String a, if it is in the list.
    public void delete(String a)
    {
        int i = -1;
        for(int j = 0; j<size; j++)
        {
           if(list[j].equals(a))
                i= j;
        }
        for(int k = i; k < size; k++)
           {
            String store = list[k+1];
            list[k] = store;
           }
        size--;
    }
    //Prints the contents of the StringsList 
    public void displayList()
    {
        System.out.println("StringList: capacity " + this.list.length + ", size " + this.size);
        for(int i = 1; i<=list.length; i++)
        {
            System.out.println("[" + i + "] " + list[i-1]);
        }
    }
    //Doubles the capacity of the list, whenever needed.
    private void enlarge()
    {
        String[] newList = new String[capacity*2];
        for(int i = 0; i < capacity; i++)
        {
            newList[i] = list[i];
        }
        this.capacity = capacity*2;
        this.list = newList;
    }
}
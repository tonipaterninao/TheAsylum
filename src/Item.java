
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String Description ;
    private int Weight;

    /**
     * Constructor for objects of class Item
     */
    public Item(String Description, int Weight)
    {
      this.Description=Description;
      this.Weight=Weight;
    }
    
    public int getWeight()
    {
        return Weight;
    }
     public String getDescription()
    {
        return Description;
    }
    public boolean equals(Item i)
    {
        return (Description.equals(i.Description) && Weight==i.Weight);
    }
    

 
}

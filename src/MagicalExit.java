
/**
 * Class MagicalExit, a type of door that requires a password to be open.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicalExit extends ExitRoom
{
    // instance variables - replace the example below with your own
    private Item key;
    

    /**
     * Constructor for objects of class MagicalRoom
     */
    public MagicalExit(Room nextRoom, Room currentRoom,Item password)
    {
        super(nextRoom, currentRoom);
        this.key=password;
    }
    public Item getItem()
    {
        return key;
    }  
    public Room open(Item item)
    {
        if(key.equals(item))
        {
            return super.open();
        }
        else
        {
            return getCurrentRoom();
        }
    }
}

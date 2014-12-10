
/**
 * Write a description of class ExitRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitRoom
{
    private Room nextRoom;
    private Room currentRoom;

    /**
     * Constructor for objects of class ExitRoom
     */
    public ExitRoom(Room nextRoom, Room currentRoom)
    {
        this.nextRoom = nextRoom;
        this.currentRoom = currentRoom;
    }
    
    /**
     * Method open Leads to the next room
     */
    public Room open()
    {
        return nextRoom;
    }
    
    /**
     * Method getCurrentRoom Returns the current room
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
}

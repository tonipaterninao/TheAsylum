/**
 * Write a description of class Players here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character
{
    // instance variables - replace the example below with your own
    private String Name;
    private Room currentRoom;
    private int HealthPoint;

    /**
     * Constructor for objects of class Players
     */
    public Character(Room myRoom, int life)
    {
        // initialise instance variables
        Name="OSEF";
        this.currentRoom=myRoom; 
        HealthPoint = life;
    }


    public void hurt()
    {
        int HealthPointMinus=HealthPoint--;
        if (HealthPointMinus==0)
        {
            System.out.println("You are dead");
        }
        else
        {
            HealthPoint--;
        }
    }
    public int getHealthPoint()
    {
        return HealthPoint;
    }
    
}

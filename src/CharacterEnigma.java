import java.util.Random;
import java.util.ArrayList;

/**
 * Write a description of class Monstre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterEnigma extends Character
{
    // instance variables - replace the example below with your own
    private static Enigma enigme0;
    private static Enigma enigme1;
    private static Enigma enigme2;
    private static Enigma enigme3;
    private static Enigma enigme4;
    private static Enigma enigme5;
    private static Enigma enigme6;
    private static Enigma enigme7;
    private static ArrayList<Enigma> listEnigma;

    /**
     * Constructor for objects of class Monstre
     */
    public CharacterEnigma(Room myRoom, int life)
    {
        // initialise instance variables
        super(myRoom,life);
        Enigma enigme0 = new Enigma("", "1","2","3","145");
        Enigma enigme1 = new Enigma("", "1","2","3","45");
        Enigma enigme2 = new Enigma("", "1","2","3","45");
        Enigma enigme3 = new Enigma("quel est la taille de ", "1","2","3","45");
        Enigma enigme4 = new Enigma("quel est la taille de ", "1","2","3","45");
        Enigma enigme5 = new Enigma("quel est la taille de ", "1","2","3","45");
        Enigma enigme6 = new Enigma("quel est la taille de ", "1","2","3","45");
        Enigma enigme7 = new Enigma("quel est la taille de ", "1","2","3","45");
        listEnigma = new ArrayList<Enigma>();
        listEnigma.add(enigme0);
        listEnigma.add(enigme1);
        listEnigma.add(enigme2);
        listEnigma.add(enigme3);
        listEnigma.add(enigme4);
        listEnigma.add(enigme5);
        listEnigma.add(enigme6);
        listEnigma.add(enigme7);
    }
    
    public Enigma pickEnigma(int choice){
        
        switch (choice)
        {
            //character : mad scientist
            case 0: 
                Random randomGenerator = new Random();
                int randomInt = randomGenerator.nextInt(2);
                return listEnigma.get(randomInt);
                break;
            //character : teletubbies
            case 1:
                return listEnigma.get(3);
                break;
            //character : poney king
            case 2:
                return listEnigma.get(4);
                break;
            //character : evil robot
            case 3:
                return listEnigma.get(5);
                break;
            //character : evil robot(2)
            case 4:
                return listEnigma.get(6);
                break;
            //character : evil robot(3)
            case 5:
                return listEnigma.get(7);
                break;
            default : System.out.println("Error in picking enigma choice");
            break;
                
        }
    }
}

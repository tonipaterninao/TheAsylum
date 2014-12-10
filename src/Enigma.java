
/**
 * Write a description of class Enigma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enigma
{
    // instance variables - replace the example below with your own
    private String Question;
    private String Answer1;
    private String Answer2;
    private String Answer3;
    private String GoodAnswer;

    /**
     * Constructor for objects of class Enigma
     */
    public Enigma(String Question, String Answer1, String Answer2, String Answer3, String GoodAnswer)
    {
        // initialise instance variables
        this.Question = Question;
        this.Answer1 = Answer1;
        this.Answer2 = Answer2;
        this.Answer3 = Answer3;
        this.GoodAnswer = GoodAnswer;
    }

    public void getEnigma()
    {
        System.out.println(Question);
    }
    
    public void getAnswer1()
    {
        System.out.println(Answer1);
    }
    
    public void getAnswer2()
    {
        System.out.println(Answer2);
    }
    
    public void getAnswer3()
    {
        System.out.println(Answer3);
    }
    
    public void getGoodAnswer()
    {
        System.out.println(GoodAnswer);
    }
    
    public boolean answer (String playerchoice){
        if (playerchoice==GoodAnswer){ 
            return true;
        }
        else {return false;}
        
    }
        
   
}

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Players player;    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        player= new Players(currentRoom);
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room garden, hall, refectory, logeGardien, RobertRoom, stairs, kitchen, laboratory;
        Room directorOffice, exit, chambreIRL, tulipefield, rainbowPlace,simbaPlace;
        Room caseDora, robotPlace;
      
        // create the rooms
        
        garden = new Room("in the garden");
        hall = new Room("in the entry hall");
        refectory = new Room("in the refectory");
        logeGardien = new Room("in the gardian lounge");
        RobertRoom = new Room("in the Rooobert's bedroom");
        stairs = new Room("in the stairs");
        kitchen = new Room("in the kitchen");
        laboratory = new Room("in the laboratory");
        directorOffice = new Room("in the director office");  
        exit = new Room("in the garden in front "); 
        chambreIRL = new Room("in your cell"); 
        tulipefield = new Room(" in the tulips field"); 
        rainbowPlace = new Room("in the rainbowplace"); 
        simbaPlace = new Room("in the savane Papy Brossard "); 
        caseDora = new Room("in the Dora's  way"); 
        robotPlace = new Room("in the evil dark  creepy volcano of the dark shadow"); 
        
        
        Item item = new Item("key",1);
        Item never = new Item("never ever EVER",999);
        Item bisous = new Item("Magical kiss",1);
        Item poney = new Item("Magical little poney",1);
        Item rainbow = new Item("Magical rainbow",1);
        
        // initialise room exits
        garden.addexits("north", new ExitRoom(hall,garden));
        hall.addexits("north", new MagicalExit(stairs,hall,item));
        hall.addexits("east", new MagicalExit(kitchen,hall,item));
        hall.addexits("south",new MagicalExit(garden,hall,never));
        hall.addexits("west",new ExitRoom(refectory,hall));
        refectory.addexits("north",new ExitRoom(logeGardien,refectory));
        refectory.addexits("west",new ExitRoom(RobertRoom,refectory));
        refectory.addexits("east",new ExitRoom(hall,refectory));
        logeGardien.addexits("south",new ExitRoom(refectory,logeGardien));
        RobertRoom.addexits("east",new ExitRoom(refectory,RobertRoom));
        stairs.addexits("south",new ExitRoom(hall,stairs));
        kitchen.addexits("north",new ExitRoom(directorOffice,kitchen));
        kitchen.addexits("east",new ExitRoom(laboratory,kitchen));
        kitchen.addexits("west",new ExitRoom(hall,kitchen));
        laboratory.addexits("west",new ExitRoom(kitchen,laboratory));
        directorOffice.addexits("south",new ExitRoom(kitchen,directorOffice));
        tulipefield.addexits("north",new MagicalExit(rainbowPlace,tulipefield,bisous));
        rainbowPlace.addexits("north",new MagicalExit(caseDora,rainbowPlace,poney));
        rainbowPlace.addexits("south",new ExitRoom(tulipefield,rainbowPlace));
        rainbowPlace.addexits("west",new ExitRoom(simbaPlace,rainbowPlace));
        caseDora.addexits("north",new ExitRoom(robotPlace,caseDora));
        caseDora.addexits("south",new ExitRoom(rainbowPlace,caseDora));
        simbaPlace.addexits("east",new ExitRoom(rainbowPlace,simbaPlace));
        robotPlace.addexits("south",new MagicalExit(caseDora,robotPlace,rainbow));
        currentRoom = garden; //Start game in the Hall
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        currentRoom.getExits();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit"))
            wantToQuit = quit(command);

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        Item item = null;
        if (player.getListItem().isEmpty() && (currentRoom.isMagical(direction)))
        {
            nextRoom=currentRoom;
        }
        else if (player.getListItem().isEmpty() && !(currentRoom.isMagical(direction)))
        {
            nextRoom = currentRoom.getNextRoom(direction,item);
        }
       else
       {
            
for (Item i : player.getListItem())
{
    nextRoom = currentRoom.getNextRoom(direction,i);
    if(nextRoom != currentRoom)break;
}
}
        
if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else if(nextRoom == currentRoom)
        {
           System.out.println("The door is locked!");
        }
        
        else
        {
             currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.getDescription());
            currentRoom.getExits(); 
        }
}

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}

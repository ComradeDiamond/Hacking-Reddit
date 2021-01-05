package objects.commands;
import gameNav.Player;
import gameNav.ProgramList;
import objects.programs.*;

/**
 * Open command - opens a program file
 * @author Justin
 * @since 12/15/20
 * @category objects/JustinWare
 */
public class Open extends Commands {

    /**
     * Constructs an open object (or command in this case)
     * @param targetPlayer The main player uniquely created inside the game
     * @throws Exception if open.txt does not exist
     */
    public Open(Player targetPlayer) throws Exception
    {
        super("Open", targetPlayer);
    }

    /**
     * Executes the open command <br />
     * Precondition: text reflects an actual program that exists and is properly punctuated
     * Postcondition: Opens the program and sets it to the player's current open program list
     * @param command The command array
     * @param text The text, that should contain the actual program name
     */
    public void execute(String[] command, String text)
    {
        Programs tempProg = ProgramList.fetch(text);
        if (tempProg == null)
        {
            System.out.println("404 Error: " + text + ".com is not a valid website");
        }
        else
        {
            boolean x = this.getTargetPlayer().addProgram(tempProg);

            if (x)
            {
                System.out.println("Program opened.");
            }
        }
    }
}

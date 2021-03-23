package objects.commands;
import gameNav.Player;

/**
 * Class for the close command - Closes a program file
 * @author Justin
 * @since 12/19/20
 * @category objects/JustinWare
 */
public class Close extends Commands
{
    /**
     * Constructs a close object
     * @param targetPlayer The main player of the game
     * @throws Exception if Close.txt does not exist
     */
    public Close(Player targetPlayer) throws Exception
    {
        super("Close", targetPlayer);
    }
    
    /**
     * Executes the close command <br />
     * Precondition: text reflects an actual program that exists and is properly punctuated
     * Postcondition: Closes the program. Nicely done.
     * @param command The command array
     * @param text The text, that should contain the actual program name
     */
    public void execute(String[] command, String text)
    {
        boolean x = this.getTargetPlayer().removeProgram(text);

        if (x)
        {
            System.out.println("Done!");
        }
        else
        {
            System.out.println("Hmm the program doesn't seem to be open - and you can't close it");
        }
    }
}

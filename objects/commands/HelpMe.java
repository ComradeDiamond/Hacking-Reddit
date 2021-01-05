package objects.commands;
import gameNav.Player;
import gameNav.CommandWord;

/**
 * HelpMe - returns a list of commands
 * @author Justin
 * @since 12/19/20
 * @category objects/JustinWare
 */
public class HelpMe extends Commands
{
    /**
     * Constructs a HelpMe Object (command)
     * @param targetPlayer The current player inside the game, the main player
     * @throws Exception if "HelpMe.txt" does not exist
     */
    public HelpMe(Player targetPlayer) throws Exception
    {
        super("HelpMe", targetPlayer);
    }

    /**
     * Executes the HelpMe command <br />
     * Postcondition: Send out a log that returns the available commands the player can use
     * @param command The command array
     * @param text The text, that should contain the actual program name
     */
    public void execute(String[] command, String text)
    {
        String str = "List of available commands\n-----------------------------\n";

        str += CommandWord.printString();
        str += "\n-----------------------------";

        System.out.println(str);
    }
}

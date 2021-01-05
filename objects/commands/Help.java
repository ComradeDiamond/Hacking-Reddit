package objects.commands;
import gameNav.Player;
import gameNav.CommandWord;
import gameNav.ProgramList;
import objects.programs.Programs;
import objects.items.Items;

/**
 * Help command - reveals description of anything
 * @author Justin
 * @since 12/15/20
 * @category objects/JustinWare
*/
public class Help extends Commands {

    /**
     * Constructs an help object (or command in this case)
     * @param targetPlayer The main unique created inside the game
     * @throws Exception if Help.txt does not exist
     */
    public Help(Player targetPlayer) throws Exception
    {
        super("Help", targetPlayer);
    }

    /**
     * Runs the command
     * Precondition: The item you are asking for help exists either as a command, program,
        or is in your inventory. The requested program is enabled.
     * Postcondition: Prints the log of a JustinWare
     * @param command The array that contains the command lines returned by Parser
     * @param text The entire text the user put inside the parser
     */
    public void execute(String[] command, String text)
    {
        Commands storedComm = CommandWord.fetch(text);
       
        if (storedComm == null)
        {
            Programs storedProg = ProgramList.fetch(text);
            if (storedProg == null)
            {
                Items storedItem = this.getTargetPlayer().fetchItem(text);
                if (storedItem == null)
                {
                    System.out.println("We can't find that JustinWare..." +
                    "Or you don't have it in your inventory");
                }
                else
                {
                    System.out.println(storedItem.getLog());
                }
            }
            else
            {
                System.out.println(storedProg.getLog());
            }
        }
        else
        {
            System.out.println(storedComm.getLog());
        }
    }
}

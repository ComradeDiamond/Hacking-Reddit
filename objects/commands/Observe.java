package objects.commands;
import gameNav.Player;
import objects.programs.*;

/**
 * Observe command - allows you to make observations and interact with programs.
 * A very useful command if you want to progress in the game.
 * @author Justin
 * @since 12/28/20
 * @category objects/JustinWare
 */
public class Observe extends Commands
{
    /**
     * Constructs an observe object (or command in this case)
     * @param targetPlayer The main player inside the game
     * @throws Exception if Observe.txt does not exist
     */
    public Observe(Player targetPlayer) throws Exception
    {
        super("Observe", targetPlayer);
    }

    /**
     * Executes the observe command <br />
     * Precondition: The player has a program open and set to the current program
     * Postcondition: Executes the observe method of the program the player has open
     * @param command The command array
     * @param text The text, but it's relatively useless and just here bc Java dumb
     */
    public void execute(String[] command, String text)
    {
        Programs currentProgram = this.getTargetPlayer().getCurrentProgram();

        if (currentProgram == null)
        {
            System.out.println("You don't have a program open ._.");
        }
        else
        {
            currentProgram.observe();
        }
    }
}

package objects.commands;
import gameNav.Player;
import objects.programs.*;

/**
 * The main class for the swap command! <br />
 * The command toggles a program in your list of open programs and sets it as your active program
 * @author Justin
 * @since 12/19/20
 * @category objects/JustinWare
 */
public class Swap extends Commands
{
    /**
     * Creates an instance of the swap command
     * @param targetPlayer The main player inside the game
     * @throws Exception if Swap.txt does not exist
     */
    public Swap(Player targetPlayer) throws Exception
    {
        super("Swap", targetPlayer);
    }

    /**
     * Executes the swap command <br />
     * Precondition: text reflects an actual program that exists and is properly punctuated
     * Postcondition: Fetches a program from player's programList and sets it as currentProgram
     * @param command The command array
     * @param text The text, that should contain the actual program name
     */
    public void execute(String[] command, String text)
    {
        Programs targetProgram = this.getTargetPlayer().fetchProgram(text);

        if (targetProgram == null)
        {
            System.out.println("That program is not opened yet, or you need to check punctuation.");
        }
        else
        {
            this.getTargetPlayer().setCurrentProgram(targetProgram);
            System.out.println(targetProgram.getName() + " is set as current program");
        }
    }
}

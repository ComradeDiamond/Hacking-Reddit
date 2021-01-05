package objects.programs;
import gameNav.Player;

/**
 * StackOverflow - the go to hub for Q&A Inside the game
 * You'll find better descriptions than these javadocs inside textLore
 * Or just play the game lmao
 * @author Justin
 * @since 12/15/20
 * @category objects/JustinWare
 */
public class StackOverflow extends Programs 
{
    /**
     * Constructs a stack overflow program
     * @param targetPlayer The main punique player initialized in the game
     * @throws Exception if Stack Overflow.txt does not exist
     */
    public StackOverflow(Player targetPlayer) throws Exception
    {
        super("Stack Overflow", targetPlayer);
    }
}

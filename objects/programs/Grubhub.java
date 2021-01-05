package objects.programs;
import gameNav.Player;

/**
 * Grubhub - the place where you order food
 * @author Justin 
 * @since 12/23/20
 * @category objects/JustinWare
 */
public class Grubhub extends Programs
{
    /**
     * Creates a grubhub object.
     * @param targetPlayer The main player inside the game that grubhub will enact things on
     * @throws Exception if Grubhub.txt is not in c://textLore/programs
     */
    public Grubhub(Player targetPlayer) throws Exception
    {
        super("Grubhub", targetPlayer);
    }
}

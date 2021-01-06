package objects.items;
import gameNav.Player;

/**
 * Cleansing Foam - Wipes away your suspicious history
 * @author Justin
 * @since 12/15/20
 * @category object/JustinWare
 */
public class CleansingFoam extends Items
{
    /**
     * Constructs a cleansing foam
     * @param targetPlayer The player initialized in the main game
     * @throws Exception if CleansingFoam.txt does not exist
     */
    public CleansingFoam(Player targetPlayer) throws Exception
    {
        super("Cleansing Foam", targetPlayer, true, 80);
    }
}

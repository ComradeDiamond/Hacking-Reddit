package objects.items;

import gameNav.Player;

/**
 * The first observable note!
 * You'll get this by realizing you need to fetch stuff from r/Christmas
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class ObservableNote3 extends Items
{
    /**
     * Constructs a ObservableNote3 object
     * @param targetPlayer The main player inside the game
     * @throws Exception if ObservableNote3.txt does not exist
     */
    public ObservableNote3(Player targetPlayer) throws Exception
    {
        super("Observable Note 3", targetPlayer);
    }
}

package objects.items;

import gameNav.Player;

/**
 * The first observable note!
 * You'll get this by realizing the classNames are all " Post"
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class ObservableNote1 extends Items
{
    /**
     * Constructs a ObservableNote1 object
     * @param targetPlayer The main player inside the game
     * @throws Exception if ObservableNote1.txt does not exist
     */
    public ObservableNote1(Player targetPlayer) throws Exception
    {
        super("Observable Note 1", targetPlayer);
    }
}

package objects.items;

import gameNav.Player;

/**
 * The second observable note!
 * You'll get this by realizing all the image tags have img
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class ObservableNote2 extends Items
{
    /**
     * Constructs a ObservableNote2 object
     * @param targetPlayer The main player inside the game
     * @throws Exception if ObservableNote2.txt does not exist
     */
    public ObservableNote2(Player targetPlayer) throws Exception
    {
        super("Observable Note 2", targetPlayer);
    }
}

package objects.items;

import gameNav.Player;

/**
 * Folwell Fix Code that allows Jgrasp to move past the brute forcing errors
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class FolwellFix extends Items
{
    /**
     * Constructs a FolwellFix object
     * @param targetPlayer The main player inside the game
     * @throws Exception if FolwellFix.txt does not exist
     */
    public FolwellFix(Player targetPlayer) throws Exception
    {
        super("FollWell Fix", targetPlayer);
    }
}

package objects.programs;

import gameNav.Player;

/**
 * Amazon Web Service - you must have it open in order to host your bot
 * @author Justin
 * @since 12/24/20
 * @category objects/JustinWare
 */
public class AWS extends Programs
{
    /**
     * Constructs an AWS object
     * @param targetPlayer The main player inside the game
     * @throws Exception if AWS.txt does not exist
     */
    public AWS(Player targetPlayer) throws Exception
    {
        super("AWS", targetPlayer);
    }
}

package objects.programs;

import gameNav.Player;

/**
 * The go to hub for everything dark net.
 * The program tells you how to achieve the illegal ending.
 * @author Justin
 * @category objects/JustinWare
 * @since 12/24/20
 */
public class BTHSDataArchive extends Programs
{
    /**
     * Constructs a BTHS Data Archive object.
     * Postcondition: A new BTHS Data Archive object is created and NOT ENABLED
     * @param targetPlayer The main player inside the game you're playing
     * @throws Exception if BTHSDataArchive.txt does not exist
     */
    public BTHSDataArchive(Player targetPlayer) throws Exception
    {
        super("BTHS Data Archive", targetPlayer, false);
    }   
}

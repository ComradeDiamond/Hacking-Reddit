package objects.items;

import gameNav.Player;

/**
 * JSDOM item.
 * This is a node.js library that lets you do illegal activities with websites.
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class JSDOM extends Items
{
    /**
     * Constructs a JSDOM object
     * @param targetPlayer The main player inside the game
     * @throws Exception if JSDOM.txt does not exist
     */
    public JSDOM(Player targetPlayer) throws Exception
    {
        super("JSDOM", targetPlayer);
    }
}

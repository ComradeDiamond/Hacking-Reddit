package objects.items;

import gameNav.Player;

/**
 * Represents an ikea table that the user will use to craft a rainbow table
 * @author Justin
 * @since 1/9/21
 * @category objects/JustinWare
 */
public class IKEATable extends Items
{
    /**
     * Constructs an unconsumable ikea table
     * @param targetPlayer The main player inside the game
     * @throws Exception if IKEATable.txt does not exist
     */
    public IKEATable(Player targetPlayer) throws Exception
    {
        super("IKEA Table", targetPlayer, false);
    }
}

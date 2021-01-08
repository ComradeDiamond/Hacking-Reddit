package objects.items;

import gameNav.Player;

/**
 * DevTool item.
 * This is used to inspect element and traffic on r/christmas.
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class DevTool extends Items
{
    /**
     * Constructs a DevTool object
     * @param targetPlayer The main player inside the game. Should we copy and paste this .-.
     * @throws Exception if DeveloperTools.txt does not exist
     */
    public DevTool(Player targetPlayer) throws Exception
    {
        super("Developer Tools", targetPlayer);
    }
}

package objects.items;

import gameNav.Player;

/**
 * The reddit API key! It's used on jrasp so you're finally able to access the reddit API with srs bot!
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class APIKey extends Items
{
    /**
     * Constructs an APIKey object
     * @param targetPlayer The main player inside the game
     * @throws Exception if APIKey.txt does not exist
     */
    public APIKey(Player targetPlayer) throws Exception
    {
        super("API Key", targetPlayer);
    }
}

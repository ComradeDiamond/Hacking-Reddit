package objects.items;

import gameNav.Player;

/**
 * Hey, hey, there's a reason why it's called rainbow
 * @author Justin
 * @since 1/10/21
 * @category objects/JustinWare
 */
public class RainbowDash extends Items
{
    /**
     * Constructs a rainbow dash object
     * @param targetPlayer The main player inside the game
     * @throws Exception if RainbowDash.txt does not exist
     */
    public RainbowDash(Player targetPlayer) throws Exception
    {
        super("Rainbow Dash", targetPlayer, false);
    }
}

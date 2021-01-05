package objects.programs;
import gameNav.Player;

/**
 * The dark web auction house where you buy illegal stuff that's more illegal than what I'm doing rn.
 * Also the only place where you can say "would you like to buy my cocaine" without looking sus.
 * Sorry FBI agent looking at this
 * @author Justin
 * @category objects/JustinWare
 * @since 12/24/20
 */
public class SilkRoad extends Programs
{
    /**
     * Constructs a silk road program according to instructions provided by superclass.
     * Postcondition: Creates a silk road object that is NOT ENABLED
     * @param targetPlayer The main player inside the game
     * @throws Exception if SilkRoad.txt does not exist
     */
    public SilkRoad(Player targetPlayer) throws Exception
    {
        super("Silk Road", targetPlayer, false);
    }
}

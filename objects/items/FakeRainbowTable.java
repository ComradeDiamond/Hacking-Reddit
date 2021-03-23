package objects.items;
import gameNav.Player;

/**
 * Fake rainbow table - used in reddit to unlock the dark web.
 * @author Justin
 * @since 12/29/20
 * @category objects/JustinWare
 */
public class FakeRainbowTable extends Items
{
    /**
     * Constructs a fake rainbow table object.
     * Postcondition: Sets the rainbow table as unconsumable
     * @param targetPlayer The main player inside the game you're playing as
     * @throws Exception if RainbowTable.txt does not exist
     */
    public FakeRainbowTable(Player targetPlayer) throws Exception
    {
        //The name is a bit weird, but that's because the user shouldn't know its fake
        super("Rainbow Table", targetPlayer, false);
    }
}

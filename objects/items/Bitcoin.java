package objects.items;
import gameNav.Player;

/**
 * Bitcoin class - an item used to disguise transactions in the dark web.
 * This will severely mitigate the risk of being discovered by the FBI.
 * @author Justin
 * @since 12/30/20
 * @category objects/JustinWare
 */
public class Bitcoin extends Items
{
    /**
     * Constructs a bitcoin object
     * @param targetPlayer The main player inside the game
     * @throws Exception if Bitcoin.txt does not exist
     */
    public Bitcoin(Player targetPlayer) throws Exception
    {
        super("Bitcoin", targetPlayer);
    }

    public void use()
    {
        this.getTargetPlayer().setBitcoins(true);
        System.out.println("You registered for the bitcoin wallet. Looks like your money does not exist anymore!");
    }
}

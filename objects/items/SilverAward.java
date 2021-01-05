package objects.items;
import gameNav.Player;

/**
 * SilverAward class - represents a reddit silveraward which gives you coins
 * @author Justin
 * @since 12/29/20
 * @category objects/JustinWare
 */
public class SilverAward extends Items
{
    /**
     * Creates an silver award object
     * @param targetPlayer The main player inside gameNav.game
     * @throws Exception if SilverAward.txt does not exist
     */
    public SilverAward(Player targetPlayer) throws Exception
    {
        super("Silver Award", targetPlayer);
    }

    /**
     * Gives the target player $10
     */
    public void use()
    {
        this.getTargetPlayer().moneyChange(10);
        System.out.println("You redeemed your silver award! You recieve 10 coins.");
    }
}

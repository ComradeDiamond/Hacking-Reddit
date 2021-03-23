package objects.items;
import gameNav.Player;

/**
 * Reddit gold award - a gold award that gives you coins
 * @author Justin
 * @since 12/29/20
 * @category objects/JustinWare
 */
public class GoldAward extends Items
{
    /**
     * Creates an GoldAward object
     * @param targetPlayer The main player inside gameNav.game
     * @throws Exception if GoldAward.txt does not exist
     */
    public GoldAward(Player targetPlayer) throws Exception
    {
        super("Gold Award", targetPlayer);
    }

    /**
     * Gives the target player $50
     */
    public void use()
    {
        this.getTargetPlayer().moneyChange(50);
        System.out.println("You redeemed your reddit gold award! Not only do you get to spend a" +
        " week in r/lounge, you also get a whopping 50 gold coins!");
    }
}

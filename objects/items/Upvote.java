package objects.items;
import gameNav.Player;

/**
 * Upvote class - represents a reddit upvote. Use it to get some coins!
 * @author Justin
 * @since 12/29/20
 * @category objects/JustinWare
 */
public class Upvote extends Items
{
    /**
     * Creates an upvote object
     * @param targetPlayer The main player inside gameNav.game
     * @throws Exception if Upvote.txt does not exist
     */
    public Upvote(Player targetPlayer) throws Exception
    {
        super("Upvote", targetPlayer);
    }

    /**
     * Gives the target player $2
     */
    public void use()
    {
        this.getTargetPlayer().moneyChange(2);
        System.out.println("You look at your upvote. It comes with 2 coins.");
    }
}

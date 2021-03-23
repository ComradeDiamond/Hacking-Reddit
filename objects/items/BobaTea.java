package objects.items;

import gameNav.Player;

/**
 * A boba tea item that restores some energy.
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class BobaTea extends Items
{
    /**
     * Constructs and emergency unlock object
     * @param targetPlayer The main player inside the game
     * @throws Exception if BobaTea.txt does not exist
     */
    public BobaTea(Player targetPlayer) throws Exception
    {
        super("Boba Tea", targetPlayer);
    }

    /**
     * Uses the boba tea item.
     * Postcondition: The user gets 10 energy.
     */
    public void use()
    {
        System.out.println("You drank the coconut flavored Thai Boba Tea.");
        this.getTargetPlayer().energyChange(10);
    }
}

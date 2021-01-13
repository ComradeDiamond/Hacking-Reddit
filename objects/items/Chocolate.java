package objects.items;

import gameNav.Player;

/**
 * A bar of chocolate.
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class Chocolate extends Items
{
    /**
     * Constructs a chocolate object
     * @param targetPlayer The main player inside the game
     * @throws Exception if Chocolate.txt does not exist
     */
    public Chocolate(Player targetPlayer) throws Exception
    {
        super("Chocolate", targetPlayer, true, 10);
    }

    /**
     * Uses the chocolate. 
     * Postcondition: Gain 5 energy
     */
    public void use()
    {
        this.getTargetPlayer().energyChange(5);
        System.out.println("You ate the yummy chocolate.");
    }
}

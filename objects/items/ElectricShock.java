package objects.items;

import gameNav.Player;

/**
 * An electric shock that shocks some electricity into your laptop.
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class ElectricShock extends Items
{
    /**
     * Constructs an electric shock object
     * @param targetPlayer The main player inside the game
     * @throws Exception if ElectricShock.txt does not exist
     */
    public ElectricShock(Player targetPlayer) throws Exception
    {
        super("Emergency Unlock", targetPlayer);
    }

    /**
     * Uses the electric shock.
     * Postcondition: Gives your laptop 10 batteries.
     */
    public void use()
    {
        System.out.println("You shocked your laptop with electricity. It surprisingly works!");
        this.getTargetPlayer().batteryChange(10);
    }
}

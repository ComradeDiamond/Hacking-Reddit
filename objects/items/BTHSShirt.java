package objects.items;

import gameNav.Player;

/**
 * A BTHS Shirt that will lower your sus
 * @author Justin
 * @since 1/10/21
 * @category objects/JustinWare
 */
public class BTHSShirt extends Items
{
    /**
     * Constructs a BTHS Shirt object
     * @param targetPlayer The main player inside the game
     * @throws Exception if BTHSShirt.txt does not exist
     */
    public BTHSShirt(Player targetPlayer) throws Exception
    {
        super("BTHS Shirt", targetPlayer);
    }

    /**
     * Uses the shirt and lowers risk chance.
     * Postcondition: Lowers the risk chance by 5. Yes risk chance can go below 0 because that's how it works for China AI
     */
    public void use()
    {
        System.out.println("You put on a shirt and looked like an innocent freshie.");
        System.out.println("Now go down the up staircase");
        this.getTargetPlayer().changeRiskChance(-5);
    }
}

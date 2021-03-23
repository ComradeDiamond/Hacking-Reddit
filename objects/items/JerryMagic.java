package objects.items;

import gameNav.Player;

/**
 * A meme item that sabatoges the player's game
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class JerryMagic extends Items
{
    /**
     * Constructs a Jerry Magic object
     * @param targetPlayer The main player inside the game
     * @throws Exception if JerryMagic.txt does not exist
     */
    public JerryMagic(Player targetPlayer) throws Exception
    {
        super("Jerry Magic", targetPlayer);
    }

    /**
     * Uses the jerry magic item.
     * Postcondition: Decreases your battery by 100.
     */
    public void use()
    {
        System.out.println("Jerry. Jerry Jerry use Jerry?");

        if (this.getScanner().nextLine().equalsIgnoreCase("yes"))
        {
            System.out.println("Jerry. Jerry 0 battery Jerry.");
            this.getTargetPlayer().batteryChange(-100);
        }
        else
        {
            System.out.println("Jerry.");
        }
    }
}

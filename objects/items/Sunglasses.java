package objects.items;

import gameNav.Player;

/**
 * CIA sunglasses allows you to see all
 * @author Justin
 * @since 1/9/21
 * @category objects/JustinWare
 */
public class Sunglasses extends Items
{
    /**
     * Constructs a sunglasses object.
     * Postcondition: Sunglasses is set to unconsumable
     * @param targetPlayer The main...player...inside...the game
     * @throws Exception if Sunglasses.txt does not exist
     */
    public Sunglasses(Player targetPlayer) throws Exception
    {
        super("Sunglasses", targetPlayer, false);
    }

    /**
     * Uses the sunglasses.
     * Postcondition: Triggeres the drip() of the current program
     */
    public void use()
    {
        System.out.println("You put your sunglasses on!");
        this.getTargetPlayer().getCurrentProgram().drip();
    }
}

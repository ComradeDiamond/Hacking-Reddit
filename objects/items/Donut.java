package objects.items;
import gameNav.Player;

/**
 * Donut class
 * Restores energy
 * @author Justin
 * @since 12/15/20
 * @category objects/JustinWare
 */
public class Donut extends Items
{
    /**
     * Constructs a donut object
     * @param targetPlayer The player in the main game
     * @throws Exception if Donut.txt file is somehow uninitialized
     */
    public Donut(Player targetPlayer) throws Exception
    {
        super("Donut", targetPlayer);
    }

    /**
     * Uses the donut object.
     * Postcondition: The targetPlayer's energy increases by 10.
     */
    public void use()
    {
        this.getTargetPlayer().energyChange(10);
        System.out.println("You ate the crunchy, sweet, chewy donut! Energy restored!");
    }
}

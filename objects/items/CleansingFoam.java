package objects.items;
import gameNav.Player;

/**
 * Cleansing Foam - Wipes away your suspicious history
 * @author Justin
 * @since 12/15/20
 * @category object/JustinWare
 */
public class CleansingFoam extends Items
{
    /**
     * Constructs a cleansing foam
     * @param targetPlayer The player initialized in the main game
     * @throws Exception if CleansingFoam.txt does not exist
     */
    public CleansingFoam(Player targetPlayer) throws Exception
    {
        super("Cleansing Foam", targetPlayer, true, 80);
    }

    /**
     * Cleansing foam wipes away a random amount of your suspicion.
     * Postcondition: Wipes away a random suspicion amount from 0 to 1 less than your max sus
     */
    public void use()
    {
        int susRate = this.getTargetPlayer().getSus();
        int susSubtract = (int)(Math.random() * susRate);

        this.getTargetPlayer().changeSus(-1 * susSubtract);

        System.out.println("You sprayed the cleansing foam all around you.");
        System.out.println("Your criminal traces have been cleared!");
        System.out.println("FBI databased have also been cleared!");
        System.out.println("Sus decreased!!!!");
    }
}

package objects.items;

import gameNav.Player;

/**
 * A CD Item that allows the player to copyright strike an item in your inventory.
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class PigStep extends Items
{
    /**
     * Constructs an PigStep object.
     * @param targetPlayer The main player inside the game
     * @throws Exception if PigStep.txt does not exist
     */
    public PigStep(Player targetPlayer) throws Exception
    {
        super("PigStep", targetPlayer, true, 15);
    }

    /**
     * Uses the pigstep item
     * Postcondition: Remove an item of choice in your inventory.
     */
    public void use()
    {
        System.out.println("What item would you like to copyright strike?");
        String item = this.getScanner().nextLine();

        boolean removed = this.getTargetPlayer().removeInvItem(item);

        if (removed)
        {
            System.out.println(item + " is now copyright striked!");
            System.out.println("Due to a Unit 5 Standard on intellectual property, we must remove it from your inventory.");
            System.out.println("hmmm... was this what you wanted perhaps?");
        }
        else
        {
            System.out.println("That item does not exist.");
            System.out.println("Now you wasted a perfectly good CD.");
        }
    }
}

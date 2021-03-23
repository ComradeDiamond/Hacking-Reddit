package objects.items;

import gameNav.Player;

/**
 * An energy drink that gives you batteries.
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class Gatorade extends Items
{
    /**
     * Constructs a gatorade object
     * @param targetPlayer The main player inside the game
     * @throws Exception if Gatorade.txt does not exist
     */
    public Gatorade(Player targetPlayer) throws Exception
    {
        super("Gatorade", targetPlayer);
    }

    /**
     * Uses the gatorade object.
     * Postcondition: The player gets 10 battery.
     */
    public void use()
    {
        System.out.println("You spill some gatorade on your computer.");
        System.out.println("Now it's the one getting energized instead of you!");
        this.getTargetPlayer().batteryChange(10);
    }
}

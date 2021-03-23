package objects.items;

import gameNav.Player;

/**
 * Constructs a dream water bottle. This allows you to get some energy.
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class DreamWaterBottle extends Items
{
    /**
     * Constructs a dream water bottle
     * @param targetPlayer The main player inside the game
     * @throws Exception if DreamWaterBottle.txt does not exist
     */
    public DreamWaterBottle(Player targetPlayer) throws Exception
    {
        super("Dream Water Bottle", targetPlayer);
    }

    /**
     * Uses Dream's Water bottle.
     * Postcondition: Changes your energy by 5
     */
    public void use()
    {
        this.getTargetPlayer().energyChange(5);
        System.out.println("You swagily drank Dream's water bottle!");
        System.out.println("You felt much better uwu");
    }
}

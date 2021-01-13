package objects.items;

import gameNav.Player;

/**
 * An SGO Sticker that reduces risk.
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class SGOSticker extends Items
{
    /**
     * Constructs a SGO Sticker object
     * @param targetPlayer The main player inside the game
     * @throws Exception if SGOSticker.txt does not exist
     */
    public SGOSticker(Player targetPlayer) throws Exception
    {
        super("SGO Sticker", targetPlayer);
    }

    /**
     * Uses the SGO Sticker item.
     * Postcondition: Decreases risk by 5
     */
    public void use()
    {
        System.out.println("You put on a SGO Sticker. You now look even more like a freshie");
        this.getTargetPlayer().changeRiskChance(-5);
    }
}

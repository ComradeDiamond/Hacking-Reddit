package objects.items;

import gameNav.Player;

/**
 * Potion of Swiftness. Totally wasn't inspired by Minecraft.
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class POS extends Items
{
    /**
     * Constructs and emergency unlock object
     * @param targetPlayer The main player inside the game
     * @throws Exception if POS.txt does not exist
     */
    public POS(Player targetPlayer) throws Exception
    {
        super("POS", targetPlayer);
    }

    /**
     * Uses the POS item. PotionOfSwiftness.java is too long for VSC to handle smh.
     * Postcondition: Drastically increases your risk, but also increases batteries by 30.
     */
    public void use()
    {
        this.getTargetPlayer().changeRiskChance(20);
        this.getTargetPlayer().batteryChange(30);
        System.out.println("You risk-ily drank the potion of swiftness.");
        System.out.println("You felt like you're now able to do things alot faster.");
        System.out.println("You also felt a few people eyeballing you.");
    }
}

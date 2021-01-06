package objects.programs;

import gameNav.Player;

/**
 * Minecraft is a game where you sit there and observe stuff going on and hope not to get blown up.
 * You can also make some gold in this game.
 * @author Justin
 * @since 12/24/20
 * @category objects/JustinWare
 */
public class Minecraft extends Programs
{
    /**
     * A string of stuff that happens in Minecraft
     */
    private static String[] mcStuff = {
        "A creeper walks around the corner",
        "A zombie burns in the sun",
        "A chicken spies",
        "A chicken does more spying",
        "A chicken looks at you suspiciously",
        "A cow moos",
        "A villager farms some wheat",
        "A seed is on the ground",
        "A fox sleeps under a tree",
        "A creeper dances to the tune of Creeper Aw Man"
    };

    /**
     * Records whether the player has unlocked the rainbow table via drip
     */
    private boolean rainbowUnlock;

    /**
     * Constructs a minecraft program object according to the superclass guidelines.
     * @param targetPlayer The main player inside gameNav.Game.java
     * @throws Exception if Minecraft.txt does not exist
     */
    public Minecraft(Player targetPlayer) throws Exception
    {
        super("Minecraft", targetPlayer);
        this.rainbowUnlock = false;
    }

    /**
     * Observe! This command will have a chance for you to get a coin.
     * Postcondition: Player's inventory gets a random amount of coins from 0-5
     */
    public void observe()
    {
        // 20%
        if ((int)(Math.random() * 5) == 1)
        {
            int rand = (int)(Math.random() * 5) + 1;
            String str = "A wandering trader comes and wants to do a buisness deal. You get " + rand + " emeralds";
            System.out.println(str);
        }
        else
        {
            System.out.println(Minecraft.mcStuff[(int) (Math.random() * Minecraft.mcStuff.length)]);
        }
    }

    /**
     * If the user has the materials for a rainbow table, you are able to craft the rainbow table here
     */
    public void upload()
    {
        if (this.rainbowUnlock)
        {
            //If have all 3 items, unlock rainbow table
        }
        else
        {
            System.out.println("Hmm seems like there's nothing to craft here.");
            System.out.println("But hey, would you like some BTD6 drip?");
        }
    }

    /**
     * If you use drip in Minecraft, you'll get the crafting recipe of a rainbow table :P.
     * Postcondition: this.rainbowUnlock = true;
     */
    public void drip()
    {
        this.rainbowUnlock = true;
        System.out.println("Through some shady spying networks... you found a rainbow table crafting recipe book");
    }
}

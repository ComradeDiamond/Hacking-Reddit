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
     * Constructs a minecraft program object according to the superclass guidelines.
     * @param targetPlayer The main player inside gameNav.Game.java
     * @throws Exception if Minecraft.txt does not exist
     */
    public Minecraft(Player targetPlayer) throws Exception
    {
        super("Minecraft", targetPlayer);
    }
}

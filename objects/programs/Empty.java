package objects.programs;

import gameNav.Player;

/**
 * Represents an empty program.
 * This is only here to prevent nullpointerexceptions when player calls methods on a null current program
 * @author Justin
 * @since 1/11/21
 * @category objects/JustinWare
 */
public class Empty extends Programs
{
    /**
     * Constructs an empty object.
     * @param targetPlayer The main player inside the game
     * @throws Exception if Empty.txt does not exist
     */
    public Empty(Player targetPlayer) throws Exception
    {
        super("Empty", targetPlayer);
    }

    /**
     * Reports that this is an empty program
     */
    public void observe()
    {
        System.out.println("hey... no programs are open");
    }

    /**
     * Reports this is an empty program
     */
    public void upload()
    {
        System.out.println("hey... no programs are open");
    }
}

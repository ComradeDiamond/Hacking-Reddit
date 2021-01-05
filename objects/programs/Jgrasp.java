package objects.programs;

import gameNav.Player;

/**
 * JGrap is the programming platform you'll use to code stuff into srs bot
 * @author Justin
 * @since 12/24/20
 * @category objects/JustinWare
 */
public class Jgrasp extends Programs
{
    /**
     * Constructs a Jgrasp object
     * @param targetPlayer The main player inside the game
     * @throws Exception if Jgrasp.txt does not exist
     */
    public Jgrasp(Player targetPlayer) throws Exception
    {
        super("Jgrasp", targetPlayer);
    }
}

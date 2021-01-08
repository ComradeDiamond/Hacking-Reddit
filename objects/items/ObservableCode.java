package objects.items;

import gameNav.Player;

/**
 * The observable code :P
 * This code contains knowledge that can be used inside jgrasp to obtain the website metadata!
 * Srs bot can convienently run this to obtain data
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class ObservableCode extends Items
{
    /**
     * Constructs a ObservableCode object
     * @param targetPlayer The main player inside the game
     * @throws Exception if ObservableCode.txt does not exist
     */
    public ObservableCode(Player targetPlayer) throws Exception
    {
        super("Observable Code", targetPlayer);
    }
}

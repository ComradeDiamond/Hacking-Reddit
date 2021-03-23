package objects.items;

import gameNav.Player;
import gameNav.ProgramList;

/**
 * BTHS Data ArchiveS is basically the item version of the BTHS Data Archive.
 * Not to be confused with the BTHS Data Archive java file which is the program.
 * @author Justin
 * @since 1/9/21
 * @category objects/JustinWare
 * @see objects.programs.BTHSDataArchive.java
 */
public class BTHSDataArchives extends Items
{
    /**
     * Constructs a BTHS Data Archives object
     * No they don't have the same name, this one is plural >:(
     * @param targetPlayer The main player inside the game
     * @throws Exception if BTHSDataArchives.txt does not exist
     */
    public BTHSDataArchives(Player targetPlayer) throws Exception
    {
        super("BTHS Data Archives", targetPlayer, true, 80);
    }

    /**
     * Enables the BTHS Data Archive.
     * Postcondition: Sets BTHS Data Archive to enabled
     */
    public void use()
    {
        System.out.println("You downloaded the data archive.");
        System.out.println("IDK this is kinda sus");
        ProgramList.fetchAuthority("BTHS Data Archive").setEnabled(true);
    }
}

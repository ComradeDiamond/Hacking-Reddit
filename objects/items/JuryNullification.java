package objects.items;

import gameNav.Player;
import gameNav.ProgramList;
import objects.programs.Discord;

/**
 * A very powerful item. Use this to get all your lawsuits yeeted out the window.
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class JuryNullification extends Items
{
    /**
     * Constructs a jury nullification object
     * @param targetPlayer The main player inside the game
     * @throws Exception if JuryNullification.txt does not exist
     */
    public JuryNullification(Player targetPlayer) throws Exception
    {
        super("Jury Nullification", targetPlayer);
    }

    /**
     * Uses the jury nullification item.
     * Postcondition: Sets your lawsuits to a blank array list
     */
    public void use()
    {
        System.out.println("You bribe the jury that you're just an innocent kid doing an APCSA project.");
        System.out.println("With that $200 check in your hand, it works.");
        System.out.println("The jury decides to drop all lawsuits against you on live TV!");

        ((Discord)ProgramList.fetchAuthority("Discord")).removeAllLawsuits();
    }
}

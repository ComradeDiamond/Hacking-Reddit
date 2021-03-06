package objects.items;

import gameNav.Player;
import objects.programs.Jgrasp;

/**
 * Folwell Fix Code that allows Jgrasp to move past the brute forcing errors
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class FolwellFix extends Items
{
    /**
     * Constructs a FolwellFix object
     * @param targetPlayer The main player inside the game
     * @throws Exception if FolwellFix.txt does not exist
     */
    public FolwellFix(Player targetPlayer) throws Exception
    {
        super("FolWell Fix", targetPlayer, false);
    }

    /**
     * Checks off the hacker program step 3 in jgrasp - to copy and paste code
     * Precondition: The current program is jgrasp
     * Postcondition: Checks off step 3 in hacker ending jgrasp
     * Postcondition: Jgrasp does a jgrasp. Nothing new I swear ;-;
     * Postcondition: If the program is jgrasp, this is set to consumable
     * Postcondition: Increases risk and sus by 5 and 10 respectively
     */
    public void use()
    {
        if (this.validJgrasp())
        {
            Jgrasp currProg = ((Jgrasp)this.getTargetPlayer().getCurrentProgram());

            System.out.println("You copied and pasted Folwell's code. It seems to work!");

            currProg.hackerCheckoff(2);
            currProg.setBuggy(true);
            this.setConsumable(true);

            this.getTargetPlayer().changeRiskChance(10);
            this.getTargetPlayer().changeSus(5);

            System.out.println("Wait nvm... i lied");
        }
    }
}

package objects.items;

import gameNav.Player;
import objects.programs.Programs;
import objects.programs.Jgrasp;

/**
 * An old reddit link, this is obtained by uploading on reddit after normal phase 2
 * @author Justin
 * @since 1/8/21
 * @category objects/JustinWare
 */
public class OldRedditLink extends Items
{
    /**
     * Constructs an old reddit link that's not consumable
     * @param targetPlayer The main player inside the game
     * @throws Exception if OldRedditLink.txt does not exist
     */
    public OldRedditLink(Player targetPlayer) throws Exception
    {
        super("Old Reddit Link", targetPlayer, false);
    }

    /**
     * Completes the final tier of jgrasp normal ending!
     * Precondition: The current program is jgrasp and jgrasp is not buggy
     * Postcondition: Checks off index 2 of jgrasp normal ending
     * Postcondition: Changes risk by 10.
     * Postcondition: Jgrasp throws a bug
     * Postcondition: Sets this item to consumable
     */
    public void use()
    {
        if (this.validJgrasp())
        {
            Jgrasp currProg = (Jgrasp)this.getTargetPlayer().getCurrentProgram();

            System.out.println("Looking at the code, you spotted the reddit link.");
            System.out.println("Seems like the lazy loader is giving the bot a hard time.");
            System.out.println("So you started to roll back. Roll back the time.");
            System.out.println("And the old reddit link is in effect.");

            currProg.normalCheckoff(2);
            currProg.setBuggy(true);
            this.setConsumable(true);
            this.getTargetPlayer().changeRiskChance(10);
        }
    }
}

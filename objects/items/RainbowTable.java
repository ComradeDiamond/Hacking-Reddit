package objects.items;

import objects.programs.Jgrasp;
//import objects.programs.Programs;
import gameNav.Player;

/**
 * The real rainbow table. This is used in jgrasp to load up the hashing algorithms.
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class RainbowTable extends Items
{
    /**
     * Constructor for a rainbow table... hey, this one is real! I swear! 😤
     * Postcondition: The rainbow table is set to unconsumable
     * @param targetPlayer The main player inside the game
     * @throws Exception if RealRainbowTable.txt does not exist
     */
    public RainbowTable(Player targetPlayer) throws Exception
    {
        super("Real Rainbow Table", targetPlayer, false);
    }

    /**
     * Uses the rainbow table.
     * Postcondition: If this is jgrasp, set this to consumable.
     * Postcondition: Set jgrasp module for having an hash algorithm to true.
     * Postcondition: Jgrasp throws a bug
     * Postcondition: Increases risk chance and sus
     */
    public void use()
    {
        if (this.validJgrasp())
        {
            Jgrasp currProg = ((Jgrasp)this.getTargetPlayer().getCurrentProgram());
            this.setConsumable(true);

            System.out.println("You input the rainbow table algorithm into jgrasp.");
            System.out.println("It seems to accept it..?");

            this.getTargetPlayer().changeSus(5);
            this.getTargetPlayer().changeRiskChance(10);

            currProg.hackerCheckoff(0);
            currProg.setBuggy(true);
        }
    }
}

package objects.items;

import gameNav.Player;
import gameNav.ProgramList;
import objects.programs.Github;
import objects.programs.Jgrasp;

/**
 * Console log object returns a log of the bot results.
 * This can later be used to upload to github.
 * @author Justin
 * @since 1/10/21
 * @category objects/JustinWare
 */
public class ConsoleLog extends Items
{
    /**
     * The array that contains the steps for the normal ending
     */
    private boolean[] normalCheckoff;

    /**
     * The array that contains the steps for the hacker ending
     */
    private boolean[] hackerCheckoff;
    /**
     * Constructs a console log object.
     * Postcondition: Transfers data from jgrasp to here
     * @param targetPlayer The main player inside the game
     * @throws Exception if ConsoleLog.txt does not exist
     */
    public ConsoleLog(Player targetPlayer) throws Exception
    {
        super("Console Log", targetPlayer);
        Jgrasp jgrasp = (Jgrasp)ProgramList.fetchAuthority("Jgrasp");

        jgrasp.transferHacker(this.hackerCheckoff);
        jgrasp.transferLegit(this.normalCheckoff);
    }

    /**
     * Transports the console log stuff to github.
     * Precondition: The current program is github
     * Postcondition: Transfers the hacker and normal checkoff here to github
     */
    public void use()
    {
        if (this.getTargetPlayer().getCurrentProgram().getName().equals("Github"))
        {
            Github currProg = (Github)this.getTargetPlayer().getCurrentProgram();
            currProg.hackerDataTransfer(this.hackerCheckoff);
            currProg.legitDataTransfer(this.normalCheckoff);   
        }
        else
        {
            System.out.println("Looks like you can't console log here... weird.");
            System.out.println("anddd you just wasted a console log");
        }
    }

    /**
     * Returns the current phase of the hacker ending array
     * @return The last index in the hacker array where there is a true, or -1 if they're all false.
     */
    public int hackerIdx()
    {
        for (int i=this.hackerCheckoff.length - 1; i >=0; i--)
        {
            if (hackerCheckoff[i])
            {
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns the current phase of the legit ending array
     * @return The last index in the legit array where there is a true, or -1 if all false
     */
    public int legitIdx()
    {
        for (int i=this.normalCheckoff.length - 1; i>=0; i--)
        {
            if (normalCheckoff[i])
            {
                return i;
            }
        }

        return -1;
    }
}

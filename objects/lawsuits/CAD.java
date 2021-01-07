package objects.lawsuits;

import gameNav.Player;
import gameNav.ProgramList;
import objects.programs.Programs;

/**
 * CAD is short for cease and desist orders.
 * These are combatted with Henry Stickmin.
 * 'Cause why fight the law when you can be the law with the Toppats?
 * @author Justin
 * @since 1/6/21
 * @category objects/JustinWare
 */
public class CAD extends Lawsuits
{
    /**
     * A verb that can be markoved
     */
    private static String[] verb = {
        "was angry",
        "felt offended",
        "was furious",
        "was attacked",
        "was really mad",
        "was really really really mad",
        "felt disturbed",
        "felt very pandaReee",
        "was outraged"
    };

    /**
     * A grievance that can be markoved
     */
    private static String[] grievance = {
        "your dealings with illegal dark web companies",
        "your involvement in borderline illegal activies",
        "the fact that you were able to bypass the law and do stuff",
        "your decision to bypass the reddit API and do things illegal",
        "your violation of reddit's terms of service",
        "the fact that experienced software engineers are above the law because LAS plebs have no idea how to regulate us",
        "how easy it is to break the law legally",
        "your decision to launch hacking attacks on reddit",
        "your web scraping. Literally. That's it",
        "your risky purchase of very illegal stuff"
    };

    /**
     * The program this lawsuit will disable
     */
    private Programs program;

    /**
     * Constructor for the CAD lawsuit
     * @param targetPlayer The main player inside the game
     * @throws Exception if description is undefined (shouldn't be though)
     */
    public CAD(Player targetPlayer) throws Exception
    {
        super("CAD", targetPlayer, "The Plantiff "+ Lawsuits.random(CAD.verb) 
        + " by " + Lawsuits.random(CAD.grievance) + 
        " and demands you to immediately cease and desist your risky actions.");
        ;
    }

    public void effect()
    {
        this.program = ProgramList.fetchRandomProgram();
        this.program.setEnabled(false);
    }

    /**
     * The command triggered when the user attacks the CAD lawsuit with a lawyer.
     * Returns if the suit challenge is successful. Triggers a generic victory if it goes above and beyond with the right lawyer.
     * Postcondition: If the challenge is successful, the program is set to enabled again
     * @param chance The chance of you winning the lawsuit
     * @param lawyer Whether or not you have a lawyer. This is temp for now.
     * @return whether the suit challenge is successful
     */
    public boolean challenge(int chance, boolean lawyer) //Note to self: add lawyer
    {
        if ((int)(Math.random() * 100) < chance)
        {
            if (lawyer)
            {
                this.victory();
            }
            this.program.setEnabled(true);
            System.out.println("Lawsuit challenge successful! This lawsuit was thrown out.");
            return true;
        }
        
        System.out.println("Lawsuit challenge failed. You have the ability to appeal this in court.");
        return false;
    }

    /**
     * The custom settle method for CAD lawsuits. This will settle the lawsuit.
     * Postcondition: The program that was disabled is now enabled.
     */
    public void settle()
    {
        System.out.println("You have settled this lawsuit!");
        this.program.setEnabled(true);
    }
}

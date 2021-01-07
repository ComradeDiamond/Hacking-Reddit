package objects.lawsuits;

import gameNav.Player;
import gameNav.ProgramList;

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

    }
}

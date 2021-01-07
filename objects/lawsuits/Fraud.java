package objects.lawsuits;

import gameNav.Player;

/**
 * Represents a fraud lawsuit.
 * These are combatted with Dream's Holy Astrophysicist with a Ph.D from Harvard lmao.
 * These lawsuits basically mean people think you are lying to them about srs bot's intent
 * @author Justin
 * @since 1/6/21
 * @category objects/JustinWare
 */
public class Fraud extends Lawsuits
{
    /**
     * A verb that can be markoved
     */
    private static String[] verb = {
        "was scared",
        "felt scared",
        "was cheated",
        "was sad",
        "was really sad",
        "was really really really sad",
        "felt suspicious",
        "felt decieved",
        "felt lied to"
    };

    /**
     * A grievance that can be markoved
     */
    private static String[] grievance = {
        "the questionable things you're doing with srs",
        "your mingling in questionable actvities",
        "you violating your bot's promise to be a good bot and decided to resort to dark mode",
        "you allegedly violating your bot's promise to not spy on people",
        "your depiction of your bot as safe while running sus addons",
        "your depiction of your bot as safe while running sus network requests",
        "the claims you made about srs bot",
        "the legitamacy of your bot code",
        "whether or not you copied and pasted code off stack overflow",
        "the questionable lines of srs bot code"
    };

    /**
     * Constructor for the fraud lawsuit
     * @param targetPlayer The main player inside the game
     * @throws Exception if description is undefined (shouldn't be though)
     */
    public Fraud(Player targetPlayer) throws Exception
    {
        super("Fraud", targetPlayer, "The Plantiff "+ Lawsuits.random(Fraud.verb) 
        + " by " + Lawsuits.random(Fraud.grievance) + " and demands $" 
        + (int)(Math.random() * 500) + " as settlement.")
        ;
    }
}

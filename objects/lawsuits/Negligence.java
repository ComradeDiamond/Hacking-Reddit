package objects.lawsuits;

import gameNav.Player;

/**
 * Represents a negligence lawsuit.
 * These are combatted with Pheniox Wright.
 * @author Justin
 * @since 1/6/21
 * @category objects/JustinWare
 */
public class Negligence extends Lawsuits
{
    /**
     * A verb that can be markoved
     */
    private static String[] verb = {
        "felt ripped off",
        "was offended",
        "was angry",
        "was sad",
        "was really sad",
        "was really really really sad",
        "was disappointed",
        "was not impressed"
    };

    /**
     * A grievance that can be markoved
     */
    private static String[] grievance = {
        "the quality of your discord bot",
        "the quality of srs bot code",
        "the trash quality of srs bot code",
        "all the illegal activities you willingly allowed your bot to do",
        "the harm you exposed srs users to via shady tactics",
        "the harmful network requests of srs bot",
        "the unsafe content srs bot is exposing user to",
        "the suspicious addons you put into srs bot",
        "the risky actions of srs bot",
        "the questionable lines of srs bot code"
    };

    /**
     * Constructor for the negligence lawsuit
     * @param targetPlayer The main player inside the game
     * @throws Exception if description is undefined (shouldn't be though)
     */
    public Negligence(Player targetPlayer) throws Exception
    {
        super("Negligence", targetPlayer, "The Plantiff "+ Lawsuits.random(Negligence.verb) 
        + " by " + Lawsuits.random(Negligence.grievance) + " and demands $" 
        + (int)(Math.random() * 500) + " as settlement.")
        ;
    }
}

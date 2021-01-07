package objects.lawsuits;

import gameNav.Player;

/**
 * Represents a defamation lawsuit.
 * These are combatted with a gen z lawyer called "Swag No Lag".
 * "It's the lack of evidence for me <insert Heart emote>"
 * @author Justin
 * @since 1/6/21
 * @category objects/JustinWare
 */
public class Defamation extends Lawsuits
{
    /**
     * A verb that can be markoved
     */
    private static String[] verb = {
        "was angry",
        "felt angry",
        "was outraged",
        "was sad",
        "was really sad",
        "was really really really sad",
        "felt offended",
        "felt betrayed",
        "felt sangry"
    };

    /**
     * A grievance that can be markoved
     */
    private static String[] grievance = {
        "your attacks on dark mode",
        "your bot not wanting LemonJesus to suceed",
        "your bot rating discord dark mode -50000/10",
        "you using light mode",
        "your bot's prediction that LemonJesus will not get into Princeton",
        "you slamming Harvard for grade inflation",
        "you using your public platform to support Discord light mode",
        "you using questionable addons and saying 'reddit told me this was safe'",
        "your status as a dream stan",
        "your decision to not attend Stuyvesant"
    };

    /**
     * Constructor for the fraud lawsuit
     * @param targetPlayer The main player inside the game
     * @throws Exception if description is undefined (shouldn't be though)
     */
    public Defamation(Player targetPlayer) throws Exception
    {
        super("Defamation", targetPlayer, "The Plantiff "+ Lawsuits.random(Defamation.verb) 
        + " by " + Lawsuits.random(Defamation.grievance) + " and demands $" 
        + (int)(Math.random() * 500) + " as settlement.")
        ;
    }
}

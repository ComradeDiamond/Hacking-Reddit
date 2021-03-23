package objects.items;

import gameNav.Player;
import objects.programs.Jgrasp;

/**
 * JSDOM item.
 * This is a library that lets you do illegal activities with websites.
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class JSDOM extends Items
{
    /**
     * Constructs a JSDOM object that's "not consumable"
     * @param targetPlayer The main player inside the game
     * @throws Exception if JSDOM.txt does not exist
     */
    public JSDOM(Player targetPlayer) throws Exception
    {
        super("JSDOM", targetPlayer, false);
    }

    /**
     * Checks off jgrasp's second normal ending position.
     * Precondition: The current program is jgrasp
     * Postcondition: JSDOM is set to consumable
     * Postcondition: Jgrasp throws a bug
     * Postcondition: Jgrasp's 1st index in normal checkoff array is true
     * Postcondition: Player's risk increases by 5
     */
    public void use()
    {
        if (this.validJgrasp())
        {
            Jgrasp currProg = (Jgrasp)this.getTargetPlayer().getCurrentProgram();
            
            currProg.normalCheckoff(1);
            this.setConsumable(true);
            this.getTargetPlayer().changeRiskChance(5);
            
            System.out.println("You imported the entire 50GB JSDOM library into the IDE.");
            System.out.println("Magically, it allows you to fetch the structures of the web pages!");
            System.out.println("Seems like this and observable code might be getting somewhere.\n");
            currProg.setJSDOMException(false);

            currProg.setBuggy(true);
            System.out.println("uhhhhhhhhhhhhhh maybe not");

            //meme credit to cat
            System.out.println("You should get a lawyer if you get questioned by the police");
        }
    }
}

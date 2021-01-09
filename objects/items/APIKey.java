package objects.items;

import gameNav.Player;
import objects.programs.Programs;
import objects.programs.Jgrasp;

/**
 * The reddit API key! It's used on jrasp so you're finally able to access the reddit API with srs bot!
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class APIKey extends Items
{
    /**
     * Constructs an APIKey object
     * @param targetPlayer The main player inside the game
     * @throws Exception if APIKey.txt does not exist
     */
    public APIKey(Player targetPlayer) throws Exception
    {
        super("API Key", targetPlayer, false);
    }

    /**
     * Checks off the final checkbox in the hacker ending. After this, you pretty much win.
     * Precondition: The current program is jgrasp and jgrasp is not buggy
     * Precondition: The user inputs the API Key correctly
     * Postcondition: Sets consumable to true
     * Postcondition: Checks off the 4th checkbox in hacker ending
     * Postcondition: Throws a jgrasp bug if the API key is wrong
     */
    public void use()
    {
        if (this.validJgrasp())
        {
            Jgrasp currProg = (Jgrasp)this.getTargetPlayer().getCurrentProgram();
            System.out.print("Please insert the API Key exactly: ");
            
            String input = this.getScanner().nextLine();

            if (input.equals("I believe in Array List Supremacy"))
            {
                currProg.hackerCheckoff(3);
                this.setConsumable(true);

                String str = "You insert the reddit API key in a network request.\n" +
                "The same API Key that you were denied access from earlier.\n" +
                "...\n" +
                "...\n" +
                "And the API key compiles!";

                System.out.println(str);
            }
            else
            {
                System.out.println("Processing API Key....");
                System.out.println("Your jgrasp ran into an error because the API Key is wrong lmao");

                currProg.setBuggy(true);
            }
        }
    }
}

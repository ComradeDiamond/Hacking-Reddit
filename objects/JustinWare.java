package objects;
import gameNav.Player;
import java.util.Scanner;

/**
 * JustinWares are like objects - but they're objects created by Justin - that's why they're called 
    Justinware!
 * The major superclass of commands, programs, and items - anything utility/item/tool 
   that Justin creates in this game.
 * This class is used mostly for polymorphism and procedural abstraction in gameNav.player
 * @author Justin
 * @category objects
 * @since 12/14/20
 */
public class JustinWare {
    /**
     * Name of the JustinWare
     */
    private String name;
    /**
     * Description of the JustinWare
     */
    private String description;
    /**
     * The target player the JustinWare would act on
     */
    private Player targetPlayer;
    /**
     * The name of the subclass calling super() on this JustinWare
     */
    private String subclassName;

    /**
     * The scanner that JustinWares would use in order to accept an input
     * This is seperate from the mainstream scanner
     */
    private Scanner secondaryScanner;

    /**
     * Constructs a JustinWare object
     * @param name The name of the JustinWare
     * @param description The description of the JustinWare
     * @param targetPlayer The target player in the game
     * @param programType The name of the subclass that will be using this JustinWare
     * Precondition: targetPlayer must be the current player specified in gameNav.game
     * Postcondition: JustinWare officially constructed
     * @throws Exception if description does not exist
     */
    public JustinWare(String name, String description, Player targetPlayer, String subclassName) throws Exception
    {
        this.name = name;
        this.description = description;
        this.targetPlayer = targetPlayer;
        this.subclassName = subclassName;

        this.secondaryScanner = new Scanner(System.in);
    }

    /**
     * Gets the name of the JustinWare
     * @return this.name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Gets the description of the JustinWare
     * @return this.description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Returns a filled in template to display the JustinWare formally
     * Usually will be used in ask commands
     * @return The filled in log template
     */
    public String getLog()
    {
        return "** " + this.name + " - " + this.subclassName + " **\n" + 
        "------------------------ \n" + 
        this.description + "\n------------------------";
    }

    /**
     * Accessor method that gets the target player
     * @return this.targetPlayer
     */
    public Player getTargetPlayer()
    {
        return this.targetPlayer;
    }

    /**
     * Returns the secondary scanner this JustinWare will use
     * @return this.secondaryScanner
     */
    public Scanner getScanner()
    {
        return this.secondaryScanner;
    }
}

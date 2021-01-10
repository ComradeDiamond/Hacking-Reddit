package objects.items;

import gameNav.Player;
import objects.programs.Jgrasp;

/**
 * The observable code :P
 * This code contains knowledge that can be used inside jgrasp to obtain the website metadata!
 * Srs bot can convienently run this to obtain data
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class ObservableCode extends Items
{
    /**
     * Constructs a ObservableCode object
     * @param targetPlayer The main player inside the game
     * @throws Exception if ObservableCode.txt does not exist
     */
    public ObservableCode(Player targetPlayer) throws Exception
    {
        super("Observable Code", targetPlayer, false);
    }

    /**
     * Checks off the first step to a legit ending in jgrasp
     * Precondition: The current program is jgrasp
     * Postcondition: Checks off the first step to a legitamate Jgrasp ending
     * Postcondition: Jgrasp throws a huge exception. Player recieves an error log thingy, idk
     * Postcondition: Sets consumable to true
     * Postcondition: Sets jgraspException in jgrasp to true
     */
    public void use()
    {
        if (this.validJgrasp())
        {
            Jgrasp currProg = (Jgrasp)this.getTargetPlayer().getCurrentProgram();
            
            this.setConsumable(true);
            currProg.normalCheckoff(0);

            String str = "You took your sheet of compiled observable code and yeeted them into jgrasp.\n" +
            "Jgrasp magically understands what patterns to follow.\n" +
            "It types in a bunch of HTML I don't understand.\n";

            System.out.println(str);

            //Insert stuff abt error log
            System.out.println("-------Jgrasp Error Log----------");
            System.out.println("ObservableException found in thread 'upload' java.lang.doesNotExistException\n    at objects.programs.Discord.java:2021\n     at base -1 of 3E");
            System.out.println("---------------------------------");

            try
            {
                new ErrorLog(this.getTargetPlayer()).addToInventory();
            }
            catch(Exception e)
            {}

            currProg.setJSDOMException(true);
        }
    }
}

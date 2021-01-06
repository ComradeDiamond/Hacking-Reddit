package objects.programs;

import gameNav.Player;

/**
 * JGrap is the programming platform you'll use to code stuff into srs bot
 * @author Justin
 * @since 12/24/20
 * @category objects/JustinWare
 */
public class Jgrasp extends Programs
{
    /**
     * Keeps track of all the exceptions text.
     * These will be used when jgrasp starts being jgrasp.
     * Note to self: to set up, for (a of <hugeChunk>split("\n"))
        {
            e += `${a}\\n`
        }
     */
    private static String[] exceptions = {
        "Exception in thread 'main' java.lang.StringIndexOutOfBoundsException: String index out of range: -1\n        at java.base/java.lang.String.substring(String.java:1841)\n        at gameNav.CommandWord.redirect(CommandWord.java:47)\n        at gameNav.Parser.parse(Parser.java:50)\n        at gameNav.Game.playRound(Game.java:76)\n        at gameNav.Game.playGame(Game.java:57)\n        at Main.main(Main.java:7)\n",
        "Exception in thread \"main\" java.lang.NullPointerException\n        at gameNav.Player.returnInventory(Player.java:404)\n        at objects.commands.Inventory.execute(Inventory.java:31)\n        at gameNav.CommandWord.redirect(CommandWord.java:54)\n        at gameNav.Parser.parse(Parser.java:54)\n        at gameNav.Game.playRound(Game.java:76)\n        at gameNav.Game.playRound(Game.java:91)\n        at gameNav.Game.playRound(Game.java:91)\n        at gameNav.Game.playRound(Game.java:91)\n        at gameNav.Game.playRound(Game.java:91)\n        at gameNav.Game.playRound(Game.java:91)\n        at gameNav.Game.playRound(Game.java:91)\n        at gameNav.Game.playRound(Game.java:91)\n        at gameNav.Game.playRound(Game.java:91)\n        at gameNav.Game.playRound(Game.java:91)\n        at gameNav.Game.playGame(Game.java:57)\n        at Main.main(Main.java:7)\n",
        "FilenotFound_Demo.java:8: error: unreported exception FileNotFoundException; must be caught or declared to be thrown\n      FileReader fr = new FileReader(file);\n",
        "Exception thrown  :java.lang.ArrayIndexOutOfBoundsException: 3",
        "InsufficientFundsException\n         at CheckingAccount.withdraw(CheckingAccount.java:25)\n         at BankDemo.main(BankDemo.java:13)\n",
        "Jgrasp exception in thread 'main' java.lang.JgraspException: Jgrasp is being Jgrasp"
    };

    /**
     * Keeps track of whether jgrasp has a bug
     */
    private boolean buggy;

    /**
     * The exception number that jgrasp is currently on.
     * This number will be used to return a nice exception message lol
     */
    private int exceptionIdx;
    
    /**
     * Constructs a Jgrasp object
     * @param targetPlayer The main player inside the game
     * @throws Exception if Jgrasp.txt does not exist
     */
    public Jgrasp(Player targetPlayer) throws Exception
    {
        super("Jgrasp", targetPlayer);
        this.buggy = false;
        this.exceptionIdx = -1;
    }

    /**
     * Accessor method for whether jgrasp is buggy
     * @return this.buggy
     */
    public boolean getBuggy()
    {
        return this.buggy;
    }

    /**
     * Sets whether or not jgrasp is buggy.
     * Precondition: If you want to set jgrasp to buggy, it must not be buggy as of now. Two bugs at once isn't good
     * Postcondition: if jgrasp is NOT buggy, clear the exceptionIdx back to -1
     * Postcondition: if jgrasp is buggy, throw an error.
     * @return Whether or not you are able to make set/clear jgrasp buggy status
     */
    public boolean setBuggy(boolean buggy)
    {
        if (buggy)
        {
            if (this.buggy)
            {
                return false;
            }
            
            this.buggy = true;
            this.throwException();
        }
        else
        {
            this.buggy = false;
            this.exceptionIdx = -1;
        }

        return true;
    }

    /**
     * Observes jgrasp. Hey, there is a slight chance you'll be able to fix a bug!
     * Postcondition: Once in a blue moon, this resolves a bug
     */
    public void observe()
    {
        if (this.buggy)
        {
            System.out.println("Debugging.....");
            //10% chance of resolving bug... because that's us in class lol
            if ((int)(Math.random() * 10) == 2)
            {
                System.out.println("By some holy magic, jgrasp bug is resolved! POG");
                this.setBuggy(false);
            }
            else
            {
                this.throwException();
            }
        }
        else
        {
            System.out.println("Seems like jgrasp weirdly has no bugs! Wow!");
        }
    }

    /**
     * Jgrasp does a jgrasp and throws an exception.
     * If there is an exception idx that's not -1, use it. If not, roll one.
     * Is it weird that throwException does not throw an exception?
     * Will I get points off this project if Folwell sees an exception?
     * I dunno
     */
    private void throwException()
    {
        //Grabs a random thing from exceptions array
        if (this.exceptionIdx == -1)
        {
            this.exceptionIdx = (int)(Math.random() * Jgrasp.exceptions.length);
        }

        System.out.println(Jgrasp.exceptions[this.exceptionIdx]);
    }
}

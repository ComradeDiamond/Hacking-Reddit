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
     * Rainbow table --> password cracker --> folwell fix --> API Key
     * The boolean array to keep track of the hacker ending
    **/
    private boolean[] hackerEnding;

    /**
     * Uploaded all 3 items (return error log once this becomes true),
     * jsdom --> old reddit link
     * The boolean array to keep track of the legit ending
    **/
    private boolean[] legitEnding;

    /**
     * Returns whether the player has the error where they need JSDOM to proceed.
     */
    private boolean jsdomException;
    
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
        this.hackerEnding = new boolean[]{false, false, false, false};
        this.legitEnding = new boolean[]{false, false, false};
        this.jsdomException = false;
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
     * Precondition: Jgrasp does not have a JSDOM exception or else it won't be able to be resolved
     * Precondition: Weirdly, for Jgrasp to work properly in Jgrasp, Jgrasp needs to have a bug!
     * Postcondition: Once in a blue moon, this resolves a bug
     */
    public void observe()
    {
        if (this.jsdomException)
        {
            System.out.println("Looks like you can't resolve the error just by debugging");
            return;
        }

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
     * I dunno.
     * Postcondition: Throws an exception and/or sets a custom exceptionIdx if it is not -1
     * Postcondition: May throw custom exceptions
     */
    public void throwException()
    {
        if (!this.buggy)
        {
            System.out.println("Can't throw exception... it's not buggy");
        }

        //Grabs a random thing from exceptions array
        if (this.exceptionIdx == -1)
        {
            this.exceptionIdx = (int)(Math.random() * Jgrasp.exceptions.length);
        }

        System.out.println(Jgrasp.exceptions[this.exceptionIdx]);
    }

    /**
     * Checks off the hacker ending and sets item at idx to true.
     * Precondition: 0 <= idx < 4
     * @param idx The index of the hacker ending arr to set to true
     */
    public void hackerCheckoff(int idx)
    {
        this.hackerEnding[idx] = true;
    }

    /**
     * Checks off the legit ending and sets item at idx to true.
     * Precondition: 0 <= idx < 3
     * @param idx The index of the legit ending arr to set to true
     */
    public void normalCheckoff(int idx)
    {
        this.legitEnding[idx] = true;
    }

    /**
     * Transfers the hacker ending array items to another array.
     * Precondition: other.length == 4
     * Postcondition: The hackerEnding array is not modified
     * Postcondition: Other != this.hackerEnding in terms of references
     * @param other The other array to transfer the legitEnding values here to
     */
    public void transferHacker(boolean[] other)
    {
        for (int i=0; i<this.hackerEnding.length; i++)
        {
            other[i] = this.hackerEnding[i];
        }
    }

    /**
     * Transfers the legit ending array items to another array.
     * Precondition: other.length == 3
     * Postcondition: The legitEnding array is not modified
     * Postcondition: Other != this.legitEnding in terms of references
     * @param other The other array to transfer the legitEnding values here to
     */
    public void transferLegit(boolean[] other)
    {
        for (int i=0; i<this.legitEnding.length; i++)
        {
            other[i] = this.legitEnding[i];
        }
    }

    /**
     * Returns the progress for the hacker ending
     * @return The last index in the hacker ending array where the item is true. If all of them are false, return -1
     */
    public int getHackerProg()
    {
        int truthIdx = -1;

        for (int i=0; i<this.hackerEnding.length; i++)
        {
            if (this.hackerEnding[i])
            {
                truthIdx = i;
            }
        }

        return truthIdx;
    }

    /**
     * Returns the progress for the legit ending
     * @return The last index in the legit ending array where the item is true. If all of them are false, return -1
     */
    public int getLegitProg()
    {
        int truthIdx = -1;

        for (int i=0; i<this.legitEnding.length; i++)
        {
            if (this.legitEnding[i])
            {
                truthIdx = i;
            }
        }

        return truthIdx;
    }

    /**
     * Sets the jsdom exception attribute
     * @param jsdomException The boolean to set jsdomException attribute to
     */
    public void setJSDOMException(boolean jsdomException)
    {
        this.jsdomException = jsdomException;
    }
}

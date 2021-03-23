package objects.programs;

import gameNav.Player;

/**
 * The Github class - this is where you upload all your finished code to save as progress.
 * Use a console log here if you want to upload your code.
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class Github extends Programs
{
    /**
     * The array that checks off the player's progress in the hacker ending
     */
    private boolean[] hackerEnding;

    /**
     * The array that checks off the player's progress in the legit ending
     */
    private boolean[] legitEnding;

    /**
     * Constructs a github object
     * @param targetPlayer The main player inside the game
     * @throws Exception if Github.txt does not exist
     */
    public Github(Player targetPlayer) throws Exception
    {
        super("Github", targetPlayer);

        //Rainbow table --> password cracker --> folwell fix --> API Key
        hackerEnding = new boolean[]{false, false, false, false};

        //Uploaded all 3 items (return error log once this becomes true),
        //jsdom --> old reddit link
        legitEnding = new boolean[]{false, false, false};
    }

    /**
     * Displays the player's progress towards the legit ending.
     */
    public void observe()
    {
        String str = "---------Github Commit Report-----------\n" +
        "ending 1: " + (this.getProgressStep(true) + 1) + "/3\n"+
        "ending 2: 0/?\n" +
        "----------------------------------------";

        System.out.println(str);
    }

    /**
     * Displays the player's progress towards the hacker ending.
     */
    public void drip()
    {
        String str = "---------Github Repo Hacked Metadata--------\n" +
        "ending 2: " + (this.getProgressStep(false) + 1) + "/4\n" +
        "----------------------------------------";

        System.out.println(str);
    }

    /**
     * Returns what progress phase the player is in regarding a route
     * @param isLegitEnding whether the array you're trying to view is the legit ending.
        * If false, this will be the hacker ending
     * @return the last index in hackerEnding or legitEnding where a boolean is true. Returns -1 if all of them are false
     */
    public int getProgressStep(boolean isLegitEnding)
    {
        boolean[] tempArr = isLegitEnding ? this.legitEnding : this.hackerEnding;

        for (int i=tempArr.length -1; i>=0; i--)
        {
            if (tempArr[i])
            {
                return i;
            }
        }

        return -1;
    }

    /**
     * Transfers the hacker data of a console log to github.
     * Precondition: other.length == 3
     * Postcondition: hackerEnding array contains the reference to the same array
     * Postcondition: If all array items are true, declare the player won and the victory type to be hacker
     * @param other The other array to transfer data to hacker ending array
     */
    public void hackerDataTransfer(boolean[] other)
    {
        boolean allTrue = true;

        for (int i=0; i<other.length; i++)
        {
            if (!other[i])
            {
                allTrue = false;
            }

            this.hackerEnding[i] = other[i];
        }

        if (allTrue)
        {
            this.getTargetPlayer().setWinType("Hacker");;
            this.getTargetPlayer().setWin(true);
        }
    }

    /**
     * Transfers the legit data of a console log to github.
     * Precondition: other.length == 3
     * Postcondition: legitEnding array contains the reference to the same array.
     * Postcondition: If all the items in the array are true, declare that the player won and the win type to be legit
     * @param other The other array to transfer data to legit ending array
     */
    public void legitDataTransfer(boolean[] other)
    {
        boolean allTrue = true;

        for (int i=0; i<other.length; i++)
        {
            if (!other[i])
            {
                allTrue = false;
            }

            this.legitEnding[i] = other[i];
        }

        if (allTrue)
        {
            this.getTargetPlayer().setWinType("Legit");;
            this.getTargetPlayer().setWin(true);
        }
    }
}

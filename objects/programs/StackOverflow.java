package objects.programs;
import gameNav.Player;
import gameNav.ProgramList;
import objects.items.Debugger;
import objects.items.DevTool;

/**
 * StackOverflow - the go to hub for Q&A Inside the game
 * You'll find better descriptions than these javadocs inside textLore
 * Or just play the game lmao
 * @author Justin
 * @since 12/15/20
 * @category objects/JustinWare
 */
public class StackOverflow extends Programs 
{
    /**
     * Keeps track of whether the player has recieved a devTool
     */
    private boolean devToolGot;

    /**
     * Constructs a stack overflow program
     * @param targetPlayer The main punique player initialized in the game
     * @throws Exception if Stack Overflow.txt does not exist
     */
    public StackOverflow(Player targetPlayer) throws Exception
    {
        super("Stack Overflow", targetPlayer);
        devToolGot = false;
    }

    /**
     * Uploads a post to Stack overflow. This is a good way to resolve bugs.
     * There are multiple scenarios that could play out with this upload command.
     * <ul>
     * <li>
     * <div>Getting a DevTool - 
        * Postcondition: A DevTool  is added to the player's inventory
        * Precondition: You have visited r/Christmas, have aws on, and have jgrasp on</div>
     * </li>
     * <li>
     * <div>Debugging - 
        * Precondition: jgrasp has a bug.
        * Postcondition: There is a 75% chance to get a debugger to clear jgrasp bugs.</div>
     * </li>
     * </ul>
     * Otherwise, stack overflow just downvotes you to oblivion
     */
    public void upload()
    {
        if (!recaptcha())
        {
            return;
        }

        if (!devToolGot)
        {
            boolean b1 = this.getTargetPlayer().fetchProgram("AWS") != null;
            boolean b2 = this.getTargetPlayer().fetchProgram("Jgrasp") != null;
            boolean b3 = ((Reddit)ProgramList.fetchAuthority("Reddit")).getChristmas();

            if (b1 && b2 && b3)
            {
                try
                {
                    new DevTool(this.getTargetPlayer()).addToInventory();
                }
                catch(Exception e){}
                return;
            }
        }

        if (((Jgrasp)ProgramList.fetchAuthority("Jgrasp")).getBuggy())
        {
            try
            {
                new Debugger(this.getTargetPlayer()).addToInventory();
            }
            catch(Exception e){}
            return;
        }

        System.out.println("But noone replied. Instead, you got downvoted.");
    }

    /**
     * Creates a recaptcha puzzle for the player to solve. If the player can solve it, the upload goes through.
     * Postcondition: if the player doesn't successfully solve the recaptcha, they lose 50 energy and 20 batteries for being a bot
     * @return whether player successfully solved the recaptcha
     */
    private boolean recaptcha()
    {
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        String str = "Please solve the recaptcha and find the sum of the minimum and " +
        "maximum value of this array: [2, 3, 4, 5, 6, 7, 8, 9, 10]";
        System.out.println(str);
        
        String answer = this.getScanner().nextLine();
        int sum = this.findMin(arr) + this.findMax(arr);
        
        boolean valid = answer.equals(sum + "");

        if (!valid)
        {
            System.out.println("The recaptcha has deemed that you are a robot as your answer is wrong.");
            System.out.println("Your post was rejected. Your battery was decreased.");
            this.getTargetPlayer().batteryChange(-20);
            this.getTargetPlayer().energyChange(-50);
        }

        return valid;
    }

    /**
     * Helper method that finds the minimum value in an array
     * @param arr An int array
     * @return the min value of an array
     */
    private int findMin(int[] arr)
    {
        int min = arr[0];

        for (int num : arr)
        {
            if (num < min)
            {
                min = num;
            }
        }

        return min;
    }

    /**
     * Helper method that finds the maximum value in an array
     * @param arr An int array
     * @return the max value of an array
     */
    private int findMax(int[] arr)
    {
        int max = arr[0];

        for (int num : arr)
        {
            if (num > max)
            {
                max = num;
            }
        }

        return max;
    }
}

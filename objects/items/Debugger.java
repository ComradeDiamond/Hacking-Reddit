package objects.items;

import gameNav.Player;
import objects.programs.Jgrasp;

/**
 * A debugger - has a 50% chance of getting rid of bugs
 * @author Justin
 * @since 1/10/21
 * @category objects/JustinWare
 */
public class Debugger extends Items
{
    /**
     * Constructs a debugger object
     * @param targetPlayer The main player inside the game
     * @throws Exception if Debugger.txt does not exist
     */
    public Debugger(Player targetPlayer) throws Exception
    {
        super("Debugger", targetPlayer);
    }

    /**
     * Cleans up bugs... well has a chance to.
     * Precondition: The current program is jgrasp.
     * Precondition: The recaptcha question is answered correctly
     * Precondition: Jgrasp has a bug
     * Postcondition: There is a chance it will be set to unbuggy
     */
    public void use()
    {
        if (this.getTargetPlayer().getCurrentProgram().getName().equals("Jgrasp"))
        {
            System.out.println("Before using the debugger, we need to make sure you're not a robot.");
            System.out.println("True or false: there at least 1 even number in the array {1, 2, 3, 4, 5}");

            String input = this.getScanner().nextLine();
            int[] arr = new int[] {1, 2, 3, 4, 5};
            boolean hasOneEven = this.hasOneEven(arr);

            if (input.equalsIgnoreCase(hasOneEven + ""))
            {
                if ((int)(Math.random() * 2) == 1)
                {
                    Jgrasp currProg = (Jgrasp)this.getTargetPlayer().getCurrentProgram();

                    if (currProg.getBuggy())
                    {
                        currProg.setBuggy(false);
                        System.out.println("Bug detected.");
                        System.out.println("Fixing....");
                        System.out.println("Fixed.");
                    }
                    else
                    {
                        System.out.println("No valid bug detected.");
                    }
                }
                else
                {
                    System.out.println("Unable to fix bug. Please try another debugger");
                }
            }
            else
            {
                System.out.println("bot detected.");
            }
        }
        else
        {
            System.out.println("The program was not jgrasp and you just wasted your debugger");
        }
    }

    /**
     * Returns whether a given array has at least one even number in it.
     * @param arr The array to find whether it has at least 1 even number
     * @return Whether or not arr has at least one even number
     */
    private boolean hasOneEven(int[] arr)
    {
        for (int num : arr)
        {
            if (num % 2 == 0)
            {
                return true;
            }
        }

        return false;
    }
}

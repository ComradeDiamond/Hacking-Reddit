package objects.items;

import gameNav.Player;

/**
 * Artificial Intelligence would allow you to spy on the government.
 * @author Justin
 * @since 1/9/21
 * @category objects/JustinWare
 */
public class AI extends Items
{
    /**
     * Constructs an AI object
     * @param targetPlayer The main player inside the game
     * @throws Exception if AI.txt does not exist
     */
    public AI(Player targetPlayer) throws Exception
    {
        super("AI", targetPlayer);
    }

    /**
     * Sends a copy of your sus stat.
     * Precondition: You correctly find the sum of the average and mode of an array.
     * Postcondition: Increases sus by 5
     */
    public void use()
    {
        System.out.println("Before you can use artificial intelligence, you need to prove you're not a robot.");
        System.out.println("Find the sum of the average and mode of [0, 1, 2, 2, 3, 4]");

        int[] arr = new int[] {0, 1, 2, 2, 3, 4};
        String input = this.getScanner().nextLine();
        int answer = (int)this.findAverage(arr) + this.findMode(arr);

        boolean valid = input.equals(answer + "");

        if (valid)
        {
            System.out.println("Your current sus level is " + this.getTargetPlayer().getSus());
        }
        else
        {
            System.out.println("bot detected");
        }

        this.getTargetPlayer().changeSus(5);
    }

    /**
     * Helper method that finds the sum of an array.
     * Precondition: arr.length > 0
     * @param arr The array to find the sum of
     * @return The sum of the array
     */
    private int arraySum(int[] arr)
    {
        int sum = 0;

        for (int num : arr)
        {
            sum += num;
        }

        return sum;
    }

    /**
     * Finds the average of a given array
     * Precondition: arr.length > 0
     * @param arr The array to find the average of
     * @return The average of the array given
     */
    private double findAverage(int[] arr)
    {
        int sum = this.arraySum(arr);
        return (double)sum / arr.length;
    }

    /**
     * Finds the mode of a given array. A mode is defined as ONE number that occurs the most
     * Precondition: arr.length > 0
     * Precondition: int[] arr is sorted.
     * @param arr The array to find the mode of
     * @return The mode of a given array
     */
    private int findMode(int[] arr)
    {
        int targetNum = arr[0];
        int numMaxOccur = 0;
        int targetMaxNum = arr[0];
        int numOccur = 0;

        for (int num : arr)
        {
            if (num == targetNum)
            {
                numOccur++;
            }
            else
            {
                //If not match, calculate numMaxOccur and targetMaxNum
                if (numOccur > numMaxOccur)
                {
                    numMaxOccur = numOccur;
                    targetMaxNum = targetNum;
                }
                targetNum = num;
                numOccur = 1;
            }
        }

        return targetMaxNum;
    }
}

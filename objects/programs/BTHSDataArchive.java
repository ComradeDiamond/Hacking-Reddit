package objects.programs;

import gameNav.Player;
import gameNav.ProgramList;

/**
 * The go to hub for everything dark net.
 * The program tells you how to achieve the illegal ending.
 * @author Justin
 * @category objects/JustinWare
 * @since 12/24/20
 */
public class BTHSDataArchive extends Programs
{
    private static String[] techFacts = {
        "Tech was founded in 1950!",
        "The LAS major is the worst major in BTHS",
        "Hate on LAS majors and you will get very far in reddit",
        "BTHS has a professional Minecraft club!",
        "Tech has plans to restore central Air Conditioning around the school!",
        "Tech has been more Gen-Z friendly lately. We have the among us and FPS club!",
        "Brooklyn Tech has a swimming pool that most of us will never get to see",
        "Despite freshman advisory, Tech freshman will still have the freshman vibes",
        "David Newman has a presidental campaign for 2020.",
        "After Newman Nottingham for President 2020 failed, the campaign staffer of BTHS has plans to weaponize tech students in 2024 so they will vote for Newman",
        "Brooklyn Tech Confessions is a very interesting instagram page",
        "Mr. Newman has an instagram account. Interesting.",
        "BTHS has an official discord server, with over 2,000 whopping members! That's 33% of the school!",
        "There is a growing movement to hate on Python in Tech. See TechHacks for more info."
    };

    /**
     * Whether or not the player has heard about folwell replit.
     */
    private boolean heardReplit;

    /**
     * Whether or not the player recieved Folwell's code.
     */
    private boolean gotFolwellCode;

    /**
     * Constructs a BTHS Data Archive object.
     * Postcondition: A new BTHS Data Archive object is created and NOT ENABLED. All attributes are false.
     * @param targetPlayer The main player inside the game you're playing
     * @throws Exception if BTHSDataArchive.txt does not exist
     */
    public BTHSDataArchive(Player targetPlayer) throws Exception
    {
        super("BTHS Data Archive", targetPlayer, false);
        this.heardReplit = false;
        this.gotFolwellCode = false;
    }   

    /**
     * Prints a random, useless tech fact from techFacts when people try to observe here.
     */
    public void observe()
    {
        System.out.println(BTHSDataArchive.techFacts[(int)(Math.random() * BTHSDataArchive.techFacts.length)]);
    }

    /**
     * BTHS Data Archive Drip - this will print out the next step to obtaining a hacking victory.
     * Depending on what phase github hackerman ending is in, drip() will hint at what to do.
     * Precondition: user solves all recaptcha correctly
     * Postcondition: Some items may be given to the player if they use drip()
     */
    public void drip()
    {
        Github github = (Github)ProgramList.fetchAuthority("Github");
        String str = "";

        switch(github.getProgressStep(false))
        {
            case -1:
                str = "Remember that fake rainbow table cat gave you? Yea... I think you might want to craft a real one";
            break;

            case 0:
                if ((int)(Math.random() * 2) == 1)
                {
                    str = "The rainbow table gave you the hash algorithms. Now you'll need to crack it.\n" +
                    "It's really hard to do that though... if only there we had a project in class about cracking hash codes.\n" +
                    "I forgot which Password Project it was tho.";
                }
                else
                {
                    str = "Did you know you can upload your OSIS number here to get access to important stuff?";
                }
            break;

            case 1:
                str = "Turns out brute forcing hash codes isn't the smartest thing to do...\n"+
                "Or you're just not doing it correctly. Have you tried folwell repl.it?";
            break;

            case 2:
                if (this.heardReplit && !this.gotFolwellCode)
                {
                    this.replitRedirect();
                    str = "Session ended";
                }
                else
                {
                    str = "Now that you have control over reddit... you'll need to change a few things.\n"+
                    "But you're still not getting access to the web without an API key.";
                }
            break;

            default:
                str = "There's no hint here hmm";
            break;
        }

        System.out.println(str);
    }

    /**
     * Gives player access to the data archive!
     * Precondition: User inputs OSIS correctly.
     * Postcondition: If user goes to folwell powerpoints and asks for password project, they get the password cracker.
     * Postcondition: GotFolwellCode is set to true if user recieves folwell code.
     */
    public void upload()
    {
        
    }
    
    /**
     * A process that redirects the user to Folwell's repl.it and Folwell's replit code.
     * Precondition: The user solves all of the recaptchas.
     * Postcondition: Assuming they solve the recaptcha, the user gets Folwell's code to copy and paste
     */
    private void replitRedirect()
    {
        System.out.println("Redirecting to repl.it.....");
    }

    /**
     * Asks a series of recaptcha questions for the user to answer.
     * @return Whether the user solved all the recaptchas correctly
     */
    private boolean recaptcha()
    {
        boolean recaptchaCorrect = true;
        int[] arr = {1, 2, 3, 4, 5};

        //P1
        System.out.println("Before you enter, please solve repl.it's complicated recaptchas:");
        System.out.println("What would index 3 of [1, 2, 3, 4, 5] be if the array is shifted 1 index to the right?");

        String output = this.getScanner().nextLine();
        if (!output.equals(this.arrShiftRight(arr)[3] + ""))
        {
            recaptchaCorrect = false;
        }

        //P2
        System.out.println("What would index 2 of [1, 2, 3, 4, 5] be if the array was reversed?");
        output = this.getScanner().nextLine();
        if (!output.equals(this.reverse(arr)[2] + ""))
        {
            recaptchaCorrect = false;
        }

        //P3
        System.out.println("True or false: [5, 4, 3, 2, 1] has duplicate elements");
        output = this.getScanner().nextLine();
        if (!output.equals(this.hasDuplicate(arr) + ""))
        {
            recaptchaCorrect = false;
        }

        //P4
        System.out.println("How many numbers in [5, 4, 3, 2, 1] are even?");
        output = this.getScanner().nextLine();
        if (!output.equals(this.findNumEven(arr) + ""))
        {
            recaptchaCorrect = false;
        }

        String str = recaptchaCorrect ? "Recaptcha completed!" : "Recaptcha failed";
        System.out.println(str);

        return recaptchaCorrect;
    }

    /*xi. Determines the presence or absence of duplicate elements.
    xii. Determines the number of elements meeting specific criteria.
    xiii. Shifts elements of an array left or right.
    xiv. Reverses the order of the elements of an array.
    */

    /**
     * Helper method that returns an integer array consisting of shifting elements in arr one to the right
     * Postcondition: arr is not changed/modified.
     * Not shifting this because we need to keep the array for the reverse problem
     * @param arr The array to shift 1 to the right
     * @return arr, but every index is shifted one to the right and cycled back to the beginning if overflow
     */
    private int[] arrShiftRight(int[] arr)
    {
        int[] newArr = new int[arr.length];

        for (int i=0; i<arr.length - 1; i++)
        {
            newArr[i + 1] = arr[i];
        }

        newArr[0] = arr[arr.length - 1];

        return newArr;
    }

    /**
     * Helper method that returns an integer array that is arr reversed
     * Postcondition: arr is reversed
     * @param arr The array to reverse
     * @return arr, but it's reversed
     */
    private int[] reverse(int[] arr)
    {
        for (int i=0; i<arr.length / 2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        return arr;
    }

    /**
     * Helper method that checks if an array has a duplicate value
     * Postcondition: arr is unchanged
     * @param arr The array to check for duplicates
     * @return If the array has duplicates
     */
    private boolean hasDuplicate(int[] arr)
    {
        for (int i=0; i<arr.length - 1; i++)
        {
            for (int c= i+1; c<arr.length; i++)
            {
                if (arr[i] == arr[c])
                {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Helper method that returns the number of even values an array has
     * Postcondition: arr is unchanged
     * @param arr The array to check for number evens
     * @return Number of items in arr that are even
     */
    private int findNumEven(int[] arr)
    {
        int even = 0;

        for (int num : arr)
        {
            if (num % 2 == 0)
            {
                even++;
            }
        }

        return even;
    }
}

package objects.items;

import gameNav.Player;

/**
 * DevTool item.
 * This is used to inspect element and traffic on r/christmas.
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class DevTool extends Items
{
    /**
     * A huge string of trimmed down public reddit HTML.
     * This is completely fake btw.
     */
    private static String redditCode = ""+
    "<!DOCTYPE HTML in r/Christmas>\n" +
    "   <div class='abdu2323h2yty wegwyt23 huywe3i34'>\n" +
    "       <div id='Christmas Post 1' class='ehfuwehf3 Post'>\n" +
    "           <div className='3423423 PostTitle Modal342 tyy3g2y3t2y2tbj'></div>\n" +
    "           <img class='image' class='i4h3gyuu21' /> \n" +
    "       </div>\n"+
    "       <div id='Christmas Post 3' class='ehfuwehf3 Post'>\n" +
    "           <div className='3423423 PostTitle Modal342 tyy3g2y3t2y2tbj'></div>\n" +
    "           <img class='image' class='i4h3gyuu21' /> \n" +
    "       </div>\n"+
    "       <div id='Christmas Post 4' class='ehfuwehf3 Post'>\n" +
    "           <div className='3423423 PostTitle Modal342 tyy3g2y3t2y2tbj'></div>\n" +
    "           <img class='image' class='i4h3gyuu21' /> \n" +
    "       </div>\n"+
    "       <div id='Christmas Post 5' class='ehfuwehf3 Post'>\n" +
    "           <div className='3423423 PostTitle Modal342 tyy3g2y3t2y2tbj'></div>\n" +
    "           <img class='image' class='i4h3gyuu21' /> \n" +
    "       </div>\n"+
    "       <div id='Christmas Post 6' class='ehfuwehf3 Post'>\n" +
    "           <div className='3423423 PostTitle Modal342 tyy3g2y3t2y2tbj'></div>\n" +
    "           <img class='image' class='i4h3gyuu21' /> \n" +
    "       </div>\n"+
    "       <div id='Christmas Post 15' class='ehfuwehf3 Post'>\n" +
    "           <div className='3423423 PostTitle Modal342 tyy3g2y3t2y2tbj'></div>\n" +
    "           <img class='image' class='i4h3gyuu21' /> \n" +
    "       </div>\n"+
    "       <div id='Christmas Post 12' class='ehfuwehf3 Post'>\n" +
    "           <div className='3423423 PostTitle Modal342 tyy3g2y3t2y2tbj'></div>\n" +
    "           <img class='image' class='i4h3gyuu21' /> \n" +
    "       </div>\n"+
    "   </div>";

    /**
     * A reference for an observable note 1 object
     */
    private ObservableNote1 observable1;

    /**
     * A reference for an observable note 2 object
     */
    private ObservableNote2 observable2;

    /**
     * A reference for an observable note 3 object
     */
    private ObservableNote3 observable3;

    /**
     * Whether the player got observable note 1
     */
    private boolean note1Got;

    /**
     * Whether the player got observable note 3
     */
    private boolean note2Got;

    /**
     * Whether the player got observable note 2
     */
    private boolean note3Got;

    /**
     * Whether the player has completed the recaptcha in the past.
     * This is done so the player doesn't complete the recaptcha again.
     */
    private boolean recaptchad;

    /**
     * Constructs a DevTool object.
     * Postcondition: Initializes observable code 1, 2, and 3.
     * Postcondition: Recaptchad is set to false.
     * Postcondition: Sets all the note1, 2, and 3 gots to false
     * Postcondition: Increases risk by 0-5
     * @param targetPlayer The main player inside the game. Should we copy and paste this .-.
     * @throws Exception if DeveloperTools.txt does not exist
     */
    public DevTool(Player targetPlayer) throws Exception
    {
        super("Developer Tools", targetPlayer, false);
        this.observable1 = new ObservableNote1(targetPlayer);
        this.observable2 = new ObservableNote2(targetPlayer);
        this.observable3 = new ObservableNote3(targetPlayer);
        this.note1Got = false;
        this.note2Got = false;
        this.note3Got = false;

        this.recaptchad = false;
    }

    public void use()
    {
        if (this.recaptchad)
        {
            System.out.println(DevTool.redditCode+ "\n--------");

            System.out.println("What notable thing would you like to jot down?");
            String note = this.getScanner().nextLine();

            if (note.contains("Post"))
            {
                if (!this.note1Got)
                {
                    this.note1Got = true;
                    System.out.println("You jotted the noteworthy thing down.");
                    this.observable1.addToInventory();
                }
                else
                {
                    System.out.println("This was already noted.");
                }
            }
            else if (note.contains("r/Christmas"))
            {
                if (!this.note3Got)
                {
                    this.note3Got = true;
                    System.out.println("You jotted the noteworthy thing down.");
                    this.observable3.addToInventory();
                }
                else
                {
                    System.out.println("This was already noted.");
                }
            }
            else if (note.contains("img"))
            {
                if (!this.note2Got)
                {
                    this.note2Got = true;
                    System.out.println("You jotted the noteworthy thing down.");
                    this.observable2.addToInventory();
                }
                else
                {
                    System.out.println("This was already noted.");
                }
            }
            else
            {
                System.out.println("Observation noted.");
            }

            System.out.println("For snooping in devtool, your risk has increased slightly.");
            this.getTargetPlayer().changeRiskChance((int)(Math.random() * 6));
        }
        else
        {
            System.out.println("Chrome DevTools prohibits robots from exploiting the system. Please solve the recaptcha to prove you're a human.");

            if (this.recaptcha())
            {
                System.out.println("Recaptcha suceeded! You can now use DevTools!");
                this.recaptchad = true;
            }
            else
            {
                System.out.println("Robot Detected. Recaptcha failed.");
            }
        }
    }

    /**
     * Two recaptcha questions the user needs to answer in order to use Devtool.
     * @return Whether the player answered these two questions correctly
     */
    private boolean recaptcha()
    {
        boolean allRight = true;
        int[] arr = {1, 2, 3, 4, 5};
        
        System.out.println("1) True or false: Every element in {1, 2, 3, 4, 5} is odd");
        String answer = this.getScanner().nextLine();
        if (!answer.equalsIgnoreCase(this.allOdd(arr) + ""))
        {
            allRight = false;
        }

        int[] arr2 = {1, 2, 5, 8, 10};
        System.out.println("2) How many consecutive pairs of integers are in {1, 2, 5, 8, 10}?");
        answer = this.getScanner().nextLine();
        if (!answer.equalsIgnoreCase(this.consecutivePairs(arr2).length + "")) // if != consective pairs.length
        {
            allRight = false;
        }

        return allRight;
    }

    /**
     * Helper method that determines whether all items in an array are odd.
     * @param arr The array you're trying to determine if whether all items are odd
     * @return Whether all items in arr are off
     */
    private boolean allOdd(int[] arr)
    {
        for (int num : arr)
        {
            if (num % 2 == 0)
            {
                return false;
            }
        }

        return true;
    }

    /**
     * finds and returns all consective pairs inside an array
     * @param arr An array you're trying to find the consecutive pairs of
     * @return An array with all consecutive pairs inside arrays!
     */
    private int[][] consecutivePairs(int[] arr)
    {
        int[][] tempMatrix = new int[arr.length][];
        int idx = 0;

        for (int i=0; i<arr.length - 1; i++)
        {
            if (arr[i] + 1 == arr[i+1] || arr[i] - 1 == arr[i+1])
            {
                tempMatrix[idx] = new int[] {arr[i], arr[i+1]};
                idx++;
            }
        }

        int[][] pairMatrix = new int[idx][];

        for (int i=0; i<tempMatrix.length; i++)
        {
            pairMatrix[i] = tempMatrix[i];
        }

        return pairMatrix;
    }
}

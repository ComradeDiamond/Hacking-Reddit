package objects.programs;
import java.util.ArrayList;

import gameNav.Player;
import gameNav.ProgramList;
import objects.items.*;
import objects.lawsuits.*;

/**
 * Discord - the bot testing platform!
 * Handle lawsuits and interact with the playerbase!
 * Some exclusive commands would only be available on discord.
 * Dealing with the userbase would drain energy - and so will settling lawsuits.
 * The discord objects will be where you test commands!
 * @author Justin
 * @since 12/15/20
 * @category objects/JustinWare
 */
public class Discord extends Programs 
{
    /**
     * Stores all the random discord chat text the player encounters while doing observe().
     */
    private static String[] discordGibberish = new String[] {
        "2 bros university",
        "I'll remind Santa to give them coal",
        "slapping a tank would hurt",
        "fact check: cat's don't have horns",
        "why have you degenerated",
        "if you get laid by the train it's a one way trip most of the times",
        "wait i thought snacks with the principal would be eating out the principal",
        "Newman: “uhhhm I saw the chat and uh”",
        "POV: You have not used DOE Zoom.",
        "this is why u don't use lightmode; u can't see the whole thing",
        "BTHS in a nutshell: Strive to underachieve",
        "star that!",
        "no star this!",
        "wow this is really the bit we're gonna do tonight huh",
        "i wish i could but the traitorous bill difrenlie's uncle has used his influence in"+ 
        " cornell to deny me powers",
        "I tried to kiss my interviewer! Are my chances ruined?",
        "i got an sgo sticker for christmas :scream:",
        "the quality of the survey's website is the satire",
        "This is not a face of inspiration \nThis is a baroque ahegao face",
        "What the heck is Spanish",
        "i'm not a federal agent i just have no life",
        "always play competitive games of csgo with justin \nhe has infinite flashbangs",
        "all my homies are in the Bill Difrenly party",
        "Call me Mark Zuckerberg because I'm dead inside",
        "!teleport @ThatFXpress #deans-office",
        "techlaration of independence",
        "Pack your bags, you're moving to the hall of shame",
        "My grandfather mines quartz, beads, and onyx",
        "Tech teacher: why isn't computer loading \n Also tech teacher: *50 tabs open*",
        "discord must be VIM cause i cannot figure out to exit it",
        "Students need 6-8 hours of sleep\nSchools: 6-8 = -2",
        "famous last words",
        "pancakes are overrated",
        "smh go work on your college essays",
        "stan dream",
        "DREAM IS INNOCENT",
        "Dream did not cheat",
        "Yo the speedrun mods that think dream cheated are being paid to lie",
        "moan.",
        "IT'S NOT NSFW IT'S LITERALLY A SEAL",
        "Are you cimmanon? 'Cause we're on a roll!",
        "Dream did not cheat, even his PHD said so",
        "seal getting da boot",
        "GO TO THE BIN",
        "Justin this is a special case where this get's HoS'd faster than you and light mode",
        "Justin what the hek is this https://imgur.com/a/lCVB6Bq",
        "Enjoy your blue Christmas",
        "Stop vomiting on me it’s a white square",
        "yo who requested a 2 year temp ban?",
        "I'm a 6th grader!!!!!!!!!!!!!!!!",
        "wtf I got rick railed again",
        "Light theme best theme",
        "#SAVE BTHS EMAILS",
        "My 99s are gone 😢",
        "Oh no nitro expires in 3 days",
        "height redistribution is impossible you anthropomorphic animal puppet",
        "we have to write an essay to apply for college?",
        "Hmm maybe if we open jgrasp and aws and try to upload to srs bot here, we can find something useful to ask on stack overflow!",
        "Hmm maybe if we open jgrasp and aws and try to upload to srs bot here, we can find something useful to ask on stack overflow!",
        "Hmm maybe if we open jgrasp and aws and try to upload to srs bot here, we can find something useful to ask on stack overflow!",
        "Hmm maybe if we open jgrasp and aws and try to upload to srs bot here, we can find something useful to ask on stack overflow!",
        "I heard if you upload here, you can run Srs Bot here!"
    };

    private static String[] foundArr = new String[] {
        "Looking around discord, you found a shiny glimmer in #bot-corner",
        "You ran pls beg on dank memer. Looks like something fancy appeared",
        "You gathered 10 dank memer coins and bought an item from the shop",
        "Pilfering through #bot-corner, a dank memer event occured! You quickly"+ 
        " typed the word and won!",
        "A member has nitro boosted the server! Everyone gets a reward!",
        "AP Students Discord decided to be generous and host a giveaway. You entered and won!",
        "A chizu member pulled out a special piece of chizu. Upon consumption, you found something"+
        " in it",
        "A Dream stan has decided to give the server some free merch. You check your dms for it",
        "You played fetch with your dyno bot pet, and your pet brought you something!",
        "A discord member send you a gift for Christmas. You happily open it.",
        "The discord development team has chosen its daily giveaway winners! You recieve a gift!",
        "A secret Santa participant gives you a gift!"
    };

    /**
     * A running list of every item the player could get on discord.
     * There's an equal chance of any of these being obtained.
     * I've decided to make itemArr non static as it contains non-essential object references
        and items that need the targetPlayer, but can't have targetPlayer passed into it
     */
    private Items[] itemArr;

    /**
     * The phase of the discord riot
     * <ul>
     * <li>Phase 1 - Warns, will drain energy trying to quell the riot</li>
     * <li>Phase 2 - Mutes, will drain more energy trying to stop riots</li>
     * <li>Phase 3 - Bans, will give you headaches trying to stop riots</li>
     * <li>Phase 4 - Good job you're demoted and the game ends</li>
     * </ul>
     */
    private int riotPhase;

    /**
     * Keeps track of whether the user used the cat emote and successfully got a fake rainbow table
     */
    private boolean usedCatEmote;

    /**
     * The cat emote that we will use in this discord program.
     */
    private CatEmote catEmote;

    /**
     * The arrayList of all the lawsuits the user has.
     * When you add this last second lmao
     */
    private ArrayList<Lawsuits> suitList;

    /**
     * Whether the player obtained the private key from Discord.
     */
    private boolean pvg;

    /**
     * Constructs a discord program.
     * PostCondition: Sets the riotPhase to 0, usedCatEmote to false, inits all attributes
     * @param targetPlayer The main punique player initialized in the game
     * @throws Exception if Discord.txt does not exist or if CatEmote.txt does not exist
     */
    public Discord(Player targetPlayer) throws Exception
    {
        super("Discord", targetPlayer);
        this.riotPhase = 0;
        this.usedCatEmote = false;

        this.catEmote = new CatEmote(targetPlayer);
        this.itemArr = new Items[] {
            new Donut(targetPlayer),
            new BTHSShirt(targetPlayer),
            new CoinBomb(targetPlayer),
            new BobaTea(targetPlayer),
            new Debugger(targetPlayer),
            new BTHSShirt(targetPlayer),
            new SGOSticker(targetPlayer)
        };

        this.suitList = new ArrayList<Lawsuits>();
        this.pvg = false;
    }

    /**
     * Adds 1 to the riot phase
     * @return The riot phase discord is currently in
     */
    public int addRiotPhase()
    {
        this.riotPhase++;
        return this.riotPhase;
    }

    /**
     * Sets the riot phase. Usually done in with tools
     * Precondition: phase >= 0
     * Postcondition: The riot phase would be set and adjusted accordingly
     * @param phase The phase to set the riot to
     */
    public void setRiotPhase(int phase)
    {
        this.riotPhase = phase;
    }

    public void setUsedCatEmote(boolean usedCatEmote)
    {
        this.usedCatEmote = usedCatEmote;
    }

    /**
     * Will print out a random discord finding. 
     * If you have any standing lawsuits, you'll always observe those first and get to challenge or resolve them
     * Otherwise, you have a 10% chance to get something, 10% to get a cat emote, and a 10% chance
        to get a random wacky message.
     * Postcondition: Lawsuit gets removed from suitList if successfully challenged or removed.
     * Postcondition: Settling a lawsuit will drain energy by 10
     */
    public void observe()
    {
        //Observe lawsuits first
        if (this.suitList.size() > 0)
        {
            System.out.println(this.suitList.get(0).getDescription());
            System.out.println("Choose option:   Fight ($5 minimum)   Settle ($10)");
            String input = this.getScanner().nextLine();

            switch (input.toLowerCase())
            {
                case "fight":
                    if (this.getTargetPlayer().getMoney() < 5)
                    {
                        System.out.println("You're too poor to fight this lawsuit");
                    }
                    else
                    {
                        if (this.suitList.get(0).challenge(50, true))
                        {
                            this.suitList.remove(0);
                        }
                        this.getTargetPlayer().energyChange(-10);
                        this.getTargetPlayer().moneyChange(-5);
                    }
                break;

                case "settle":
                    if (this.getTargetPlayer().getMoney() < 10)
                    {
                        System.out.println("You have no money to settle this.");
                    }
                    else
                    {
                        this.getTargetPlayer().moneyChange(-10);
                        this.suitList.get(0).settle();
                        this.suitList.remove(0);
                        this.getTargetPlayer().energyChange(-10);
                    }
                break;

                default:
                    System.out.println("... that was not an option");
                break;
            }
            return;
        }

        //10% for cat emote if you haven't gotten one yet
        if (!this.usedCatEmote && (int) (Math.random() * 10) == 5)
        {
            System.out.println("Cheems: Happy National Cat Day!");
            System.out.println("I know it's a twitter holiday shhhh");
            System.out.println("Here, take this Cat emote that I bought earlier. Also srs chrismas is almost done right?");
            System.out.println("Also btw, chizu paradox is the hotseat person\n");

            //Does not check for whether inventory is full
            //This is intentional; Cat emotes are rare and unlocks a rare ending.
            this.catEmote.addToInventory();
            this.usedCatEmote = true;
        }
        else if ((int) (Math.random() * 10) == 5) //10% to get something
        {
            System.out.println(this.getFoundText());

            //We're not technically "destroying" the items in the backend when we use it
            //We're just taking it out of the inventory so it is technically "destroyed"
            //But we're still recycling the same object
            Items tempItem = this.getRandomItem();

            tempItem.addToInventory();
        }
        else
        {
            System.out.println("@" + this.generateUser() + ": " + this.getQuote());
        }
    }

    /**
     * Returns a random quote from static array Discord.discordGibberish.
     * Precondition: Discord.discordGibberish.length > 0
     * Postcondition: The array is not modified
     * @return a random quote from the array in form of String
     */
    private String getQuote()
    {
        return Discord.discordGibberish[(int) (Math.random() * Discord.discordGibberish.length)];
    }

    /**
     * Helper method that returns a random item from the array itemArr
     * Precondition: Discord.itemArr.length > 0
     * Postcondition: The array is not modified
     * @return a random item from this.itemArr
     */
    private Items getRandomItem()
    {
        return this.itemArr[(int) (Math.random() * this.itemArr.length)];
    }

    /**
     * Helper method that returns a random text in static array foundArr
     * Precondition: Discord.foundArr.length > 0
     * Postcondition: The array is not modified
     * @return a random String from Discord.foundArr
     */
    private String getFoundText()
    {
        return Discord.foundArr[(int) (Math.random() * Discord.foundArr.length)];
    }

    /**
     * Gets the number of lawsuits the player has
     * @return this.suitList.size()
     */
    public int suitNum()
    {
        return this.suitList.size();
    }

    /**
     * Calculates whether or not the player will get a lawsuit. If the RNGezus gods match, player gets a lawsuit
     * @param riskChance The player's risk chance
     *  @return The number of lawsuits the player has
     */
    public int suitCalc(int riskChance)
    {
        if ((int)(Math.random() * 100) <= riskChance)
        {
            this.addLawsuit();
        }

        return this.suitNum();
    }

    /**
     * Adds a lawsuit to the player.
     * Postcondition: Adds a random lawsuit of a random type to the arrayList of lawsuits
     */
    public void addLawsuit()
    {
        try
        {
            switch((int) Math.random() * 4)
            {
                case 0:
                    this.suitList.add(new Negligence(this.getTargetPlayer()));
                break;

                case 1:
                    this.suitList.add(new Defamation(this.getTargetPlayer()));
                break;

                case 2:
                    this.suitList.add(new Fraud(this.getTargetPlayer()));
                break;

                case 3:
                    CAD ceaseDesist = new CAD(this.getTargetPlayer());
                    this.suitList.add(ceaseDesist);
                    ceaseDesist.effect();
                break;
            }
        }
        catch(Exception err){}
    }

    /**
     * Completely removes all lawsuits from this.suitList.
     * Postcondition: this.suitList now represents a different arrayList
     */
    public void removeAllLawsuits()
    {
        this.suitList = new ArrayList<Lawsuits>();
    }

    /**
     * The upload command on Discord will allow you to upload code from srs bot right into here.
     * This is where you will test the code and recieve a console log.
     * Precondition: Target player's inventory is not full, and has a spot of null open
     * Postcondition: A console log is added to your inventory.
     * Postcondition: Changes this.pvg if the user already has the private key
     */
    public void upload()
    {
        if (this.getTargetPlayer().fetchProgram("AWS") == null)
        {
            System.out.println("Srs Bot is offline");
            return;
        }

        Jgrasp jgrasp = (Jgrasp)ProgramList.fetchAuthority("Jgrasp");
        
        //JSDOM error actually doesn't make Jgrasp buggy b/c it's not a "bug" 
        //and needed to progress to step 3
        if (jgrasp.getBuggy())
        {
            System.out.println("Exit Process 3: Bot Crashed while executing");
        }
        else
        {
            //33% chance to yeet a bug
            if ((int)(Math.random() * 3) == 2)
            {
                jgrasp.setBuggy(true);
            }
            else
            {
                try
                {
                    ConsoleLog log = new ConsoleLog(this.getTargetPlayer());

                    String str = "";

                    //If everything works
                    if (log.hackerIdx() == 3 || log.legitIdx() == 2)
                    {
                        str = "----------r/Christmas post!--------------\n"+
                        "It's christmas and I just made some hot chocolate!\n" +
                        "\n"+
                        "u                      w                       u";
                    }
                    else if (log.hackerIdx() == 2 && !this.pvg)
                    {
                        str = "You ran Srs Bot. Surprisingly, the bot is taking a bit long.\n" +
                        "Brute forcing.... 5%\n"+
                        "Brute forcing.... 46%\n"+
                        "Brute forcing.... 89%\n"+
                        "Brute forcing.... 99%\n"+
                        "Done.";

                        new PrivateKey(this.getTargetPlayer()).addToInventory();
                        this.pvg = true;
                    }
                    else if (log.legitIdx() == 1)
                    {
                        str = "You ran Srs Bot. Despite JSDOM being used. Nothing is loading.\n" +
                        "You might have to find a version of reddit without lazyloaders it seems.";
                    }
                    else
                    {
                        str = "You ran Srs Bot. The results come out in a console log.";
                    }

                    System.out.println(str);
                    log.addToInventory();
                }
                catch(Exception e)
                {
                    //e.printStackTrace();
                }
            }
        }
    }
}

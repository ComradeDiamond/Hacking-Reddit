package objects.programs;
import gameNav.Player;
import objects.items.*;
import gameNav.ProgramList;

/**
 * Reddit class represents the main place you want to hack and get the Christmas photos from.
 * It also features some nice posts by your other subreddits.
 * You also have the option to comment.
 * @author Justin
 * @since 12/23/20
 * @category objects/JustinWare
 */
public class Reddit extends Programs
{
    /**
     * An array that contains everything reddit post related
     */
    private RedditPost[] redditArr;

    /**
     * Stores an array of reddit awards that could be given out in markov scenarios
     */
    private Items[] redditAwards;

    /**
     * Reddit store items that could be obtained
     */
    private Items[] redditStoreItems;

    /**
     * Keeps track of whether or not you posted in r/Christmas
     */
    private boolean postedChristmas;

    /**
     * Constructs a reddit object, or basically the reddit app you're going to use
     * Postcondition: Initialized redditArr, redditAwards, and redditStoreItems
     * @param targetPlayer The target *snore* player inside the *snore* main game. 
        * How many times are we copying and pasting this?
     * @throws Exception if Reddit.txt does not exist
     */
    public Reddit(Player targetPlayer) throws Exception
    {
        super("Reddit", targetPlayer);

        //Reddit user of the post is different each game.
        //For now, we'll construct donuts until we know what to give the players
        //The harder it is to guess the keyword, the better the prize
        this.redditArr = new RedditPost[]{
            new RedditPost("r/DreamWasTaken", this.generateUser(), "Dream did not cheat, and here's why!", "agree", new DreamWaterBottle(targetPlayer)),
            new RedditPost("r/DreamWasTaken", this.generateUser(), "Dream on the way to win 10 lotteries in a row", "liar", new PigStep(targetPlayer)),
            new RedditPost("r/DreamWasTaken", this.generateUser(), "Made a new fan art for dream uwu Hope you guys like this", "nice", new Upvote(targetPlayer)),
            new RedditPost("r/DreamWasTaken", this.generateUser(), "This sub the past few days: \nDream cheated, dream didn't cheat, dream cheated, pls move on", "did not cheat", new Dream(targetPlayer)),
            new RedditPost("r/DreamWasTaken", this.generateUser(), "BREAKING NEWS: DREAM'S ASTROPHYSICIST\nCONCLUDED THAT JAVA IS VERY BUGGY AND DREAM DID NOT CHEAT", "what", new Dream(targetPlayer)),
            new RedditPost("r/DreamWasTaken", this.generateUser(), "Antfrost this manhunt: You activated my trap card", "rigged", new Donut(targetPlayer)),
            new RedditPost("r/DreamWasTaken", this.generateUser(), "Why is dream merch so expensive? He charges $50 for a water bottle", "cost", new DreamWaterBottle(targetPlayer)),
            new RedditPost("r/DreamWasTaken", this.generateUser(), "r/statistics claim Dream's Astrophysicist PHD is fake!", "wrong", new BookOfDarkSecrets(targetPlayer)),
            new RedditPost("r/Chrismas", this.generateUser(), "It has been a rough year, but we made it! Christmas tree!", "looks", new SilverAward(targetPlayer)),
            new RedditPost("r/Christmas", this.generateUser(), "It's Christmas season! We're blasting Mariah Carey in the house!", "like", new Gatorade(targetPlayer)),
            new RedditPost("r/Christmas", this.generateUser(), "Dream the dog under a log under a Christmas tree!", "cute", new JerryMagic(targetPlayer)),
            new RedditPost("r/Christmas", this.generateUser(), "I was alone for Christmas, but my coworker gave me alot of leftovers owo", "yum", new Chocolate(targetPlayer)),
            new RedditPost("r/Christmas", this.generateUser(), "Today I had some fun time in the kitchen baking cookies and making cand canes!", "wow", new JerryMagic(targetPlayer)),
            new RedditPost("r/Christmas", this.generateUser(), "My little desk tree, since I'm too poor to afford a huge one", "good", new Chocolate(targetPlayer)),
            new RedditPost("r/BTHS", this.generateUser(), "Rate my teachers this year please\nMclean, Smith, Lewis, Heinz, Carey", "bad", new BookOfDarkSecrets(targetPlayer)),
            new RedditPost("r/BTHS", this.generateUser(), "Hey a 2025 here, I was wondering what is the BTHS cutoff last year.\nWill I make it in with a 498?", "no", new SGOSticker(targetPlayer)),
            new RedditPost("r/BTHS", this.generateUser(), "So guys I'm a bit undecided on majors next year. Is LAS a good major because I heard it's really big", "no", new SGOSticker(targetPlayer)),
            new RedditPost("r/BTHS", this.generateUser(), "QUESTIONSSSSS\nAre APs mandatory in Brooklyn Tech?", "yes", new Upvote(targetPlayer)),
            new RedditPost("r/BTHS", this.generateUser(), "Hi I'm a sophmore. What is the best major in BTHS?\n:( They gave us no major selection material", "software", new Donut(targetPlayer)),
            new RedditPost("r/BTHS", "cheems12", "I made Brooklyn Tech 2077", "cool", new POS(targetPlayer)),
            new RedditPost("r/BTHS", this.generateUser(), "In light of the cancelation of Youtube Rewind 2020, I made BTHS Rewind 2020!", "lol", new BTHSShirt(targetPlayer)),
            new RedditPost("r/BTHS", this.generateUser(), "I heard there are many rumors of majors. I'm about to select mine in a few months. What's the worst major out there?", "las", new JuryNullification(targetPlayer)),
            new RedditPost("r/Minecraft", this.generateUser(), "owo Axelots will spin on lily pads!", "cute", new PigStep(targetPlayer)),
            new RedditPost("r/Minecraft", this.generateUser(), "I made a phantom out of paper! What do you think?", "scary", new Donut(targetPlayer)),
            new RedditPost("r/Minecraft", this.generateUser(), "I just discovered bungee jumping! I love Minecraft physics!", "how", new ElectricShock(targetPlayer)),
            new RedditPost("r/Minecraft", this.generateUser(), "I 3D printed a glowstone block at light level 15!", "shiny", new ChargeMaster(targetPlayer)),
            new RedditPost("r/Minecraft", this.generateUser(), "The plushies were sold out literally EVERYWHERE, and so my little sister didn’t get the bee she wanted for Christmas. I made her one by hand to cheer her up.", "nice", new Chocolate(targetPlayer)),
            new RedditPost("r/Programming", this.generateUser(), "Syntax Error: missing ; at like 56", "bruh", new EmergencyUnlock(targetPlayer)),
            new RedditPost("r/Programming", this.generateUser(), "Tired of your code not compiling? Just smash your computer!", "lol", new EmergencyUnlock(targetPlayer)),
            new RedditPost("r/Programming", this.generateUser(), "The ins and outs of onion routing\nThis explains why if you use bitcoins and fakeIds, you become untraceable!", "wow", new ElectricShock(targetPlayer))
        };

        this.redditAwards = new Items[] {
            new Upvote(targetPlayer),
            new SilverAward(targetPlayer),
            new GoldAward(targetPlayer),
        };

        this.redditStoreItems = new Items[] {
            new Donut(targetPlayer),
            new OldRedditLink(targetPlayer),
            new RainbowDash(targetPlayer),
            new Flashdrive(targetPlayer),
            new PigStep(targetPlayer),
            new POS(targetPlayer)
        };

        this.postedChristmas = false;
    }

    /**
     * Reddit observe allows the user to look at reddit posts and comment on them.
     * Depending on the RNG roll, you're interacting with a real, useful post, or a markov post.
     * Postcondition: If you comment with the right reddit post keyword, the prize associated will appear in your inventory
     */
    public void observe()
    {
        //25% to get a decent post
        if ((int) (Math.random() * 4) == 3)
        {
            RedditPost post = this.redditArr[(int) (Math.random() * this.redditArr.length)];

            System.out.println(post.getText());
            System.out.print("Leave a comment: ");
            
            String comment = this.getScanner().nextLine();

            if (post.matchesKeyword(comment))
            {
                System.out.println("A redditor liked your post so much they gave you something!");
                post.getPrize().addToInventory();
            }
            else
            {
                System.out.println("You got " + (int)(Math.random() * 100) + " upvotes!");
            }
        }
        else
        {
            RedditPost post = new RedditPost(this.redditAwards[(int) (Math.random() * this.redditAwards.length)]);

            System.out.println(post.getText());
            System.out.print("Leave a comment: ");
            
            String comment = this.getScanner().nextLine();

            if (post.matchesKeyword(comment))
            {
                System.out.println("A redditor liked your post so much they gave you an award!");
                post.getPrize().addToInventory();
            }
            else
            {
                System.out.println("You got " + (int)(Math.random() * 100) + " upvotes!");
            }
        }
    }

    /**
     * Uploading on reddit gives the user a bunch of karma.
     * The user decides what they want to upload and where they want to upload to!
     * Postcondition: If the user uploads to r/Christmas, a portion of stack overflow is completed
     * Postcondition: If the user has a rainbow table and posts about it, they get dark web access
     */
    public void upload()
    {
        System.out.println("What subreddit do you want to post in?");
        System.out.print("r/");
        String subreddit = this.getScanner().nextLine();
        System.out.print("Enter a post message: ");
        String txt = this.getScanner().nextLine();

        System.out.println("");
        System.out.println(new RedditPost(subreddit, "you", txt, null, null).getText());

        if (subreddit.equalsIgnoreCase("christmas"))
        {
            System.out.println("You got " + (int)(Math.random() * 50000) + " festive karma!");

            if (!this.postedChristmas)
            {
                this.postedChristmas = true;
                System.out.println("u/ChristmasMod: \"Hey, welcome to the Christmas subreddit! I would guide you through but it seems you're *familiar* with the place already!\"");
                System.out.println("\"Speaking of new, have you heard this subreddit is now compatible with the old reddit?\"");
                System.out.println("\"All you have to do is buy a Old Reddit Link from the reddit store for $100!\"");
            }
        }
        else if (txt.toLowerCase().contains("rainbow table") && this.getTargetPlayer().fetchItem("Rainbow Table") != null)
        {
            System.out.println("u/AnonymousWhale: \"Hey, do you mind if I take a look at the rainbow table? It looks interesting. \"");

            if (this.getScanner().nextLine().equalsIgnoreCase("no"))
            {
                String toOut = "u/AnonymousWhale: \"Hmm... this looks quite... fake.\n"+
                "You haven't been around here much, have you?\"";

                System.out.println(toOut);
                this.getScanner().nextLine();

                String newOut = "u/AnonymousWhale: \"Yeah, I've kind of thought so. This rainbow table is fake. You can't go hacking reddit with this.\n"+
                "Here, give me this rainbow table. I could use it. Meanwhile, you're going to need a [redacted] browser.\n" +
                "Hold on... yep. Done. Aight take this thing too, you'll need it.\n" +
                "Big brother is watching.\"\n";

                System.out.println(newOut);

                System.out.println("Somewhere, you felt that a path has opened with the string of numbers whale has given you.");
                System.out.println("Attached was an encrypted message: 'Trust me, I'm not an engineer like that song, but I commit crimes for a living.'");

                ProgramList.fetchAuthority("Silk Road").setEnabled(true);
                this.getTargetPlayer().removeInvItem("Rainbow Table");

                //Smh Java forces you to inherit exceptions >:(
                try 
                {
                    new Bitcoin(this.getTargetPlayer()).addToInventory();
                } 
                catch (Exception e) 
                {
                    //System.out.println("Something went wrong.... uh");
                }
            }
        }
        else
        {
            System.out.println("You got " + (int)(Math.random() * 10000 - 9000) + " karma.");
        }
    }

    /**
     * Returns whether the player has posted in r/Christmas
     * @return this.postedChristmas
     */
    public boolean getChristmas()
    {
        return this.postedChristmas;
    }

    /**
     * Buy command - allows you to buy a random reddit item.
     * The reddit items are a few things that could be awarded via comments.
     * The trick is the user won't know the cost of the items if they buy it this way because these are good items.
     * Precondition: TargetPlayer money is >= the item cost
     * Precondition: Your inventory is not full
     * Postcondition: The item is added to your inventory.
     * Postcondition: Your risk stat increases by 3
     * @see SilkRoad.prototype.shop() because they're the same thing
     */
    public void buy(String itemName)
    {
        Items requestedItem = null;

        for (Items item : this.redditStoreItems)
        {
            if (item.getName().equalsIgnoreCase(itemName))
            {
                requestedItem = item;
                break;
            }
        }

        //If item does not exist, yell at the player
        if (requestedItem == null)
        {
            System.out.println("The item does not exist...");
            return;
        }

        //If the player is broke, yell at the player
        if (this.getTargetPlayer().getMoney() < requestedItem.getCost())
        {
            System.out.println("You don't have sufficient cash.");
            return;
        }

        System.out.println("Purchased!");
        requestedItem.addToInventory();
        this.getTargetPlayer().moneyChange(-1 * requestedItem.getCost());

        this.getTargetPlayer().changeRiskChance(3);
    }
}

package objects.items;

/**
 * NOT A JUSTINWARE, AND NOT SOMETHING THE PLAYER CAN USE
 * The reddit comment class is a wrapper class for all things reddit post
 * @author Justin
 * @since 12/29/20
 * @category objects/Reddit helper
 */
public class RedditPost 
{
    /**
     * Reddit post markov that contains a noun to pick from
     */
    private static String[] noun = {
        "My mom",
        "My cat",
        "I",
        "My sister",
        "My dog",
        "My boss",
        "My girlfriend",
        "My boyfriend",
        "Dream"
    };

    /**
     * Reddit post markov that contains a verb to pick from
     */
    private static String[] verb = {
        "ate",
        "built",
        "played with",
        "made",
        "baked",
        "vlogged",
        "took a photo of",
        "spied on",
        "smashed",
        "cleaned up",
        "burnt",
        "washed",
        "memed on",
        "slept on",
        "beat"
    };

    /**
     * Reddit post markov that contains an object to pick from
     */
    private static String[] object = {
        "my neighbor",
        "my children",
        "a cake",
        "sans undertale",
        "a cup of hot cocoa",
        "some cup noodles",
        "a car",
        "a pasta al dente",
        "an egg",
        "my house",
        "my dog",
        "a christmas tree",
        "a cup of eggnog",
        "a present, but it's a cake",
        "a shoe cake",
        "a tea cake",
        "a couch",
        "a new bed",
        "a fedEx worker",
        "a fedEx package",
        "the latest video game level",
        "my new nitendo switch",
        "a present",
        "a visa gift card",
        "my family",
        "a new Mercedez Benz",
        "a gingerbread house",
        "a gingerbread man",
        "a candy cane",
        "a turkey with some garlic and olive oil",
        "a yoga mat"
    };

    /**
     * Reddit post markov that contains the sendoff "ask" thing
     */
    private static String[] ask = {
        "What do you think?",
        "Ask me anything!",
        "How does it look?",
        "",
        "",
        "Please give me a star.",
        "I'm pretty proud of that.",
        "And this was my first attempt at it!",
        "#ChristmasSpirit"
    };

    /**
     * The prize item the user will get if they comment the correct thing.
     */
    private Items prize;

    /**
     * The content of the reddit post.
     */
    private String text;

    /**
     * The keyword to look for in the user comment to obtain the prize
     */
    private String keyword;

    /**
     * The length of the keyword comment for the user to obtain the prize
     */
    private int keywordLength;

    /**
     * Constructs a reddit post object that is subject to markov
     * Postcondition: keyword is not modified. keywordLength is set to a random int between 3-10
     * @param prize The prize to give the user if they get keyword correct
     */
    public RedditPost(Items prize)
    {
        String markovText = "Anonymous posted in r/aDayInMyLife: \n ----------------------"+
        "--------------------- \n" +
        RedditPost.noun[RedditPost.grn(noun.length)] + " " +
        RedditPost.verb[RedditPost.grn(RedditPost.verb.length)] + " " +
        RedditPost.object[RedditPost.grn(RedditPost.object.length)] + "! " +
        RedditPost.ask[RedditPost.grn(RedditPost.ask.length)] + "\n" +
        "-------------------------------------------";

        this.text = markovText;
        this.prize = prize;
        
        this.keywordLength = (int) (Math.random() * 8 + 3);
    }

    /**
     * Constructs a custom reddit post object.
     * This reddit post object will be used when you observe on reddit.
     * Precondition: keyword is in lowercase
     * Postcondition: keywordLength is not modified
     * @param subReddit The subreddit the post is in
     * @param user The username of the person that made the post
     * @param text The text of the reddit post
     * @param keyword The keyword of the reddit post that will trigger a prize
     * @param prize The prize of the reddit post!
     */
    public RedditPost(String subReddit, String user, String text, String keyword, Items prize)
    {
        String txt = "u/" + user + " posted in " + subReddit +
        "\n-------------------------------------------\n" +
        text + "\n" + "-------------------------------------------";

        this.text = txt;
        this.keyword = keyword;
        this.prize = prize;
    }

    /**
     * Gets the text of the reddit post
     * @return this.text;
     */
    public String getText()
    {
        return this.text;
    }

    /**
     * Returns whether the user input contains keyword if keyword is not null.
     * Otherwise, returns whether the user's input has as many characters as keywordLength's value.
     * This method is case insensitive.
     * Precondition: this.keyword is in lowercase
     * @param userInput The user input to calculate on
     * @return whether the user's input contains keywords, or has length like keywordLength
     */
    public boolean matchesKeyword(String userInput)
    {
        if (this.keyword != null)
        {
            return userInput.toLowerCase().contains(this.keyword);
        }
        
        return userInput.length() == this.keywordLength;
    }

    /**
     * Returns the prize that comes attached with the reddit comment is a keyword / keywordLength
        matches.
     * @return this.prize
     */
    public Items getPrize()
    {
        return this.prize;
    }

    /**
     * Helper method to retrieve a random number between 0 and length, inclusive.
     * Grn stands for get random number
     * @param length Preferably, the length of the array
     * @return A random number between 0 and length
     */
    private static int grn(int length)
    {
        return (int) (Math.random() * length);
    }
}

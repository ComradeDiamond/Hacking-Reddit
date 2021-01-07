package objects.programs;

import gameNav.Player;

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
     * Constructs a BTHS Data Archive object.
     * Postcondition: A new BTHS Data Archive object is created and NOT ENABLED
     * @param targetPlayer The main player inside the game you're playing
     * @throws Exception if BTHSDataArchive.txt does not exist
     */
    public BTHSDataArchive(Player targetPlayer) throws Exception
    {
        super("BTHS Data Archive", targetPlayer, false);
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
     * Postcondition: Some items may be given to the player if they use drip()
     */
    public void drip()
    {

    }
}

package objects.items;

import gameNav.Player;

/**
 * Reddit Private Key - it's the encryption key that would allow user to edit reddit.
 * This is obtained by running Srs Bot on discord
 * @author Justin
 * @since 1/11/21
 * @category objects/JustinWare
 */
public class PrivateKey extends Items
{
    /**
     * Changes to reddit TOS, purely cosmetic.
     */
    private String tosChanges;

    /**
     * Changes to subreddit moderation, purely cosmetic
     */
    private String smd;

    /**
     * Changes to the robot.txt, purely cosmetic
     */
    private String robotChange;

    /**
     * Constructs a reddit private key object
     * Postcondition: Initializes all attributes to empty Strings.
     * Postcondition: The private key is set to unconsumable.
     * @param targetPlayer The main player inside the game
     * @throws Exception if PrivateKey.txt does not exist
     */
    public PrivateKey(Player targetPlayer) throws Exception
    {
        super("Private Key", targetPlayer, false);
        this.tosChanges = "";
        this.smd = "";
        this.robotChange = "";
    }
    
    /**
     * Uses the reddit private key object and will allow the user to access the reddit panel!
     * It's a bit repetitive but I didn't want to make more classes.
     * Precondition: The player has reddit open.
     * Precondition: The player has 1 inventory slot open.
     * Postcondition: Player's risk increases by 1.
     * Postcondition: If the user changes the Robot.txt's age to <18 for an API, user applys for an API and gets an API key.
     * Postcondition: If the player changes Robot.txt age to <18, this is set to consuamble.
     */
    public void use()
    {
        if (this.getTargetPlayer().getCurrentProgram().getName().equals("Reddit"))
        {
            String str = "---------Reddit Panel----------\n"+
            "> Terms of Service\n" +
            "> Robot.txt\n" +
            "> Subreddit Moderation\n" +
            "-------------------------------";

            System.out.println(str);
            System.out.print("Select one to access: ");

            String resp = this.getScanner().nextLine();

            System.out.print("Read or change: ");
            String roc = this.getScanner().nextLine();

            switch(resp.toLowerCase())
            {
                case "terms of service":
                    if (roc.equalsIgnoreCase("change"))
                    {
                        System.out.println("Insert your change: ");
                        this.tosChanges = this.getScanner().nextLine();
                    }
                    else
                    {
                        String a6 = "Hello, redditors and people of the Internet! This Reddit User Agreement (“Terms”) applies to your access to and use of the websites, mobile apps, widgets, APIs, emails, and other online products and services (collectively, the “Services”) provided by Reddit, Inc. (“Reddit,” “we,” “us,” or “our”).\nRemember Reddit is for fun and is intended to be a place for your entertainment, but we still need some basic rules. By accessing or using our Services, you agree to be bound by these Terms. If you do not agree to these Terms, you may not access or use our Services.\nPlease take a look at Reddit’s Privacy Policy too—it explains how and why we collect, use, and share information about you when you access or use our Services.";
                        System.out.println(a6 + "\n" + this.tosChanges);
                    }
                break;

                case "robot.txt":
                    if (roc.equalsIgnoreCase("change"))
                    {
                        System.out.println("Insert your change: ");
                        String a7 = this.getScanner().nextLine().toLowerCase();

                        //If the change means the age is set to less than 18, you get an API key
                        if (a7.contains("age") && a7.contains("18"))
                        {
                            System.out.println("---\nYou changed the reddit API age to less than 18 years old.");
                            System.out.println("You now qualify for an API application.");
                            System.out.println("After all the dangerous work hacking into a multinational corporation, you could finally apply on a ... oh wait, it's a google form for an API application.");
                            System.out.println("After expediting this process and some blackmailing (we won't get into that lol), the form is approved!");

                            this.setConsumable(true);
                            try
                            {
                                new APIKey(this.getTargetPlayer()).addToInventory();
                            }
                            catch(Exception e){}
                        }
                        else
                        {
                            this.robotChange = a7;
                        }
                    }
                    else
                    {
                        System.out.println("All bot applications must go through a rigiourous process of 2 weeks' worth of investigations whereas the applicant must be over 18 years old. All applications from applicants consisting of less than 18 years of age will automatically be denied, especially the editor of Srs Bot. We repeat - there is no exception to this rule - all API applications from any applicant less than 18 will automatically be rejected. Should this rule every be changed (we doubt it won't), all API applicants less than the age of 18 will automatically be eligible for an API key." + this.robotChange);
                    }
                break;

                case "subreddit moderation":
                    if (roc.equalsIgnoreCase("change"))
                    {
                        System.out.println("Insert your change: ");
                        this.smd = this.getScanner().nextLine();
                    }
                    else
                    {
                        String a8 = "Moderating a subreddit is an unofficial, voluntary position that may be available to users of the Services. We are not responsible for actions taken by the moderators. We reserve the right to revoke or limit a user’s ability to moderate at any time and for any reason or no reason, including for a breach of these Terms.";
                        System.out.println(a8 + "\n" + this.smd);
                    }
                break;

                default:
                    System.out.println("That does not exist.");
                break;
            }

            this.getTargetPlayer().changeSus(1);
        }
    }
}

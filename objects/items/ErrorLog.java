package objects.items;

import gameNav.Player;
import gameNav.ProgramList;
import objects.programs.Programs;
import objects.programs.Discord;

/**
 * Error log is given to the player when they try to use Observable Code in jgrasp.
 * This is the result of not having JSDOM
 * @author Justin
 * @since 1/9/21
 * @category objects/JustinWare
 */
public class ErrorLog extends Items
{
    /**
     * Constructs an error log object.
     * Postcondition: ErrorLog is set to unconsumable for now
     * @param targetPlayer The main player inside the game
     * @throws Exception if ErrorLog.txt does not exist
     */
    public ErrorLog(Player targetPlayer) throws Exception
    {
        super("Error Log", targetPlayer, false);
    }

    /**
     * If the player is inside Discord, there is a chance to trigger cat's response.
     * If the player is in stack overflow, you get slapped with a lawsuit for illegal activities.
     * Postcondition: User gets a lawsuit OR the user gets JSDOM
     * Postcondition: If the player is in neither of the apps, increase risk by 5 and do nothing
     * Postcondition: If the player is inside discord and cat answers, set this to consumable
     */
    public void use()
    {
        Programs currProg = this.getTargetPlayer().getCurrentProgram();

        if (currProg.getName().equals("Discord"))
        {
            //40% chance
            if ((int)(Math.random() * 10) < 4)
            {
                this.cat();
            }
            else
            {
                System.out.println("But nobody came.");
                //Undertale be like
            }
        }
        else if (currProg.getName().equals("Stack Overflow"))
        {
            ((Discord)ProgramList.fetchAuthority("Discord")).addLawsuit();
            System.out.println("Your code and web scraping via bypassing the API has risen serious suspicion from the Stack Overflow community.");
            System.out.println("A user files a lawsuit against you.");
        }
        else
        {
            this.getTargetPlayer().changeRiskChance(15);
            System.out.println("You can't use an error log here, but youe error log has attracted suspicion");
        }
    }

    /**
     * Private helper method for narrating Cat's dialogue.
     * If this phase happens, the user will ALWAYS get JSDOM.
     * Postcondition: Sets this to consumable
     * Postcondition: Adds a JSDOM object to the user's inventory
     */
    private void cat()
    {
        String[] catTexts = new String[]{
            "what is that thingy :illegal:",
            ":illegal: :illegal: :illegal: \nCat: Don't you have an API",
            "🙄",
            "🤔",
            "here lemme look at the error log",
            "why are you running html stuff in your ide smh the method doesn't even exist",
            "🙄 ok",
            "have you used a library",
            "here use this 🤦‍♂️ https://www.npmjs.com/search?q=jsdom \n" +
            " Carl Bot: <You have been warned by Cat#1223 in BTHS Discord. Reason: \"Illegal Activities\""
        };

        for (String str : catTexts)
        {
            System.out.println("Cat: " + str);
            this.getScanner().nextLine();
        }

        try
        {
            new JSDOM(this.getTargetPlayer()).addToInventory();
        }
        catch(Exception e)
        {
            return;
        }
    }
}

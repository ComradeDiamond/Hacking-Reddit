package objects.items;

import gameNav.Player;
import objects.programs.Discord;

/**
 * Cat emote - used to trigger cat's convo with you.
 * @author Justin
 * @since 12/29/20
 * @category objects/JustinWare
 */
public class CatEmote extends Items
{
    /**
     * The fake rainbowTable the player will obtain from using the cat emote.
     */
    private FakeRainbowTable rainbowTable;

    /**
     * Creates an instance of CatEmote. 
     * Postcondition: this.consumable is set to false. Initializes the rainbowTable
     * @param targetPlayer The main player inside the game you're playing as
     * @throws Exception if CatEmote.txt does not exist or if RainbowTable.txt does not exist
     */
    public CatEmote(Player targetPlayer) throws Exception
    {
        super("Cat Emote", targetPlayer, false);

        this.rainbowTable = new FakeRainbowTable(targetPlayer);
    }

    /**
     * Uses the item.
     * This will prompt cat to have a conversation with the player.
     * If successful, the player gets a rainbow table.
     * If not, Cat calls you illegal
     * Postcondition: This item is taken out of the player's inventory.
     * Postcondition: Used Cat Emote set to true
     */
    public void use()
    {
        if (!this.getTargetPlayer().getCurrentProgram().getName().equalsIgnoreCase("Discord"))
        {
            System.out.println("Weirdly, the emote can't be used here.");
            return;
        }
        
        String[] catIntro = {
            "uwu I was summoned",
            "You activated my trap card",
            "Carl Bot showed that you pinged me",
            "hello uwu"
        };

        System.out.println("Cat: " + catIntro[(int) (Math.random() * catIntro.length)]);

        System.out.println("Are you still web scraping off google translate?\n");
        String resp = this.getScanner().nextLine();

        if (resp.equalsIgnoreCase("no"))
        {
            String txt = "Cat: Finally uwu you decided to use an API instead of illegal stuff" +
            "\nI've been busy lately you know and uh I've been working on smth" + 
            "\nLook at this! It's a rainbow table for IT class uwu." +
            "\nIt doesn't look the nicest but it works uwu\n";

            System.out.println(txt);
            this.rainbowTable.addToInventory();
            ((Discord)this.getTargetPlayer().getCurrentProgram()).setUsedCatEmote(true);

            //Allows the cat emote to finally be consumed
            this.setConsumable(true);
        }
        else
        {
            System.out.println("illegal smh my head");
        }
    }
}

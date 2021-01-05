package objects.commands;

import gameNav.Player;

/**
 * Check command - returns an assessment of the player's stats
 * @author Justin
 * @since 12/19/20
 * @category objects/JustinWare
 */
public class Check extends Commands
{
    /**
     * Constructs a check object
     * @param targetPlayer The main player inside the game the command will act on
     * @throws Exception if Check.txt does not exist
     */
    public Check(Player targetPlayer) throws Exception
    {
        super("Check", targetPlayer);
    }

    /**
     * Executes the check command <br />
     * Postcondition: Prints out an log of the player's stats... does java use emotes?
     * @param command The command array
     * @param text The rest of the text... It's really just here because java is dumb
     */
    public void execute(String[] command, String text)
    {
        String leString = "Player Stats \n---------------------\n" +
        "⚡ Energy - " + this.getTargetPlayer().getEnergy() + "\n" + 
        "🔋 Battery - " + this.getTargetPlayer().getBattery() + "\n" +
        "🤑 Money - " + this.getTargetPlayer().getMoney() + "\n" + 
        "🕵️‍♂️ Risk Chance - " + this.getTargetPlayer().getRiskChance() + "% \n" + 
        "---------------------";

        System.out.println(leString);
    }
}

package objects.commands;

import gameNav.Player;

/**
 * Shop command - allows you to shop in certain programs
 * @author Justin 
 * @since 1/5/21
 * @category objects/JustinWare
 */
public class Shop extends Commands
{
    /**
     * Constructs a shop command
     * @param targetPlayer The main player inside the game
     * @throws Exception if Shop.txt does not exist
     */
    public Shop(Player targetPlayer) throws Exception
    {
        super("Shop", targetPlayer);
    }

    /**
     * Uses the shop command.
     * Precondition: Text should be the name of a valid shop item
     * Postcondition: Triggers the buy method in the current program.
     * The burden of printing what went wrong falls to command of the programs
     * @param commands The command array parsed by CommandWord
     * @param text The rest of the command as a string without the actual command
     */
    public void execute(String[] commands, String text)
    {
        this.getTargetPlayer().getCurrentProgram().buy(text);
    }
}

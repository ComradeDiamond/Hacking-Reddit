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
     * Postcondition: Triggers the buy method in the current program.
     * The burden of printing what went wrong falls to command of the programs
     */
    public void use()
    {
        System.out.println("Insert name of item to buy: ");
        String itemName = this.getScanner().nextLine();
        
        this.getTargetPlayer().getCurrentProgram().buy(itemName);
    }
}

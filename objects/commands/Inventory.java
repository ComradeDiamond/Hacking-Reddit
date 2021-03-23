package objects.commands;
import gameNav.Player;

/**
 * Inventory Command - Takes an inventory of what you have lmao
 * @author Justin
 * @since 12/19/20
 * @category objects/JustinWare
 */
public class Inventory extends Commands
{
    /**
     * Constructs an inventory command object
     * @param targetPlayer The main player inside the game, like every other command
     * @throws Exception if Inventory.txt does not exist. Damn Justin how many times 
        is this going to repeat
     */
    public Inventory(Player targetPlayer) throws Exception
    {
        super("Inventory", targetPlayer);
    }

    /**
     * Executes the inventory command <br />
     * Postcondition: Prints out an inventory
     * @param command The command array
     * @param text The rest of the text... I don't know why it should not be "" tho
     */
    public void execute(String[] command, String text)
    {
        System.out.println(this.getTargetPlayer().returnInventory());
    }
}

package objects.commands;

import objects.items.*;
import gameNav.Player;

/**
 * Use command - It allows you to consume/use an item.
 * @author Justin
 * @since 12/28/20
 * @category objects/JustinWare
 */
public class Use extends Commands
{
    /**
     * Constructs a use command/object
     * @param targetPlayer The main player inside the game the item will affect
     * @throws Exception if Use.txt does not exist
     */
    public Use(Player targetPlayer) throws Exception
    {
        super("Use", targetPlayer);
    }

    /**
     * Executes the use command and uses and item.
     * Precondition: Text represents a well punctuated, formatted item that exists
        in the targetPlayer's inventory
     * Postcondition: The item used is taken out of the player's inventory if consumable.
     * Postcondition: The item (the instance that is) used is not destroyed and not mutated
     * @param commands The array of commands passed by CommandsArr
     * @param text The user input text, without the command in it.
        * Should contain the item name to be used, properly punctuated and spaced
     */
    public void execute(String[] commands, String text)
    {
        //For ease of access so we don't need to call this method 5x
        Player targetPlayer = this.getTargetPlayer();
        Items currItem = targetPlayer.fetchItem(text);

        if (currItem == null)
        {
            System.out.println("That item is not in your inventory.");
        }
        else
        {
            currItem.use();

            //If item is consumable, get rid of it in inv
            if (currItem.getConsumable())
            {
                targetPlayer.removeInvItem(text);
            }
        }
    }
}

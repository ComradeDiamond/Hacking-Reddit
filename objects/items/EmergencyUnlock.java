package objects.items;

import gameNav.Player;

/**
 * A BTD6 item what closes everything in your inventory.
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class EmergencyUnlock extends Items
{
    /**
     * Constructs and emergency unlock object
     * @param targetPlayer The main player inside the game
     * @throws Exception if EmergencyUnlock.txt does not exist
     */
    public EmergencyUnlock(Player targetPlayer) throws Exception
    {
        super("Emergency Unlock", targetPlayer);
    }

    /**
     * Uses the emergency unlock item.
     */
    public void use()
    {
        System.out.println("You closed all programs in an emergency");
        this.getTargetPlayer().closeAllPrograms();
    }
}

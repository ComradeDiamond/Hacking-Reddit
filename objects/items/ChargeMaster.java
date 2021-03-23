package objects.items;

import gameNav.Player;

/**
 * A chargemaster item that allows you to get more batteries
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class ChargeMaster extends Items
{
    /**
     * Constructs a chargeMaster object
     * @param targetPlayer The main player inside the game
     * @throws Exception if ChargeMaster.txt does not exist
     */
    public ChargeMaster(Player targetPlayer) throws Exception
    {
        super("Charge Master", targetPlayer, true, 10);
    }

    /**
     * Uses the charge master item.
     * Postcondition: You get a random amount of batteries from 5-10
     */
    public void use()
    {
        System.out.println("You used the charge master. Your computer gained some batteries.");
        this.getTargetPlayer().batteryChange((int)(Math.random() * 5 + 5));
    }
}

package objects.items;

import gameNav.Player;

/**
 * A flashdrive that converts money into batteries
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class Flashdrive extends Items
{
    /**
     * Constructs a flashdrive object
     * @param targetPlayer The main player inside the game
     * @throws Exception if Flashdrive.txt does not exist
     */
    public Flashdrive(Player targetPlayer) throws Exception
    {
        super("Flashdrive", targetPlayer, true, 10);
    }

    /**
     * Uses the flashdrive object.
     * Postcondition: Converts 10% of your $ into batteries, rounded down.
     * Postcondition: You're now broke.
     */
    public void use()
    {
        System.out.println("You spent some money to charge your laptop.");
        System.out.println("The flashdrive from Industry City is now powering your laptop!.");
        System.out.println("And all your money is withdrawn from your bank account.");

        int money = this.getTargetPlayer().getMoney();
        this.getTargetPlayer().moneyChange(-1 * money);
        this.getTargetPlayer().batteryChange(money / 10);
    }
}

package objects.items;

import gameNav.Player;

/**
 * Dank memer item that gives you a burst of coins.
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class CoinBomb extends Items
{
    /**
     * Constructs a coin bomb object
     * @param targetPlayer The main player inside the game
     * @throws Exception if CoinBomb.txt does not exist
     */
    public CoinBomb(Player targetPlayer) throws Exception
    {
        super("Coin Bomb", targetPlayer);
    }

    /**
     * Uses the coin bomb item.
     * Postcondition: The player gets a random # of coins between 0 and 20.
     */
    public void use()
    {
        int random = (int)(Math.random() * 21);
        System.out.println("You launched a coin bomb! It exploded with " + random + " coins!");
        this.getTargetPlayer().moneyChange(random);
    }
}

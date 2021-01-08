package objects.items;

import gameNav.Player;

/**
 * Password Cracker item.
 * This is used to allow jgrasp to brute force the rainbow algorithm.
 * @author Justin
 * @since 1/7/21
 * @category objects/JustinWare
 */
public class PasswordCracker extends Items
{
    /**
     * Constructs a Password Cracker object
     * @param targetPlayer The main player inside the game
     * @throws Exception if PasswordCracker.txt does not exist
     */
    public PasswordCracker(Player targetPlayer) throws Exception
    {
        super("Password Cracker", targetPlayer);
    }
}

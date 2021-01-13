package objects.items;

import gameNav.Player;

/**
 * A secret Dream SMP item speculated to be able to resurrect certain things.
 * @author Justin
 * @since 1/13/21
 * @category objects/JustinWare
 */
public class BookOfDarkSecrets extends Items
{
    /**
     * Constructs a Book of Dark Secrets object
     * @param targetPlayer The main player inside the game
     * @throws Exception if BookOfDarkSecrets.txt does not exist
     */
    public BookOfDarkSecrets(Player targetPlayer) throws Exception
    {
        super("Book of Dark Secrets", targetPlayer);
    }

    /**
     * Uses the secret book.
     * When used, this would tell the player some dark secrets from a list.
     */
    public void use()
    {
        String[] itemsToSay = {
            "Theoretically, you only need to upload the last console log to win a legit ending",
            "All the recaptchas are exactly the same - not because I'm lazy, but because of the Unit 6 standards",
            "Have you heard of frivilous lawsuits? The jury can nullify it all.",
            "Nothing actually happens when you use sunglasses in the dark web. Stop being scared of that place."
        };

        System.out.println("You used the book of dark secrets.");
        System.out.println("-----\n" + itemsToSay[(int)(Math.random() * itemsToSay.length)]);
    }
}

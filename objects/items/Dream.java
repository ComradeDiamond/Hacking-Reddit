package objects.items;

import gameNav.Player;

/**
 * It's a cute dream figure. (He's very lucky)
 * @author Justin
 * @category objects/JustinWare
 * @since 12/29/20
 */
public class Dream extends Items
{
    /**
     * Constructs a dream object
     * @param targetPlayer The main player inside the game
     * @throws Exception if Dream.txt does not exist
     */
    public Dream(Player targetPlayer) throws Exception
    {
        super("Dream", targetPlayer);
    }

    /**
     * Uses the dream figurine. If the user types yes to all these questions, Dream will modify
        your game.
     * Some stats will only be modifiable by Dream
     * <div>Postconditions:</div>
     * <li>Battery set to 250</li>
     * <li>Energy set to 100</li>
     * <li>User gets $100</li>
     * <li>Sets risk chance to 0</li>
     * <li>Sets suspicion to 0</li>
     */
    public void use()
    {
        Player player = this.getTargetPlayer(); //Memoization? not rly probs

        System.out.println("This is a very powerful item and will likely shatter your game." +
        " This speedrun might be disqualified unless you find an astrophysicist phD.\n" + 
        "Do you want to continue?");

        if (!this.getScanner().nextLine().equalsIgnoreCase("yes"))
        {
            System.out.println("You yeet the Dream doll. The legit way is fun.");
            return;
        }

        System.out.println("Somewhere in Dream's Florida headquarters... Dream looks at this game from his twitch stream.");
        System.out.println("Looking at your progress in the game, the Java progammer decides to intervene.");
        System.out.println("Accessing c://Main.java.... 100%");
        System.out.println("Accessing c://gameNav/Game.java.... 100%");
        System.out.println("Initializing SQL in c://gameNav/Player.java.... 100%");
        System.out.println("Injecting SQL.... 100%");

        System.out.println("Changing battery and energy module.... 100%");
        player.batteryChange(250 - player.getBattery());
        player.energyChange(100 - player.getEnergy());

        System.out.println("Hacking the IRS.... 100%");
        player.moneyChange(100);

        System.out.println("Performing reconissance on WashingtonDC.... 100%");
        System.out.println("Accessing FBI Database.... 100%");
        System.out.println("Performing Buffer Overflow.... 100%");
        player.changeSus(-1 * player.getSus());;

        System.out.println("Taking down LAS Discord.... 100%");
        System.out.println("Erasing all court files.... 100%");
        System.out.println("Loading ransomware on everything related to law... 100%");
        player.changeRiskChance(-1 * player.getRiskChance());

        System.out.println("Everything has been set to where it should be ;)");
    }
}

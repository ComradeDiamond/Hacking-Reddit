package objects.items;

import gameNav.Player;
import gameNav.ProgramList;
import objects.programs.Discord;

/**
 * Riot Shield object, mitigates the discord riot system.
 * @author Justin
 * @since 1/9/21
 * @category objects/JustinWare
 */
public class RiotShield extends Items
{
    /**
     * Constructs a riot shield object
     * @param targetPlayer The main player inside the game
     * @throws Exception if RiotShield.txt does not exist
     */
    public RiotShield(Player targetPlayer) throws Exception
    {
        super("Riot Shield", targetPlayer, true, 200);
    }

    /**
     * Activates the riot shield and decreases the riot phase to 0
     * Postcondition: Discord riot phase is set to 0
     * Postcondition: Increases suspicion by 10
     */
    public void use()
    {
        ((Discord)ProgramList.fetchAuthority("Discord")).setRiotPhase(0);
        this.getTargetPlayer().changeSus(10);

        System.out.println("You deployed the riot shield.");
        System.out.println("Discord riot is completely stopped!");
        System.out.println("Due to the nature of the riot shield, your suspicion has increased");
    }
}

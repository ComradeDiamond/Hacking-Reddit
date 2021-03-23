package objects.items;

import gameNav.Player;
import objects.programs.Jgrasp;
//import objects.programs.Programs;

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
        super("Password Cracker", targetPlayer, false);
    }

    /**
     * Allows you to use the password cracker if the current program is Jgrasp.
     * Precondition: Current Program is jgrasp
     * Postcondition: Checks off the second step of hacker ending.
     * Postcondition: If the program is jgrasp, set consumable to true.
     * Postcondition: Crashes all your programs.
     * Postcondition: Sets jgrasp to buggy
     * Postcondition: Increases sus and risk
     */
    public void use()
    {        
        if (this.validJgrasp())
        {
            Jgrasp currProg = ((Jgrasp)this.getTargetPlayer().getCurrentProgram());

            this.setConsumable(true);
            currProg.hackerCheckoff(1);

            this.getTargetPlayer().closeAllPrograms();
            this.getTargetPlayer().changeSus(5);
            this.getTargetPlayer().changeRiskChance(10);
            this.getTargetPlayer().batteryChange(-15);
            
            currProg.setBuggy(true);
            System.out.println("*Exit 404 - your computer has crashed*");
        }
    }
}

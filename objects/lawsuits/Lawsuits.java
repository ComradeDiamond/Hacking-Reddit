package objects.lawsuits;

import gameNav.Player;
import objects.JustinWare;


/**
 * The general class for lawsuits and cease and desist orders.
 * And other useless LAS stuff.
 * Each lawsuit type would best be combated with a certain type of lawyer. 
 * With the right upgrades, lawyers would have a chance to defend you in court and even win $
 * @author Justin
 * @since 1/6/21
 * @category objects/JustinWare
 */
public class Lawsuits extends JustinWare
{
    /**
     * The main constructor for any lawsuits. This will construct a lawsuit object :P.
     * For the purposes of this game, lawsuits and seize and desist orders are mingled together
     * @param name The name of the lawsuit (or type of lawsuit)
     * @param targetPlayer The main player inside the game
     * @param description The main body text of the lawsuit that should be displayed.
     * @throws Exception if description does not exist
     */
    public Lawsuits(String name, Player targetPlayer, String description) throws Exception
    {
        super(name,"-------------------\n" + description + "\n-------------------", 
            targetPlayer, "Lawsuits");
    }

    /**
     * Effect method for polymorphism.
     * Basically this is what happens with cease and desist orders :P
     */
    public void effect()
    {
        return;
    }

    /**
     * This is what happens when you win the lawsuit in a landslide.
     * Postcondition: Depending on the RNG, you'll win either energy, $, batteries, or lower risk chance
     */
    public void victory()
    {
        Player targetPlayer = this.getTargetPlayer();
        String winningItem = "";
        switch ((int) (Math.random() * 4))
        {
            case 0: //Decrease risk by 10 - 25, or just decrease it to 0
                int rand = -1 * (int)(Math.random() * 15 + 10);

                if (targetPlayer.getRiskChance() - rand < 0)
                {
                    targetPlayer.changeRiskChance(-1 * targetPlayer.getRiskChance());
                }
                else
                {
                    targetPlayer.changeRiskChance(-1 * (int) (Math.random() * 15 + 10));
                }
                winningItem = "dropped some charges and decreased some risk";
            break;

            case 1: //20 - 50 bucks
                targetPlayer.moneyChange((int) (Math.random() * 30 + 20));
                winningItem = "rewarded you some money as settlement";
            break;

            case 2: //Get back 10 - 20 energy
                targetPlayer.energyChange((int) (Math.random() * 10 + 10));
                winningItem = "gave you some energy to continue";
            break;

            case 3: //Give back 10-20 battery
                targetPlayer.batteryChange((int) (Math.random() * 10 + 10));
                winningItem = "gave you some batteries to work with";
            break;

            default:
                winningItem = "did nothing";
            break;
        }

        System.out.println("The court has decided that defense had such a good argument that they "
         + winningItem + "!");
    }
}

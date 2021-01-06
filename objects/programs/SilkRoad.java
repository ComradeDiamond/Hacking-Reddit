package objects.programs;
import gameNav.Player;
import objects.items.*;

/**
 * The dark web auction house where you buy illegal stuff that's more illegal than what I'm doing rn.
 * Also the only place where you can say "would you like to buy my cocaine" without looking sus.
 * Sorry FBI agent looking at this
 * @author Justin
 * @category objects/JustinWare
 * @since 12/24/20
 */
public class SilkRoad extends Programs
{
    /**
     * Private attribute that stores all the items the black market can sell
     */
    private Items[] shopList;

    /**
     * Constructs a silk road program according to instructions provided by superclass.
     * Postcondition: Creates a silk road object that is NOT ENABLED.
     * Postcondition: Initializes shopList
     * @param targetPlayer The main player inside the game
     * @throws Exception if SilkRoad.txt does not exist
     */
    public SilkRoad(Player targetPlayer) throws Exception
    {
        super("Silk Road", targetPlayer, false);

        this.shopList = new Items[] {
            new CleansingFoam(targetPlayer)
        };
    }

    /**
     * Observe method. Will alert the user of any black market deals they might be interested in.
     * Precondition: this.shopList.length >= 1
     * Postcondition: Prints a fancy description of a random item in this.shopList
     */
    public void observe()
    {
        this.getTargetPlayer().changeSus(1);
        this.getTargetPlayer().changeRiskChance(10);

        Items currItem = this.shopList[(int) (Math.random() * this.shopList.length)];

        String str = "----------Dark Web Auction-----------\n" +
        "Item: " + currItem.getName() + "\n" + 
        "Cost: $" + currItem.getCost() + "\n" +
        "-----------------------------------";

        System.out.println(str);
    }
}

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

    /**
     * Buy command - allows you to buy a dark web item.
     * Precondition: itemName is an item name in this.shopList.
     * Precondition: TargetPlayer money is >= the item cost
     * Precondition: Your inventory is not full
     * Postcondition: The item is added to your inventory.
     * Postcondition: Your risk stat will increase by a random amount.
     * Postcondition: Your sus stat will increase by a random amt depending on whether you have bitcoin.
     */
    public void buy(String itemName)
    {
        Items requestedItem = null;

        for (Items item : this.shopList)
        {
            if (item.getName().equalsIgnoreCase(itemName))
            {
                requestedItem = item;
                break;
            }
        }

        //If item does not exist, yell at the player
        if (requestedItem == null)
        {
            System.out.println("The item does not exist...");
            return;
        }

        //If the player is broke, yell at the player
        if (this.getTargetPlayer().getMoney() < requestedItem.getCost())
        {
            System.out.println("You don't have sufficient cash.");
            return;
        }

        System.out.println("Purchase successful! Remember that due to the integrity of the dark web, we won't adjust for your inventory space.");
        requestedItem.addToInventory();
        this.getTargetPlayer().moneyChange(-1 * requestedItem.getCost());
    }

    /**
     * Drip method in the silk road.
     * This is meant to punish people that don't use help before reading a command.
     * It does absolutely nothing, but it serves as a good way to scare users.
     * It also fills their screen with spam
     */
    public void drip()
    {
        System.out.println("Weirdly, people think you're an FBI agent investigating here!");
        System.out.println("Your risk of lawsuits drastically increased!");
        System.out.println("Your suspicion drastically increased!");
        System.out.println("Your lawyers have been doxxed, and now their effectiveness rate has decline by 50%!");
        System.out.println("All your github progress have been reversed!");
        System.out.println("Your bitcoin priveledges have now been revoked.\n");

        for (int i=0; i<50; i++)
        {
            System.out.println("aaaaaaaaccccccccoooooooo");
        }
    }
}

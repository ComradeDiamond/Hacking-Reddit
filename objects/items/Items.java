package objects.items;

import java.nio.file.Files;
import java.nio.file.Path;

import gameNav.Player;
import objects.JustinWare;
import objects.programs.Jgrasp;
import objects.programs.Programs;

/**
 * The top class to creating items
 * @author Justin
 * @since 12/8/20
 * @category object/JustinWare
 */
public class Items extends JustinWare {

    /**
     * Returns whether the item is consumed upon use.
     * You use the item with the use command
     */
    private boolean consumable;

    /**
     * The cost of an item. 
     * Usually only used if the item is in the store.
     */
    private int cost;

    /**
     * Constructs an Item, reads the txt file in textLore to obtain description
     * Precondition: c:textLore/programs/<item>.txt has been created
     * Postcondition: Item object is constructed. Consumable is true and cost is zero.
     * @param name The item name
     * @param targetPlayer The player defined when the game has started, items will act on this obj
     * @throws Exception Will throw if description path is not found
     */
    public Items(String name, Player targetPlayer) throws Exception
    {
        super(name, Files.readString(Path.of("c:textLore/items/" + name.replaceAll(" ", "") + 
            ".txt")), targetPlayer, "Item");

        this.consumable = true;
        this.cost = 0;
    }

    /**
     * An alternative constructor that allows you to set whether the item is consumable or not
     * Precondition: c:textLore/programs/<item>.txt has been created
     * Postcondition: Item object is constructed. Cost is set to 0. Consuamble is set to isConsumable
     * @param name The item name
     * @param targetPlayer The player defined when the game has started, items will act on this obj
     * @param isConsumable Whether the item is consumed upon use
     * @throws Exception Will throw if description path is not found
     */
    public Items(String name, Player targetPlayer, boolean isConsumable) throws Exception
    {
        this(name, targetPlayer);

        this.consumable = isConsumable;
    }

    /**
     * An alternative constructor that allows you to set whether the item is consumable or not
     * This will ALSO allow you to set the Items cost.
     * Precondition: c:textLore/programs/<item>.txt has been created
     * Postcondition: Item object is constructed
     * @param name The item name
     * @param targetPlayer The player defined when the game has started, items will act on this obj
     * @param isConsumable Whether the item is consumed upon use
     * @param cost The item cost
     * @throws Exception Will throw if Items.txt does not exist
     */
    public Items(String name, Player targetPlayer, boolean isConsumable, int cost) throws Exception
    {
        this(name, targetPlayer, isConsumable);

        this.cost = cost;
    }

    /**
     * A fourth alternative constructor that allows you to copy an existing object as a new object.
     * The new object will be of the same class, same name, and same consumable value. 
     * However, it will get a new secondary scanner.
     * Precondition: other is successfully constructed
     * Postcondition: anything in the other object is unchanged
     * @param other The other object. Must be of type Items
     * @throws Exception if the description txt file for other does not exist
     */
    public Items(Items other) throws Exception
    {
        this(other.getName(), other.getTargetPlayer(), other.getConsumable(), other.getCost());
    }

    /**
     * Accessor method that returns whether the item is consumable or not
     * @return value of this.consumable
     */
    public boolean getConsumable()
    {
        return this.consumable;
    }

    /**
     * Mutator method to set whether an item is consumable or not
     * @param consumable The new value of this.consumable
     */
    public void setConsumable(boolean consumable)
    {
        this.consumable = consumable;
    }

    /**
     * Activates the ability of an item.
     * This is the default use method
     */
    public void use()
    {
        System.out.println("This item can't be used");
    }

    /**
     * Adds the item to the player's inventory.
     * Precondition: The player's inventory length < 8
     * Postcondition: The player's inventory has this item added to it
     */
    public void addToInventory()
    {
        if (this.getTargetPlayer().addInvItem(this))
        {
            System.out.println("A " + this.getName() + " has been added to your inv.");
        }
    }

    /**
     * Returns the cost of the item
     * @return this.cost
     */
    public int getCost()
    {
        return this.cost;
    }

    /**
     * A public, frequently used method to determine whether the current program is jgrasp.
     * Also determines whether jrasp is buggy.
     * The burden of error reporting what went wrong is the responsibility of this method
     * @return Whether or not the current program is jgrasp. If it is, return whether it is not buggy
     */
    public boolean validJgrasp()
    {
        Programs currProg = this.getTargetPlayer().getCurrentProgram();
        boolean isJgr = currProg.getName().equalsIgnoreCase("Jgrasp");

        if (!isJgr)
        {
            System.out.println("This program is not a Java IDE");
            return false;
        }

        boolean isBuggy = ((Jgrasp)currProg).getBuggy();
        
        if (isBuggy)
        {
            ((Jgrasp)currProg).throwException();
            return false;
        }

        return true;
    }
}

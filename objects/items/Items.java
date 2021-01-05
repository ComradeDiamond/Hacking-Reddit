package objects.items;
import java.nio.file.Files;
import java.nio.file.Path;
import gameNav.Player;
import objects.JustinWare;

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
     * Constructs an Item, reads the txt file in textLore to obtain description
     * Precondition: c:textLore/programs/<item>.txt has been created
     * Postcondition: Item object is constructed 
     * @param name The item name
     * @param targetPlayer The player defined when the game has started, items will act on this obj
     * @throws Exception Will throw if description path is not found
     */
    public Items(String name, Player targetPlayer) throws Exception
    {
        super(name, Files.readString(Path.of("c:textLore/items/" + name.replaceAll(" ", "") + 
            ".txt")), targetPlayer, "Item");

        this.consumable = true;
    }

    /**
     * An alternative constructor that allows you to set whether the item is consumable or not
     * Precondition: c:textLore/programs/<item>.txt has been created
     * Postcondition: Item object is constructed
     * @param name The item name
     * @param targetPlayer The player defined when the game has started, items will act on this obj
     * @param isConsumable Whether the item is consumed upon use
     * @throws Exception Will throw if description path is not found
     */
    public Items(String name, Player targetPlayer, boolean isConsumable) throws Exception
    {
        super(name, Files.readString(Path.of("c:textLore/items/" + name.replaceAll(" ", "") + 
            ".txt")), targetPlayer, "Item");

        this.consumable = isConsumable;
    }

    /**
     * A third alternative constructor that allows you to copy an existing object as a new object.
     * The new object will be of the same class, same name, and same consumable value. 
     * However, it will get a new secondary scanner.
     * Precondition: other is successfully constructed
     * Postcondition: anything in the other object is unchanged
     * @param other The other object. Must be of type Items
     * @throws Exception if the description txt file for other does not exist
     */
    public Items(Items other) throws Exception
    {
        super(other.getName(), other.getDescription(), other.getTargetPlayer(), "Item");
        this.consumable = other.getConsumable();
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
}

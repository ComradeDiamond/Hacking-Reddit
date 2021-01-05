package gameNav;
import objects.JustinWare;
import objects.items.*;
import objects.programs.*;

/**
 * The main class that stores everything related to the player
 * @since 12/01/20
 * @author Justin
 * @category gameNav
 */
public class Player {
    /**
     * The energy of the programmer you're playing as. 0 energy lands you in the burnout ending
     */
    private int energy;
    /**
     * $$$
     */
    private int money; 
    /**
     * The amount of battery your laptop still has. Apps use batteries.
     * When your battery count == 0, you lose
     */
    private int battery; 
    /**
     * Player inventory. Items are stored here.
     */
    private Items[] inventory;
    /**
     * All programs the player has open are stored here to be interacted with
     * When programs are open, they have different effects
     */
    private Programs[] programsOpen;
    /**
     * The current program the player is interacting with
     */
    private Programs currentProgram;
    /**
     * Determines the chances of lawsuits and legal action
     * Probably only relevant in the illegal method of winning the game
     */
    private int riskChance;
    /**
     * Determines suspicion changes.
     * Too much suspicion leads to the FBI ending.
     * Once accumulated, it's hard to get rid of suspicion.
     */
    private int sus;
    /**
     * Lmao did the player win?
     */
    private boolean win;
    /**
     * It's relatively useless as of now... it just keeps track if you used bitcoins
     */
    private boolean secureShopping;

    /**
     * Constructs a typical player that the user can play games with
     * @return new player object
     */
    public Player()
    {
        this.energy = 80;
        this.money = 0;
        this.battery = 100;
        this.inventory = new Items[8]; //Limits the inventory to 8 things
        this.riskChance = 0;
        this.currentProgram = null;
        this.programsOpen = new Programs[] {null, null, null, null, null, null, null, null};
        this.win = false;
    }

    /**
     * Changes the player's battery percentage
     * @param changeAmt amount to alter battery by
     */
    public void batteryChange(int changeAmt)
    {
        this.battery += changeAmt;
    }

    /**
     * Returns the battery amount
     * @return An int amount displaying battery
     */
    public int getBattery()
    {
        return this.battery;
    }

    /**
     * Returns the energy amount
     * @return this.energy value
     */
    public int getEnergy()
    {
        return this.energy;
    }

    /**
     * Change the player's energy percentage
     * @param changeAmt amount to alter energy by
     */
    public void energyChange(int changeAmt)
    {
        this.energy += changeAmt;
    }

    /**
     * Changes the player's money percentage
     * @param changeAmt amount to alter money by
     */
    public void moneyChange(int changeAmt)
    {
        this.money += changeAmt;
    }

    /**
     * Ok you're not actually getting money because I'm broke lmao
     * @return this.money as an int value
     */
    public int getMoney()
    {
        return this.money;
    }

    /**
     * Returns the number of programs the player has open. 
     * @return The number of programs in this.programsOpen that is not null
     */
    public int getNumPrograms()
    {
        int notNull = 0;

        for (Programs program : this.programsOpen)
        {
            if (program != null)
            {
                notNull++;
            }
        }

        return notNull;
    }

    /**
     * Helper method that appends an item to a JustinWare array <br />
     * Precondition: The modified item is a JustinWare. It should be designed to be JustinWare <br />
     * Postcondition: Returns whether the addition was successful or not
     * @param item The item to append to array
     * @param array The array to append item to
     * @param allowRepeats Whether or not to allow two JustinWares inside the array to be of the 
        same class 
     * @return Whether apppend operation was successful
     */
    private boolean appendToArr(JustinWare item, JustinWare[] array, boolean allowRepeats)
    {
        for (int i=0; i<array.length; i++)
        {
            if (array[i] != null && array[i].getClass() == item.getClass())
            {
                //Stops us from adding repeats
                if (!allowRepeats)
                {
                    return false;
                }
            }

            if (array[i] == null)
            {
                array[i] = item;
                return true;
            }
        }

        return false;
    }

    /**
     * Deletes an item from an array, if it exists
     * Precondition: The itemName matches the name of an item inside the array. Capitalization matters!
     * Postcondition: Shifts the array left to fill in the null spots
     * @param itemName The name of the item to delete
     * @param array The array to delete the item from
     * @return Whether the delete operation was successful
     */
    private boolean deleteFromArr(String itemName, JustinWare[] array)
    {
        boolean itemFound = false;

        for (int i=0; i<array.length; i++)
        {
            if (!itemFound)
            {
                if (array[i] != null && array[i].getName().equalsIgnoreCase(itemName))
                {
                    if (i+1 < array.length)
                    {
                        array[i] = array[i+1];
                    }
                    else
                    {
                        array[i] = null;
                    }
                    itemFound = true;
                }
            }
            else
            {
                if (i + 1 < array.length)
                {
                    array[i] = array[i + 1];
                }
                else
                {
                    array[i] = null;
                }
            }
        }

        return itemFound;
    }

    /**
     * Returns a item object inside the inventory if found, null if it doesn't exist
     * <br />
     * Precondition: itemName exists and is properly capitalized <br />
     * Postconditon: returns a item with the item name.
     * @param itemName Name of the item to fetch for
     * @return The first instance of the item object with matching names if it exists, 
        null if it doesn't
     */
    public Items fetchItem(String itemName)
    {
        for (Items item : this.inventory)
        {
            if (item != null && item.getName().equalsIgnoreCase(itemName))
            {
                return item;
            }
        }

        return null;
    }

    /**
     * Checks if a program is open inside the player's programsOpen array
     * Precondition: programName is a valid program name, properly punctuated
     * @param programName The name of the program to search for
     * @return Boolean to represent whether the program is open
     */
    public boolean isProgramOpen(String programName)
    {
        for (Programs program : this.programsOpen)
        {
            if (program == null)
            {
                continue;
            }
            
            if (program.getName().equalsIgnoreCase(programName))
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Fetches a program inside the player's open program array
     * Precondition: programName is a valid program name, properly punctuated, and has been opened
     * Postcondition: returns the program if it exists, and null if not
     * @param programName The name of the program to fetch for
     * @return The program, as a programs object - or null if it doesn't exist
     */
    public Programs fetchProgram(String programName)
    {
        for (Programs program : this.programsOpen)
        {
            if (program == null)
            {
                continue;
            }

            if (program.getName().equalsIgnoreCase(programName))
            {
                return program;
            }
        }

        return null;
    }
    
    /**
     * Adds an item to player inventory, if the inventory isn't full.
     * <u>When you handle the boolean, make sure to only handle the true value</u>
     * @param leItem Item to add to player inventory
     * @return whether the item addition was successful
     */
    public boolean addInvItem(Items leItem)
    {
        boolean x = this.appendToArr(leItem, this.inventory, true);

        if (x)
        {
            return true;
        }
        else
        {
            System.out.println("Your inventory is full!");
            return false;
        }
    }

    /**
     * Removes an item from player inventory, and shifts everything an index down
     * @param itemName Name of the item to remove from inventory
     * @return Whether removal was successful
     */
    public boolean removeInvItem(String itemName)
    {
        return this.deleteFromArr(itemName, this.inventory);
    }

    /**
     * Adds an item to player program open list
     * Precondition: Program is not already in the array and program open list isn't full
     * Postcondition: Returns whether item was successful and adds item to programList <br />
     * Developer Notes: Do not println in addProgram result
     * @param program Program to add to player program open list
     * @return Whether the item addition was successful
     */
    public boolean addProgram(Programs program)
    {
        boolean programAdded = this.appendToArr(program, this.programsOpen, false);
        
        if (!programAdded)
        {
            if (this.programsOpen[7] == null)
            {
                System.out.println("smh this program is already open");
            }
            else
            {
                System.out.println("Ok sir your program list is full." +
                    "If you open any more your computer is probably going to die");
            }
        }

        return programAdded;
    }

    /**
     * Removes an program from the player's program open list, and shifts everything an index down
     * Precondition: The program is in the player's program array
     * Postcondition: The program is removed
     * @param programName Name of the item to remove from program open list
     * @return Whether removal was successful
     */
    public boolean removeProgram(String programName)
    {
        return this.deleteFromArr(programName, this.programsOpen);
    }

    /**
     * Return whether the player won
     * @return Value of this.win
     */
    public boolean getWin()
    {
        return this.win;
    }

    /**
     * Returns the current program
     * @return A reference to the current program. Go figure.
     */
    public Programs getCurrentProgram()
    {
        return this.currentProgram;
    }

    /**
     * Sets the current program to a new program
     * @param program The program to set player's current program to
     */
    public void setCurrentProgram(Programs program)
    {
        this.currentProgram = program;
    }

    /**
     * Changes your risk chance percentage
     * Your risk chance determines your risk of getting lawsuits and cease-and-desist orders.
     * Too many unsettled lawsuits would cause the game to end
     * @param num Number to change risk chance by
     */
    public void changeRiskChance(int num)
    {
        this.riskChance += num;
    }

    /**
     * Returns your risk chance
     * @return this.riskChance
     */
    public int getRiskChance()
    {
        return this.riskChance;
    }

    /**
     * Changes the risk chance by an amount
     * @param num The number to change the risk change by
     */
    public void setRiskChance(int num)
    {
        this.riskChance += num; 
    }

    /**
     * Returns a formatted list of everything in the player's inventory
     * Postcondition: The formatted list will have the item name and null
     * @return A formatted list of everything in the player's inventory x2
     */
    public String returnInventory()
    {
        String inventoryString = "---------Inventory--------\n";

        for (Items item : this.inventory)
        {
            if (item == null)
            {
                inventoryString += "> Empty Spot \n";
            }
            else
            {
                inventoryString += "> " + item.getName() + " x1 \n";
            }
        }

        inventoryString += "--------------------------";
        return inventoryString;
    }

    /**
     * Returns whether the player has used bitcoins
     * @return this.secureShopping
     */
    public boolean usedBitcoins()
    {
        return this.secureShopping;
    }

    /**
     * Sets the security of the user's dark net transactions.
     * More specificially, this sets this.secureShopping
     * @param usedBitcoin Whether the user has used botcoins or not.
     */
    public void setBitcoins(boolean usedBitcoin)
    {
        this.secureShopping = usedBitcoin;
    }

    /**
     * Returns string of names of all programs in the programs open list
     * @return A string of names of all the programs that are open
     */
    public String programsOpenLog()
    {
        String str = "[";
        
        for (Programs program : this.programsOpen)
        {
            if (program != null)
            {
                str += ", " + program.getName();
            }
        }

        str += " ]";
        return str.replaceFirst(",", "");
    }

    /**
     * Returns the suspicion chances of the player
     * @return this.sus
     */
    public int getSus()
    {
        return this.sus;
    }

    /**
     * Changes the suspicion chances of the player
     * @param num The number to change the sus chances by
     */
    public void changeSus(int num)
    {
        this.sus += num;
    }
}

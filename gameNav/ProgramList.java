package gameNav;
import objects.programs.*;

/**
 * The hub for programs and handling of programs.
 * Programs are essentially apps you open and interact with (essentially your adventure rooms).
    * Precondition for everything in this class: call initialize();
 * @since 12/13/20
 * @author Justin
 * @category gameNav
 */
public class ProgramList {
    /**
     * A list of programs that can be used.
     * Available programs that finished development are kept here
     */
    private static Programs[] programList;

    /**
     * YOU MUST CALL THIS BEFORE THE GAME STARTS
     * Initalizes the programList static attribute
     * @param targetPlayer The unique and main player inside the game
     */
    public static void initialize(Player targetPlayer) throws Exception
    {
        ProgramList.programList = new Programs[] {
            new StackOverflow(targetPlayer),
            new Discord(targetPlayer),
            new Reddit(targetPlayer),
            new SilkRoad(targetPlayer),
            new Jgrasp(targetPlayer),
            new AWS(targetPlayer),
            new Minecraft(targetPlayer),
            new BTHSDataArchive(targetPlayer)
        };
    }

    /**
     * Loops through programList whether the program the user specified is in the array
     * @param programName the name of the program to search for
     * @return whether the program exists in programList
     */
    public static boolean isValidProgram(String programName)
    {
        for (Programs program : programList)
        {
            if (program != null && program.getName().equals(programName))
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Loops through programList to return the program object if it exists
     * Precondition: The program name exists and is enabled
     * Postcondition: Returns the program object
     * @see ProgramList.fetchAuthority(programName)
     * @param programName The name of the program to fetch for, properly capitalized
     * @return A program object if it exists, and null if it doesn't
     */
    public static Programs fetch(String programName)
    {
        for (Programs program : programList)
        {
            if (program.getName().equalsIgnoreCase(programName) && program.isEnabled())
            {
                return program;
            }
        }

        return null;
    }

    /**
     * This is an authority fetch, which is not controlled by player commands 
        and will ignore whether something is enabled or not.
     * Loops through programList to return the program object if it exists.
     * Precondition: The program name exists.
     * Postcondition: Returns the program object.
     * @see ProgramList.fetch(String programName)
     * @param programName The name of the program to fetch for, properly capitalized
     * @return A program object if it exists, and null if it doesn't
     */
    public static Programs fetchAuthority(String programName)
    {
        for (Programs program : programList)
        {
            if (program.getName().equalsIgnoreCase(programName))
            {
                return program;
            }
        }

        return null;
    }

    /**
     * Returns all the program names in a string format.
     * The programs represent all programs the player can open and use - if enabled
     * @return All of the names of the available programs
     */
    public static String printString()
    {
        //If all programs have the disabled attribute, return that there are no programs
        if (ProgramList.allDisabled())
        {
            return "nothing";
        } 

        String str = "[";
        for (Programs program : programList)
        {
            if (program.isEnabled())
            {
                str += ", " + program.getName();
            }
        }

        str = str.replaceFirst(",", "");
        str += " ]";
        return str;
    }

    /**
     * Helper method, checks is all programs are disabled
     * @return Whether everything has the property this.enabled set to false
     */
    private static boolean allDisabled()
    {
        for (Programs program : programList)
        {
            //If something is enabled that means everything is not disabled
            if (program != null && program.isEnabled())
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Fetches a random program from the static program array list and returns it.
     * This can never fetch Discord. Recursion is used to prevent this from happening
     * @return A random program from ProgramList.programList, but the program cannot be Discord
     */
    public static Programs fetchRandomProgram()
    {
        Programs a = ProgramList.programList[(int)(Math.random() * ProgramList.programList.length)];
        
        return a.getName().equals("Discord") ? ProgramList.fetchRandomProgram() : a;
    }
}

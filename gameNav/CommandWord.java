package gameNav;

//Static class to redirect commands
//import srsBot lmao
import objects.commands.*;

/**
 * The hub where commands are handled, parsed, and called
    * Precondition for everything in this class: call initialize();
 * @author Justin
 * @category gameNav
 * @since 12/10/20
 */
public class CommandWord {
    /**
     * Imported list of commands - commands that are available for use (and not in development) 
    appears here
    */
    private static Commands[] commandsArr;
    
    /**
     * Initializes the static field commandsArr
     * MUST BE CALLED BEFORE THE GAME STARTS
     * @param targetPlayer The main player inside the game
     */
    public static void initialize(Player targetPlayer) throws Exception
    {
        CommandWord.commandsArr = new Commands[] {
            new Help(targetPlayer),
            new Open(targetPlayer),
            new Close(targetPlayer),
            new Swap(targetPlayer),
            new Check(targetPlayer),
            new Inventory(targetPlayer),
            new Mkdir(targetPlayer),
            new HelpMe(targetPlayer),
            new Observe(targetPlayer),
            new Use(targetPlayer),
            new Upload(targetPlayer)
        };
    }

    /**
     * Redirects to a command while parsing the text for needed arguments.
     * Fetches the command from commandsArr and calls the execute method.
     * This will pass the command array as the commands parameter and the user input text without the command 
        name as the argument. The command will always be one word.
     * @param command The array that contains the command
     * @param text The user input scanner text
     */
    public static void redirect(String[] command, String text)
    {
        int idx = CommandWord.commandIdx(command[0]);
        
        if (idx == -1)
        {
            System.out.println("The command does not exist ._.");
        }
        else
        {
            String resText = text.substring(text.indexOf(command[0]) + command[0].length());
            CommandWord.commandsArr[idx].execute(command, resText.replaceFirst(" ", ""));
        }
    }

    /**
     * Private helper method, finds the index of the alleged command
     * @return The index of the command, or -1 if the command doesn't exist
     * @param commandName The name of the command to look for
    */
    private static int commandIdx(String commandName)
    {
        for (int i=0; i<commandsArr.length; i++)
        {
            if (CommandWord.commandsArr[i].getName().equalsIgnoreCase(commandName))
            {
                return i;
            }
        }

        return -1;
    }

    /**
     * Fetches for a command given the command name
     * Precondition: The commandName exists and is properly punctuated
     * Postcondition: A reference to the command object is created
     * @param commandName The commandName to search for
     * @return The command if the commandName exists and null if it does not exist
     */
    public static Commands fetch(String commandName)
    {
        for (Commands command : CommandWord.commandsArr)
        {
            if (command.getName().equalsIgnoreCase(commandName))
            {
                return command;
            }
        }
        
        return null;
    }

    /**
     * Converts CommandWord.commandsArr into string format and returns the string
     * @return CommandWord.commandsArr as a string format
     */
    public static String printString()
    {
        String str = "";
        for (Commands command : CommandWord.commandsArr)
        {
            str += ", " + command.getName();
        }
        str = str.replaceFirst(",", "");

        return str;
    }
}

package gameNav;
import java.util.Scanner;

//Parser for normal game - every command will have its own specific command handling scanner
/**
 * The official parser for the game 
 * Also known as the "dominant scanner" where command lines go through
 * @author Justin
 * @category gameNav
 * @since 12/9/20
 */
public class Parser
{
    /**
     * The parser scanner we would be using
     */
    private Scanner scanner;

    /**
     * Constructs a parser object which initializes the scanner we'll be using
     * In other words, initializes the "dominant scanner"
     */
    public Parser()
    {
        this.scanner = new Scanner(System.in);
    }

    //Parses command, returns whether user wants to quit or not
    /**
     * Splits the parser input into text based parameter and whatnot
     * Redirects the user input to the command hub
     * This is done via the "dominant scanner"
     * Minor subsequent scanners are in other class to aid the methods there
     * @return whether the user quits or not by typing "quit"
     */
    public boolean parse()
    {
        String text = this.scanner.nextLine();
        
        if (text.equals(""))
        {
            System.out.println("That... thing does not exist");
            return false;
        }
        
        if (text.equals("quit"))
        {
            return true;
        }

        //Is it ironic that the srs bot you're trying to develop in the game
        //uses the exact same code to parse commands? o.o
        String[] command = text.split(" ");
        CommandWord.redirect(command, text);

        return false;
    }
}
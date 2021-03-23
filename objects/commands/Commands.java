package objects.commands; //Wow vsc does it all for me
import java.nio.file.Files;
import java.nio.file.Path;
import gameNav.Player;
import objects.JustinWare;

/**
 * The top class for command creation
 * @author Justin
 * @since 12/09/20
 * @category objects/JustinWare
 */
public class Commands extends JustinWare {

    /**
     * Constructs a Command, reads the txt file in textLore to obtain description
     * Precondition: c:textLore/programs/<command name>.txt has been created
     * Postcondition: Command object is constructed 
     * @param name The command name
     * @param targetPlayer The player defined when the game has started
     * @throws Exception Will throw if description path is not found
     */
    public Commands(String name, Player targetPlayer) throws Exception
    {
        super(name, Files.readString(Path.of("c:textLore/commands/" + name + ".txt")), 
            targetPlayer, "Command");
    }

    /**
     * Default method to execute a command
     * Should not reach here
     */
    public void execute(String[] commands, String text)
    {
        System.out.println("This command is unexecutable.");
    }   
}

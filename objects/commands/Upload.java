package objects.commands;
import gameNav.Player;

/**
 * Upload command - allows you to upload files to a program
 * @author Justin
 * @since 12/30/20
 * @category objects/JustinWare
 */
public class Upload extends Commands
{
    /**
     * Constructs an upload command/object
     * @param targetPlayer Le Main Player inside Le Game
     * @throws Exception if Upload.txt does not exist
     */
    public Upload(Player targetPlayer) throws Exception
    {
        super("Upload", targetPlayer);
    }

    /**
     * Executes the upload command
     * Allows the user to upload to some programs
     * Postcondition: Calls the upload method on the object in the targetPlayer's currentProgram
     * @param commands The array that holds all the command + arguments. Very useless here.
     * @param text The array that holds the rest of the input text without the comment. Useless too.
     */
    public void execute(String[] commands, String text)
    {
        this.getTargetPlayer().getCurrentProgram().upload();
    }
}

package objects.commands;
import gameNav.Player;
import gameNav.ProgramList;
import objects.programs.*;

/**
 * Mkdir command - Shows you the programs that are open, the programsList, and currentProgram
 * . It's not too handy, but it is a good way to waste batteries
 * @author Justin
 * @since 12/19/20
 * @category objects/JustinWare
 */
public class Mkdir extends Commands
{
    /**
     * Constructs a Mkdir command object
     * @param targetPlayer The main player inside the game
     * @throws Exception if Mkdir.txt does not exist
     */
    public Mkdir(Player targetPlayer) throws Exception
    {
        super("Mkdir", targetPlayer);
    }

    /**
     * Executes the mkdir command <br />
     * Postcondition: Send out a log that returns the programs open, the programList, and the current
        program
     * @param command The command array
     * @param text The text, that should contain the actual program name
     */
    public void execute(String[] command, String text)
    {
        String compiledStr = "----------Mkdir----------\n" + 
        "Available Programs: " + ProgramList.printString() + "\n" + 
        "Programs Open: " + this.getTargetPlayer().programsOpenLog() + "\n" +
        "Current Program: ";
        
        Programs tempProg = this.getTargetPlayer().getCurrentProgram();
        compiledStr += tempProg == null ? "None" : tempProg.getName();
        compiledStr += "\n-------------------------";

        System.out.println(compiledStr);
    }
}

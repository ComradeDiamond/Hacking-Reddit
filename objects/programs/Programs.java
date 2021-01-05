package objects.programs;

import gameNav.Player;
import objects.JustinWare;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Programs are interfaces that the player uses to interact and progress the game
 * The main hub of interaction with "software" inside the game
 * Programs are necessary to progress the game or to have desired in game effects
 * @author Justin
 * @since 12/05/20
 * @category object/JustinWare
 */
public class Programs extends JustinWare {
    /**
     * Keeps track of whether the program is enabled/active
     */
    private boolean enabled;

    /**
     * A static String[] that contains all the possible usernames out there that we will use 
        later in the methods in the children of the Programs class
     */
    private static String userNameArr[] = new String[]{
        "snowbaru",
        "cheems",
        "SealEnthusiast4",
        "SpiffinBrit",
        "AwhaleWailedInWales",
        "CakeSpectacular",
        "Leetify12",
        "JasonTrollz",
        "SpriteCranberry53",
        "LemonLime",
        "OreMaster89",
        "Jragon",
        "TheLegend57",
        "DreamDidNotCheat",
        "DreamIsInnocent",
        "BinomialDistribution",
        "TheModsAreBiased",
        "DreamStan45",
        "DreamWasNotHacking!!!!!",
        "DreamsAstrophysicist",
        "rStatisticsIsALie",
        "DreamIsInnocent",
        "DreamSpeedrunLegit545",
        "letMeOnDreamSMP",
        "TechnobladeNeverDies",
        "DreamStan776",
        "drista3",
        "DreamMom344",
        "COMEHEREGEORGE",
        "PublicKitten",
        "theftIsLegal",
        "HappyWhale343",
        "billDiferenly",
        "billDiferenly",
        "chizuDiferenly",
        "chizu43",
        "chizuuuuuuuuuuuuuu",
        "imBuiltDifferenly",
        "imBillDiferenly",
        "Lustachio",
        "Burner123",
        "Pocrasination4",
        "wouldyouwantsomewater",
        "i8Epi",
        "folwell",
        "mattPat33",
        "eatAChristmasTree",
        "geoTriangle",
        "pHacking",
        "StanDream",
        "ChristmasSlime",
        "SantaElf43",
        "Elfwood",
        "jgraspSucks",
        "LETITSNOW",
        "thanos"
    };

    /**
     * Constructs a Program, reads the txt file in textLore to obtain description <br />
     * Precondition: c:textLore/programs/<name>.txt has been created <br />
     * Postcondition: Program object is constructed. this.enabled is set to true
     * @param name The program name
     * @param targetPlayer The targetPlayer defined when game is started
     * @throws Exception Will throw if description path is not found
     */
    public Programs(String name, Player targetPlayer) throws Exception
    {
        super(name, Files.readString(Path.of("c:textLore/programs/" + name.replace(" ", "") + ".txt")),
            targetPlayer, "Program");

        this.enabled = true;
    }

    /**
     * Alternate constructor for Programs
     * Precondition: c:textLore/programs/<name>.txt has been created
     * Postcondition: Program object is constructed 
     * @param name The program name
     * @param targetPlayer The targetPlayer defined when game is started
     * @param isEnabled whether the program is enabled/obtained by the player at the start
     * @throws Exception Will throw if description path is not found
     */
    public Programs(String name, Player targetPlayer, boolean isEnabled) throws Exception
    {
        super(name, Files.readString(Path.of("c:textLore/programs/" + name.replace(" ", "") + ".txt")),
            targetPlayer, "Program");

        this.enabled = isEnabled;
    }

    /**
     * Returns a boolean of whether the program is enabled/obtained by the player
     * @return this.enabled
     */
    public boolean isEnabled()
    {
        return this.enabled;
    }

    /**
     * Sets the availability of the program :P
     * @param enabled Whether the program is enabled
     */
    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    /**
     * The user observes the program surrounding and maybe finds some stuff.
     * The observe command will print a random observation
     */
    public void observe()
    {
        System.out.println("Looks like there's not much to look at here.");
    }

    /**
     * The user uploads something to a program.
     */
    public void upload()
    {
        System.out.println("Weirdly, you can't upload anything here.");
    }

    /**
     * Returns a random username from Programs.usernameArr.
     * @return A string of an username
     */
    public String generateUser()
    {
        return Programs.userNameArr[(int)(Math.random() * userNameArr.length)];
    }
}

package gameNav;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import objects.programs.Discord;

/**
 * The game class is the center hub for starting and ending a game
 * @author Justin
 * @since 12/11/20
 * @category gameNav
 */
public class Game {
    /**
     * The parser object used for the game
     */
    private Parser parser;
    /**
     * The player object used for the game
     */
    private Player player;

    /**
     * Constructor for Game class
     * Initializes a game object with its own unique player and parser
     */
    public Game()
    {
        this.player = new Player();
        this.parser = new Parser();
    }

    /**
     * Returns the player
     * @return this.player
     */
    public Player getPlayer()
    {
        return this.player;
    }

    /**
     * playGame() method - starts the game and initializes the basic gameNav items.
     * Introduce the introduction first, then proceed to start rounds.
     * Postcondition: The game starts, introductions are done, and CommandWord and ProgramList 
        have both been initialized
     * @throws Exception if CommandWord or ProgramList initialization goes wrong, or if 
        introduction.txt does not exist
     */
    public void playGame() throws Exception
    {
        CommandWord.initialize(this.player);
        ProgramList.initialize(this.player);

        this.doIntroduction();
        
        this.playRound();
    }

    //Recursion because I have flashbacks from crashing websites with while loops lmao
    /**
     * Stimulates one round, or one command use in terms of this game
     * Before every turn, check and updates the stats. End the game where needed
     * If player wins the game, return and stop the game
     * After one round is over, call playRound() again. Recursion (:
     * <div>The commands execute AFTER roundCalc</div>
     * @throws Exception if any one of the things happen:
        * <endingName>.txt does not exist
     */
    public void playRound() throws Exception
    {
        if (this.roundCalc())
        {
            System.out.println("FINAL RESULT: LOSS");
            return;
        }

        System.out.print("> "); //A thing to let users type on during command phase

        //Parser returns true if the kid concedes
        if (this.parser.parse())
        {
            this.endingConcede();
            System.out.println("FINAL RESULT: CONCEDE");
            return;
        }

        if (this.player.getWin())
        {
            this.endingVictory(this.player.getWinType());
            System.out.println("FINAL RESULT: VICTORY");
            return;
        }

        //New line seperates every round
        System.out.println("");
        
        this.playRound();
    }

    /**
     * Does round calculation after a round so we can drain the player's power and whatnot.
     * More specifically, this checks the energy, battery, discord riots, and lawsuits.
     * In the illegal ending, this also takes into account your sus.
     * This command also drains the batteries of the player by the # of programs open.
     * Triggers game endings if something bad has happened.
     * Postcondition: Lowers your risk by 1
     * @return True if player stats are enough to trigger a game loss
     * @throws Exception if any ending thing is not found
     */
    private boolean roundCalc() throws Exception
    {
        if (player.getEnergy() <= 0)
        {
            this.endingEnergy();
            return true;
        }

        /*Drains the player's batteries according to how many programs they have open.
        1 program open = 1 battery drained
        Might need balancing if this is too unfair
        This battery calculation comes at the start of the next round. This is why we claim
        that the battery change happens WHEN THE PLAYER EXECUTES A COMMAND, because
        a round will ALWAYS end with a command.*/
        player.batteryChange(- (player.getNumPrograms()));

        //Checks on the CHANGED battery amount
        if (player.getBattery() <= 0)
        {
            this.endingBattery();
            return true;
        }

        //Check lawsuits
        if (((Discord)ProgramList.fetchAuthority("Discord")).suitCalc(player.getRiskChance()) >= 10)
        {
            this.endingRisk();
            return true;
        }

        //Lowers risk by 1. Yes, you can have negative risk because you'll need it
        this.player.changeRiskChance(-1);

        //Check sus
        if (player.getSus() >= 100)
        {
            this.endingSus();
            return true;
        }

        if (!player.isProgramOpen("Discord"))
        {
            //5% chance server will go into riot mode if discord is closed
            if (Math.floor(Math.random() * 20) == 10)
            {
                int riotPhase = ((Discord)ProgramList.fetchAuthority("Discord")).addRiotPhase();

                if (riotPhase == 4)
                {
                    this.endingRiot();
                    return true;
                }
                else
                {
                    System.out.println("Looks like something is going on in discord...");
                }
            }
        }
        
        return false;
    }

    /**
     * Takes a string and prints it out line by line. Prints the next line upon user input
     * User input == "I understand the text, continue the dialouge"
     * @param endingFileName txt file that hoards the ending/intro text
     * @throws Exception if c:textLore/endings/<endingFileName>.txt does not exist
     */
    private void lineByLine(String endingFileName) throws Exception
    {
        String toArr = Files.readString(Path.of("c:textLore/endings/" + endingFileName + ".txt"));
        String[] txtArr = toArr.split("\n");
        Scanner leScan = new Scanner(System.in);
        
        System.out.println("_________________");
        for (String str : txtArr)
        {
            System.out.println(str);
            leScan.nextLine();
        }
    }

    /**
     * Prints the introduction line by line
     * @throws Exception if Introduction.txt does not exist. 
     * @see this.lineByLine();
     */
    private void doIntroduction() throws Exception
    {
        this.lineByLine("Introduction");
    }

    /**
     * Prints the concede ending trigger
     * Triggered by the player conceding
     * @throws Exception if Concede.txt does not exist
     */
    private void endingConcede() throws Exception
    {
        this.lineByLine("Concede");
    }

    /**
     * Prints the ending for the discord riot ending
     * Triggered when discord riot status reaches 4
     * @throws Exception if Riot.txt does not exist
     */
    private void endingRiot() throws Exception
    {
        this.lineByLine("Riot");
    }

    /**
     * Prints the ending for running out of batteries.
     * Triggered when this.player.battery becomes <= 0
     * @throws Exception if Battery.txt does not exist
     */
    private void endingBattery() throws Exception
    {
        this.lineByLine("Battery");
    }

    /**
     * Prints the ending for running out of energy.
     * Triggered when this.player.energy becomes <= 0
     * @throws Exception if Energy.txt does not exist
     */
    private void endingEnergy() throws Exception
    {
        this.lineByLine("Energy");
    }

    /**
     * Prints the ending for the FBI ending.
     * Triggered when risk >= 100
     * @throws Exception if FBI.txt does not exist
     */
    private void endingSus() throws Exception
    {
        this.lineByLine("FBI");
    }

    /**
     * Prints the cheesy Millenial humor Judge Judy ending.
     * Triggered when lawsuit >= 10.
     * @throws Exception if Lawsuit.txt does not exist
     */
    private void endingRisk() throws Exception
    {
        this.lineByLine("Lawsuit");
    }

    /**
     * Prints the ending victory.
     * Precondition: victoryType is an existing victory type name
     * @param victoryType The string of the name of the victory type
     * @throws Exception if <victoryType>.txt does not exist
     */
    private void endingVictory(String victoryType) throws Exception
    {
        this.lineByLine(victoryType);
    }
}

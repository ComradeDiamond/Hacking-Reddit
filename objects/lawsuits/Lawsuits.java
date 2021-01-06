package objects.lawsuits;

import java.nio.file.Files;
import java.nio.file.Path;

import gameNav.Player;
import objects.JustinWare;


/**
 * The general class for lawsuits and cease and desist orders.
 * And other useless LAS stuff.
 * @author Justin
 * @since 1/6/21
 * @category objects/JustinWare
 */
public class Lawsuits extends JustinWare
{
    /**
     * The main constructor for any lawsuits. This will construct a lawsuit object :P.
     * For the purposes of this game, lawsuits and seize and desist orders are mingled together
     * @param name The name of the lawsuit (or type of lawsuit)
     * @param targetPlayer The main player inside the game
     * @throws Exception if <name>.txt does not exist inside the lawsuits folder
     */
    public Lawsuits(String name, Player targetPlayer) throws Exception
    {
        super(name, Files.readString(Path.of("c:textLore/lawsuits/" + name + ".txt")), targetPlayer, "Lawsuits");
    }
}

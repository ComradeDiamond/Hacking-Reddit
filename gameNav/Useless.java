package gameNav;

/**
 * Hi I'm a useless class that does absolutely nothing except fill in requirements
 * @author Justin
 * @since 1/13/21
 * @category gameNav
 */
public class Useless 
{
    /**
     * Hello! This is a random static variable that does nothing!
     */
    private int randomStaticVariable;

    /**
     * Postcondition: Sets the static variable setUselessVariable to 0.
     * The variable is in CommandWord
     */
    public void changeVariable()
    {
        CommandWord.setUselessVariable(0);
    }

    /**
     * Converts this useless object into a printable string
     * @return This item, stringified. This will print an object because Strings are objects.
     */
    public String toString()
    {
        return "Don't mind this, it's just a useless item: randomStaticVariable is null";
    }
}

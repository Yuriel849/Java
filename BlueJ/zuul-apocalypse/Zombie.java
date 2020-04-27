/**
 * Class Item
 *
 * @author Yuriel
 * @version 2020.04.27
 */
public class Zombie
{
    private String name;
    private String description;

    /**
     * Default constructor for objects of class Zombie.
     */
    public Zombie()
    {
        this("Unknown enemy", "What sort of creature is this...?");
    }
    
    /**
     * Create a zombie with designated name and description.
     * @param name The zombie's name.
     * @param description The zombie's description.
     */
    public Zombie(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
    
    /**
     * Gets the name of the zombie.
     * @return The name of the zombie.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the description of the zombie.
     * @return The description of the zombie.
     */
    public String getDescription()
    {
        return description;
    }
}
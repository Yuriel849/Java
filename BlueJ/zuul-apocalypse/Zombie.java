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
    private int health;

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
        health = 100;
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
    
    /**
     * Get's the health of the zombie. Health is 100 at full health.
     * @return The health of the zombie.
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Reduce the zombie's health.
     * @param damage The damage done to the zombie's health.
     * @return True, if the zombie's health is reduced to 0 or less. Then the zombie should be dead. False, if the zombie's health is greater than 0.
     */
    public boolean reduceHealth(int damage)
    {
        boolean result = false;
        
        health -= damage;
        
        if(health <= 0)
        {
            result = true;
        }
        
        return result;
    }
}
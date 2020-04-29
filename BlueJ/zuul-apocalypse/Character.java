/**
 * Class Character
 *
 * @author Yuriel
 * @version 2020.04.29
 */
public class Character
{
    private String name;
    private String description;
    private int health;

    /**
     * Default constructor for objects of class Character.
     */
    public Character()
    {
        this("Someone", "Who is this anyways...?");
    }
    
    /**
     * Create a character with designated name and description, and a health of 100.
     * @param name The character's name.
     * @param description The character's description.
     */
    public Character(String name, String description)
    {
        this.name = name;
        this.description = description;
        health = 100;
    }
    
    /**
     * Gets the name of the character.
     * @return The name of the character.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the description of the character.
     * @return The description of the character.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Get's the health of the character. Health is 100 at full health.
     * @return The health of the character.
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Reduce the character's health.
     * @param damage The damage done to the character's health.
     * @return True, if the character's health is reduced to 0 or less. Then the character should be dead. False, if the character's health is greater than 0.
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
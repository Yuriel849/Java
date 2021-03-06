package implementation;

/**
 * Class Item
 *
 * @author Yuriel
 * @version 2020.04.27
 */
public class Item
{
    private String name;
    private String description;

    /**
     * Default constructor for objects of class Item.
     */
    public Item()
    {
        this("Unknown object", "What is this...?");
    }
    
    /**
     * Create an item with designated name and description.
     * @param name The item's name.
     * @param description The item's description.
     */
    public Item(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
    
    /**
     * Gets the name of the item.
     * @return The name of the object.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the description of the item.
     * @return The description of the object.
     */
    public String getDescription()
    {
        return description;
    }
}
import java.util.ArrayList;
import java.util.Iterator;

public class Pack
{
    private ArrayList<Item> inventory;
    int size = 20;

    /**
     * Default constructor for the Pack class.
     */
    public Pack()
    {
        inventory = new ArrayList<>();
    }

    /**
     * Add an item to the pack.
     * @param item The item to put in the pack.
     * @return True, if the item was successfully added to the pack. False, if the pack was full and the item was not added.
     */
    public boolean putInPack(Item item)
    {
        boolean result = false;
        
        if(size > 0)
        {
            inventory.add(item);
            size--;
            result = true;
        }
        
        return result;
    }
    
    /**
     * Get an item from the pack and return it. The retrieved item is removed from the pack.
     * @param name The name of the item to be retrieved.
     * @return The desired item retrieved from the pack.
     */
    public Item getFromPack(String name)
    {
        Item result = null, temp = null;
        
        Iterator<Item> iterator = inventory.iterator();
        while(iterator.hasNext())
        {
            temp = iterator.next();
            
            if(temp.getName().equals(name))
            {
                result = temp;
                iterator.remove();
                size++;
                break;
            }            
        }
        
        return result;
    }
    
    /**
     * Check if the pack is empty or not.
     * @return True, if the pack is empty. False, if the pack is not empty (has at least one item inside).
     */
    public boolean isEmpty()
    {
        if(inventory.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
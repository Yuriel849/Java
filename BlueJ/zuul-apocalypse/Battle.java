/**
 * Class Battle
 *
 * @author Yuriel
 * @version 2020.04.29
 */
public class Battle
{
    public static boolean attack(Zombie target)
    {
        boolean zombieIsDead = false;
        int damage = (int) (Math.random() * 40);
        
        if(damage == 0)
        {
            System.out.println("You missed! No damage done!");
        }
        else
        {
            System.out.println("Hit! " + damage + " damage inflicted. Zombie's health is now " + target.getHealth() + ".");
            zombieIsDead = target.reduceHealth(damage);
        }
        
        return zombieIsDead;
    }
    
    public static int zombieAttack(int health)
    {
        int playerHealth = 0, damage = (int) (Math.random() * 15);
        
        if(damage == 0)
        {
            System.out.println("You took no damage!");
        }
        else
        {
            playerHealth = health - damage;
            System.out.println("No! You took " + damage + " damage. Your health is now " + playerHealth + ".");
        }
        
        return playerHealth;
    }    
    
    // If player's health is less than or equal to 0, game over
    // If zombie's health is less than or equal to 0, zombie removed from fight and current room
}

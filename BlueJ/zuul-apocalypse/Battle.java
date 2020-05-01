import java.util.ArrayList;

/**
 * Class Battle
 *
 * @author Yuriel
 * @version 2020.05.01
 */
public class Battle
{
    public static String fight(Player player, Parser parser)
    {
        ArrayList<Zombie> zombies = player.getCurrentRoom().getAllZombies();
        int index = zombies.size() - 1, health = player.getHealth();
        Zombie target = zombies.get(index);
        String result = "", commandWord = "";
        
        while(index > 0 || health > 0)
        {
            commandWord = parser.getCommand().getCommandWord();
            
            if(commandWord.equals("run"))
            {
                System.out.println("You ran away from the zombies.");
                result = "back";
                break;
            }
            else if(commandWord.equals("attack"))
            {
                attack(target);
                zombieAttack(health);
            }
            
            if(health <= 0)
            {
                System.out.println("You are dead...");
                result = "dead";
                break;
            }
            else if(target.getHealth() <= 0)
            {
                System.out.println("The zombie is dead!");
                player.getCurrentRoom().removeZombie(target);
                target = zombies.get(--index);
            }
        }
        
        return result;
    }
    
    private static boolean attack(Zombie target)
    {
        boolean zombieIsDead = false;
        int damage = (int) (Math.random() * 40);
        
        if(damage == 0)
        {
            System.out.println("You missed! No damage done!");
        }
        else
        {
            zombieIsDead = target.reduceHealth(damage);
            System.out.println("Hit! " + damage + " damage inflicted. Zombie's health is now " + target.getHealth() + ".");
        }
        
        return zombieIsDead;
    }
    
    private static int zombieAttack(int health)
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
}
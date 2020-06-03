package implementation;

import java.util.ArrayList;

import common.*;

/**
 * Class Battle
 *
 * @author Yuriel
 * @version 2020.06.02
 */
public class Battle {
    public static String fight(Player player, UserInterfaceable parser)
    {
        ArrayList<Zombie> zombies = player.getCurrentRoom().getAllZombies();
        int index = zombies.size() - 1, health = player.getHealth();
        Zombie target = zombies.get(index);
        String result = "", commandWord = "";
        boolean targetDead = false;
        
        System.out.println("You can choose to attack or run back to the last room.\nMake up your mind and type 'attack' or 'run'.");
        
        while(index >= 0 || health > 0)
        {
            System.out.println("Attack or run?");
            commandWord = parser.getCommand().getCommandWord();
            
            if(commandWord.equals("run"))
            {
                if(player.getSizePreviousRooms() == 1)
                {
                    System.out.println("There's nowhere to run to... you must fight.");
                }
                else
                {
                    System.out.println("You ran away from the zombies.");
                    result = "back";
                    break;
                }
            }
            else if(commandWord.equals("attack"))
            {
                targetDead = attack(target);
                health = zombieAttack(health);
            }
            
            if(health <= 0)
            {
                System.out.println("You are dead... (Yeah~~!!)");
                result = "dead";
                break;
            }
            else if(targetDead == true)
            {
                targetDead = false;
                System.out.println("The zombie is dead!");
                player.getCurrentRoom().removeZombie(target);
                if(index > 0)
                {
                    System.out.println("There's another one...");
                    target = zombies.get(--index);
                }
                else
                {
                    System.out.println("You've won! Your health is " + health + ". Let's move on.");
                    break;
                }
            }
        }
        
        return result;
    }
    
    private static boolean attack(Zombie target)
    {
        boolean zombieIsDead = false;
        int damage = (int) (Math.random() * 50);
        
        if(damage == 0)
        {
            System.out.println("You missed! No damage done!");
        }
        else
        {
            zombieIsDead = target.reduceHealth(damage);
            System.out.println("Hit! " + damage + " damage inflicted. Zombie's health is now " + ((target.getHealth() < 0) ? 0 : target.getHealth()) + ".");
            
            if(target.getHealth() <= 0)
            {
                zombieIsDead = true;
            }
        }
        
        return zombieIsDead;
    }
    
    private static int zombieAttack(int health)
    {
        int playerHealth = health, damage = (int) (Math.random() * 15);
        
        if(damage == 0)
        {
            System.out.println("You took no damage!");
        }
        else
        {
            playerHealth -= damage;
            System.out.println("No! You took " + damage + " damage. Your health is now " + playerHealth + ".");
        }
        
        return playerHealth;
    }
}
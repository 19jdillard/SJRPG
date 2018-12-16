
/**
 * Write a description of class SJRPG here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Character extends Entity
{
    // instance variables - replace the example below with your own
    private String name;
    private int hp;
    private int originalHP;
    private int mp;
    private int atk;
    private int def;
    private int spd;
    private int exp;
    private int lvl;
    private int javaPoints;
    private ArrayList<Spells> spells;
    private Inventory inventory;

    /**
     * Constructor for objects of class SJRPG
     */
    public Character()
    {
        name = "";
        originalHP = 100;
        hp = originalHP;
        mp = 10;
        atk = 5;
        def = 5;
        spd = 5;
        exp = 0;
        lvl = 1;
        javaPoints = 500;
        Inventory tmpInventory = new Inventory();
        inventory = tmpInventory;
    }
    
    /**
     * Constructor for objects of class SJRPG
     
    public Character(Character character)
    {
        name = name;
        hp = hp;
        mp = mp;
        atk = atk;
        def = def;
        spd = spd;
        exp = exp;
        lvl = lvl;
        javaPoints = javaPoints;
    }
    */
    
    /**
     * Constructor for objects of class SJRPG
     */
    public Character(int tmpHP, int tmpMP, int tmpAtk, int tmpDef, int tmpSpd)
    {
        if(tmpHP*10 + tmpMP*5 + tmpAtk*2 + tmpDef*2 + tmpSpd*2 != 20)
        {
            name = "";
            hp = 10;
            mp = 100;
            atk = 5;
            def = 5;
            spd = 5;
            exp = 0;
            lvl = 1;
            javaPoints = 500;
            Inventory tmpInventory = new Inventory();
            inventory = tmpInventory;
        }
        else
        {
            name = "";
            hp = 10 + tmpHP*10;
            mp = 100 + tmpMP*5;
            atk = 5 + tmpAtk*2;
            def = 5 + tmpDef*2;
            spd = 5 + tmpSpd*2;
            exp = 0;
            lvl = 1;
            javaPoints = 500;
            Inventory tmpInventory = new Inventory();
            inventory = tmpInventory;
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getName()
    {
       return name;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void changeName(String tmpName)
    {
        name = tmpName;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void expGain(int amount)
    {
       exp += amount;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void jpGain(int amount)
    {
       javaPoints+= amount;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getExp()
    {
       return exp;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getJP()
    {
       return javaPoints;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Inventory getInventory()
    {
       return inventory;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void buyItem(Item tmpItem, int tmpCost, int tmpItemNum)
    {
       javaPoints = javaPoints - tmpCost;
       inventory.addItem(tmpItem, tmpItemNum);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean emptyInventory()
    {
        return (inventory.getItems()).isEmpty();
    }
    
/**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void attack(ArrayList<Enemy> tmpEnemies)
    {
        System.out.println("What shall you do?");

        System.out.println();

        System.out.println("1: Attack" + "     " + "2: Defend");
        System.out.println("3: Items" + "      " + "4: Examine");
        Scanner scanner = new Scanner(System.in);
        int battleScanNum = scanner.nextInt();

        if(battleScanNum == 1)
        {
            System.out.println();

            String enemiesString = "-1: Back ";
            for(int i = 0; i < tmpEnemies.size(); i++)
            {
                enemiesString += i+1 + ": " + (tmpEnemies.get(i)).getName() + " ";
            }
            System.out.println(enemiesString);
            battleScanNum = scanner.nextInt();

            System.out.println("");
                        
            System.out.println(this.getName() + " attacked the " + tmpEnemies.get(battleScanNum-1).getName() + "!");
            (tmpEnemies.get(battleScanNum-1)).recieveDamage(this.getAtk());
            checkForKO(tmpEnemies);
            
            System.out.println("");
        }
        else if(battleScanNum == 2)
        {
            this.defPlus(1);
        }
        else if (battleScanNum == 3)
        {
            if(this.emptyInventory())
            {
                System.out.println();
                System.out.println("You have no items!");
            }
            else
            {
                String inventoryItems = this.getInventory().openInventory();

                System.out.println();

                System.out.println("Inventory:");
                System.out.println(inventoryItems);

                String enemiesString = "-1: Back ";
                for(int i = 0; i < tmpEnemies.size(); i++)
                {
                    enemiesString += i+1 + ": " + (tmpEnemies.get(i)).getName() + " ";
                }

                battleScanNum = scanner.nextInt();

                this.useItem(battleScanNum, tmpEnemies.get(battleScanNum-1));
            }
        }
        else if (battleScanNum == 4)
        {
            System.out.println();

            String enemiesString = "-1: Back ";
            for(int i = 0; i < tmpEnemies.size(); i++)
            {
                enemiesString += i+1 + ": " + (tmpEnemies.get(i)).getName() + " ";
            }
            System.out.println(enemiesString);

            battleScanNum = scanner.nextInt();

            System.out.println(this.getName() + "examines the " + (tmpEnemies.get(battleScanNum-1)).getName() + ":");
            System.out.println("\"" + "Health Points: " + (tmpEnemies.get(battleScanNum-1)).getHP() + "     " +  "Magic Points: " + (tmpEnemies.get(battleScanNum-1)).getMP() + "\n" + " " + "Attack: " + (tmpEnemies.get(battleScanNum-1)).getAtk() + "     " + " " + "Defense: " + (tmpEnemies.get(battleScanNum-1)).getDef() + "     " + " " + "Speed: " + (tmpEnemies.get(battleScanNum-1)).getSpd() + "\"");
        } 
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void checkForKO(ArrayList<Enemy> tmpEnemies)
    {
        for(int i = 0; i < tmpEnemies.size(); i++)
        {
            if(tmpEnemies.get(i).getHP() <= 0)
            {
                tmpEnemies.remove(i);
                i--;
            }
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void useItem(int tmpItemSlot, Enemy tmpEnemy)
    {
        if((inventory.getItems()).size() == 1)
        {
            tmpItemSlot = 0;
        }
        if((inventory.getItems()).size() > 1 && tmpItemSlot == (inventory.getItems()).size())
        {
            tmpItemSlot--;
        }
        if(0 > tmpItemSlot || tmpItemSlot > (inventory.getItems()).size())
        {
        }
        else
        {
            Item item = (Item)((inventory.getItems()).get(tmpItemSlot));
            inventory.removeItem(tmpItemSlot);
            
            if((item.getCategory()).equals("Restorative"))
            {
                System.out.println();
                
                if(hp + item.getEffNum() > originalHP)
                {
                    System.out.println(name + " was healed by " + (originalHP - hp) + " HP!");
                    hp = originalHP;
                }
                else
                {
                    hp += item.getEffNum();
                    System.out.println(name + " was healed by " + item.getEffNum() + " HP!");
                }
            }
            else if((item.getCategory()).equals("Destructive"))
            {
                System.out.println();
                tmpEnemy.recieveDamage(item.getEffNum());
                System.out.println(tmpEnemy.getName() + " took " + item.getEffNum() + " damage!");
            }
        }
    }
}

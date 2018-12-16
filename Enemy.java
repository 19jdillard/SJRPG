
/**
 * Write a description of class sjrpgEnemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random;
import java.util.ArrayList;

public class Enemy extends Entity
{
    // instance variables - replace the example below with your own
    private String name;
    private int hp;
    private int originalHP;
    private int mp;
    private int atk;
    private int def;
    private int spd;
    private int lvl;
    private EnemyAI ai;

    /**
     * Constructor for objects of class sjrpgEnemy
     */
    public Enemy()
    {
        name = "";
        originalHP = 50;
        hp = 50;
        mp = 0;
        atk = 5;
        def = 0;
        spd = 0;
        lvl = 1;
        ai = new EnemyAI(0);
    }
    
    /**
     * Constructor for objects of class sjrpgEnemy
     */
    public Enemy(String tmpEnemy)
    {
        if(tmpEnemy.equals("Basic Bot"))
        {
            name = tmpEnemy;
            originalHP = 50;
            hp = 50;
            mp = 0;
            atk = 6;
            def = 4;
            spd = 2;
            lvl = 1;
            ai = new EnemyAI(3);
        }
        else if(tmpEnemy.equals("Battle Bot"))
        {
            name = tmpEnemy;
            originalHP = 30;
            hp = 50;
            mp = 10;
            atk = 10;
            def = 1;
            spd = 10;
            lvl = 1;
            ai = new EnemyAI(3);
        }
        else if(tmpEnemy.equals("StackOverflow"))
        {
            name = tmpEnemy;
            originalHP = 50000;
            hp = 50000;
            mp = 1000;
            atk = 100;
            def = 50;
            spd = 1;
            lvl = 500;
            ai = new EnemyAI(3);
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
    public int getOriginalHP()
    {
       return originalHP;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getHP()
    {
       return hp;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getMP()
    {
       return mp;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getAtk()
    {
       return atk;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getDef()
    {
       return def;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getSpd()
    {
       return spd;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getLvl()
    {
       return lvl;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void recieveDamage(int amount)
    {
        hp = hp - amount;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void attack(ArrayList<Character> tmpCharacters)
    {
        Random random = new Random();
        int aiNum = random.nextInt(3);
        int characterTarget = random.nextInt(tmpCharacters.size()) + 1;

        if(aiNum == 0)
        {
            System.out.println();
            System.out.println("The " + this.getName() + " attacks!");
            (tmpCharacters.get(characterTarget-1)).recieveDamage(this.getAtk());
            checkForKO(tmpCharacters);
            System.out.println("");
        }
        else if(aiNum == 1)
        {
            System.out.println();
            System.out.println("The " + this.getName() + " attacks!");
            (tmpCharacters.get(characterTarget-1)).recieveDamage(this.getAtk());
            checkForKO(tmpCharacters);
            System.out.println("");
        }
        else if(aiNum == 2)
        {
            System.out.println();
            System.out.println("The " + this.getName() + " stumbles and falls!");
            checkForKO(tmpCharacters);
            System.out.println("");
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void checkForKO(ArrayList<Character> tmpCharacters)
    {
        for(int i = 0; i < tmpCharacters.size(); i++)
        {
            if(tmpCharacters.get(i).getHP() <= 0)
            {
                tmpCharacters.remove(i);
                i--;
            }
        }
    }
}

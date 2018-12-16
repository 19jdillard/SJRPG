
/**
 * Write a description of class Entity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random;

public class Entity
{
    // instance variables - replace the example below with your own
    public String name;
    public int hp;
    public int originalHP;
    public int mp;
    public int atk;
    public int def;
    public int spd;
    public int lvl;

    /**
     * Constructor for objects of class Entity
     */
    public Entity()
    {
        name = "";
        originalHP = 100;
        hp = originalHP;
        mp = 10;
        atk = 5;
        def = 5;
        spd = 5;
        lvl = 1;
    }

    /**
     * Constructor for objects of class Entity
     */
    public Entity(int tmpHP, int tmpMP, int tmpAtk, int tmpDef, int tmpSpd)
    {
        name = name;
        hp = hp;
        mp = mp;
        atk = atk;
        def = def;
        spd = spd;
        lvl = lvl;
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
    public void hpPlus(int amount)
    {
       hp += amount;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void hpMinus(int amount)
    {
       hp -= amount;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void mpPlus(int amount)
    {
       mp += amount;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void mpMinus(int amount)
    {
       mp -= amount; 
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void atkPlus(int amount)
    {
       atk += amount; 
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void atkMinus(int amount)
    {
       atk -= amount; 
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void defPlus(int amount)
    {
       def += amount; 
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void defMinus(int amount)
    {
       def -= amount; 
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void spdPlus(int amount)
    {
       spd += amount; 
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void spdMinus(int amount)
    {
       spd -= amount; 
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void randomPlus()
    {
       int randNum = (int)(5*Math.random());
       if(randNum == 0)
       {
           hpPlus(5);
       }
       else if(randNum == 1)
       {
           mpPlus(2);
       }
       else if(randNum == 2)
       {
           atkPlus(1);
       }
       else if(randNum == 3)
       {
           defPlus(1);
       }
       else if(randNum == 4)
       {
           spdPlus(1);
       }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void randomMinus()
    {
       Random random = new Random();
       int randNum = random.nextInt(5);
       
       System.out.println(randNum);
       
       if(randNum == 0)
       {
           hpMinus(5);
       }
       else if(randNum == 1)
       {
           mpMinus(2);
       }
       else if(randNum == 2)
       {
           atkMinus(1);
       }
       else if(randNum == 3)
       {
           defMinus(1);
       }
       else if(randNum == 4)
       {
           spdMinus(1);
       }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void healDamage(int amount)
    {
        hp += amount;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void recieveDamage(int amount)
    {
        hp -= amount;
    }
}

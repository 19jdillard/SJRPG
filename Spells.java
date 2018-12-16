
/**
 * Write a description of class Spells here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spells
{
    // instance variables - replace the example below with your own
    private String name;
    private String category;
    private String description;
    private int dmg;
    private int effNum;
    private int mpCost;
    private Character character;
    private Enemy enemy;

    /**
     * Constructor for objects of class Spells
     */
    public Spells()
    {
        name = "";
        category = "";
        description = "";
        dmg = 0;
        effNum = 0;
        mpCost = 0;
    }
    
    /**
     * Constructor for objects of class Spells
     */
    public Spells(String tmpName, String tmpCategory, String tmpDescription, int tmpDMG, int tmpEffNum, int tmpMPCost, Character tmpCharacter, Enemy tmpEnemy)
    {
        name = tmpName;
        category = tmpCategory;
        description = tmpDescription;
        dmg = tmpDMG;
        effNum = tmpEffNum;
        mpCost = tmpMPCost;
        character = tmpCharacter;
        enemy = tmpEnemy;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void characterCast()
    {
        if(category.equals("Restorative"))
        {
            character.healDamage(effNum);
        }
        else if(category.equals("Destructive"))
        {
            enemy.recieveDamage(dmg);
        }
        else if(category.equals("Other"))
        {
        }
    }
}

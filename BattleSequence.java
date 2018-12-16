
/**
 * Write a description of class BattleSequence here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

// CURRENT ISSUES: speed sorting methods not working, 

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BattleSequence
{
    private int enemyNum;
    private int characterNum;
    private int entityNum;
    private ArrayList<Character> characters;
    private ArrayList<Enemy> enemies;
    private ArrayList<Entity> entities;
    private final int MAX_CHARACTERS = 4;
    private final int MAX_ENEMIES = 5;
    private boolean canCastSpells = false;
    private int turnCounter;

    /**
     * Constructor for objects of class BattleSequence
     */
    public BattleSequence()
    {
        characterNum = 1;
        characters = new ArrayList<Character>(characterNum);

        enemyNum = 1;
        enemies = new ArrayList<Enemy>(enemyNum);

        entityNum = characterNum + enemyNum;
        entities = new ArrayList<Entity>(entityNum);
    }

    /**
     * Constructor for objects of class BattleSequence
     */
    public BattleSequence(int tmpCharacterNum, int tmpEnemyNum)
    {
        characterNum = tmpCharacterNum;
        characters = new ArrayList<Character>(characterNum);

        enemyNum = tmpEnemyNum;
        enemies = new ArrayList<Enemy>(enemyNum);

        entityNum = characterNum + enemyNum;
        entities = new ArrayList<Entity>(entityNum);

        for(Character element : characters)
        {
            if(element.getLvl() > 5)
            {
                canCastSpells = true;
            }
        }
    }

    public void fillBattle(ArrayList<Character> tmpCharacters, ArrayList<Enemy> tmpEnemies)
    {
        if(tmpCharacters.size() <= MAX_CHARACTERS)
        {
            characters = tmpCharacters;
        }
        else
        {
            for(int i = MAX_CHARACTERS + 1; i < tmpCharacters.size(); i++)
            {
                tmpCharacters.remove(i);
            }

            characters = tmpCharacters;
        }
        if(tmpEnemies.size() <= MAX_ENEMIES)
        {
            enemies = tmpEnemies;
        }
        else
        {
            for(int i = MAX_ENEMIES + 1; i < tmpEnemies.size(); i++)
            {
                tmpEnemies.remove(i);
            }

            enemies = tmpEnemies;
        }
        for(int i = 0; i < characters.size(); i++)
        {
            entities.add(characters.get(i));
        }
        for(int i = characters.size(); i < enemies.size(); i++)
        {
            entities.add(enemies.get(i));
        }
        // the user will have to create a list of characters and enemies, construct an initialized array of said players, and then use this method).
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void startSequence()
    {
        System.out.println();

        if(enemies.size() == 1)
        {
            System.out.println("A " + (enemies.get(0)).getName() + " attacked!"); 
        }
        else if(enemies.size() > 1)
        {
            System.out.println("A group of enemies attacked!");  
        }

        System.out.println();
        sortEntitySpeeds();

        while(characterPartyHP() > 0 && enemyPartyHP() > 0)
        {
            System.out.println(hpInterface());

            for(int i = 0; i < entities.size(); i++)
            {
                if(entities.get(i) instanceof Character)
                {
                    ((Character)entities.get(i)).attack(enemies); 
                }
                if(entities.get(i) instanceof Enemy)
                {
                    ((Enemy)entities.get(i)).attack(characters); 
                }
            }
            turnCounter++;
        }
        if(characterPartyHP() <= 0)
        {
            this.defeatSequence();
        }
        if(enemyPartyHP() <= 0)
        {
            this.victorySequence();
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int characterPartyHP()
    {
        int characterPartyHP = 0;

        for(int i = 0; i < characters.size(); i++)
        {
            characterPartyHP += (characters.get(i)).getHP();
        }

        return characterPartyHP;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int enemyPartyHP()
    {
        int enemyPartyHP = 0;

        for(int i = 0; i < enemies.size(); i++)
        {
            enemyPartyHP += (enemies.get(i)).getHP();
        }

        return enemyPartyHP;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void victorySequence()
    {
        System.out.println();
        System.out.println("VICTORY!");
        int enemyEXP = 0;
        int enemyJP = 0;
        for(int i = 0; i < enemies.size(); i++)
        {
            enemyEXP += enemies.get(i).getOriginalHP()*enemies.get(i).getLvl();
            enemyJP += enemies.get(i).getOriginalHP()*enemies.get(i).getLvl()*2/3;
        }
        for(int i = 0; i < characters.size(); i++)
        {
            characters.get(i).expGain(enemyEXP);
            characters.get(i).expGain(enemyJP);
        }
        System.out.println("You gained: " + enemyEXP + "EXP and " + enemyJP + "JP!");

        String characterGains = "";
        for(int i = 0; i < characters.size(); i++)
        {
            characterGains += characters.get(i).getName() + "'s EXP: " + characters.get(i).getExp();
            characterGains += characters.get(i).getName() + "'s JP: " + characters.get(i).getJP();
            characterGains += "\n";
        }

        System.out.println(characterGains);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void defeatSequence()
    {
        System.out.println();
        System.out.println("GAME OVER...");
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sortEntitySpeeds()
    {
        ArrayList<Entity> tmpEntities = new ArrayList<Entity>(entities.size());
        for(int i = 0; i < entities.size(); i++)
        {
            int highestSpeed = 0;
            for(Entity element : entities)
            {
                if(highestSpeed < element.getSpd())
                {
                    highestSpeed = element.getSpd();
                }
            }
            for(Entity element : entities)
            {
                if(highestSpeed == element.getSpd())
                {
                    tmpEntities.add(element);
                    entities.remove(element);
                }
            }
        }
        entities = tmpEntities;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String hpInterface()
    {
        String hpInterface = "";
        String turn = "Turn: " + turnCounter;
        String characterString = "";
        String enemyString = "";
        String bars = "";

        for(int i = 0; i < enemies.size(); i++)
        {
            enemyString += ((enemies.get(i)).getName() + ": " + (enemies.get(i)).getHP() + " ");
        }
        for(int i = 0; i < characters.size(); i++)
        {
            characterString += ((characters.get(i)).getName() + ": " + (characters.get(i)).getHP() + " ");
        }

        if(characterString.length() > enemyString.length())
        {
            for(int i = 0; i < characterString.length(); i++)
            {
                bars += "-";
            }
        }
        else if(enemyString.length() > characterString.length())
        {
            for(int i = 0; i < enemyString.length(); i++)
            {
                bars += "-";
            }
        }
        
        hpInterface = bars + "\n" + turn + "\n" + characterString + "\n" + enemyString + "\n" + bars;
        
        return hpInterface;
    }
}


/**
 * Write a description of class EnemyAI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random;

public class EnemyAI
{
    // instance variables - replace the example below with your own
    private int choiceNum;
    private int[] choices;
    private String startDialogue;
    private String attackDialogue;
    private String missDialogue;
    private String endDialogue;

    /**
     * Constructor for objects of class EnemyAI
     */
    public EnemyAI()
    {
        choiceNum = 2;
    }
    
    /**
     * Constructor for objects of class EnemyAI
     */
    public EnemyAI(int tmpChoiceNum)
    {
        choices = new int[tmpChoiceNum];
        for(int i = 0; i < choices.length; i++)
        {
            choices[i] = i+1;
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void act()
    {
        Random random = new Random();
        int randNum = random.nextInt(choiceNum);
        
    }
}

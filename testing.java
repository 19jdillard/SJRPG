
/**
 * Write a description of class testing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class testing
{
    public static void main (String[] args)
    {
        System.out.print("\f");
        
        Enemy enemy = new Enemy("Basic Bot");
        
        ArrayList<Enemy> enemies = new ArrayList<Enemy>(5);
        enemies.add(enemy);
        enemies.add(enemy);
        enemies.add(enemy);
        enemies.add(enemy);
        enemies.add(enemy);
        enemies.remove(2);
        enemies.trimToSize();
        
        for(int i = 0; i < enemies.size(); i++)
        {
            System.out.println((enemies.get(i)).getName() + " ");
        }
    }
}

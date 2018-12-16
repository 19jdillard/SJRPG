
/**
 * Write a description of class Inventory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class Inventory
{
    // instance variables - replace the example below with your own
    private int space;
    private ArrayList<Item> items;

    /**
     * Constructor for objects of class Inventory
     */
    public Inventory()
    {   
        space = 10;
        items = new ArrayList<Item>(space);
    }
    
    /**
     * Constructor for objects of class Inventory
     */
    public Inventory(int tmpSpace)
    {   
        space = tmpSpace;
        items = new ArrayList<Item>(space);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getSpace(int tmpSpace)
    {
        return space;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public ArrayList getItems()
    {
        return items;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String openInventory()
    {
        String inventoryItems = "-1: Back ";

        for(int i = 0; i < items.size(); i++)
        {
            inventoryItems += i+1 + ": " + (items.get(i)).getName() + " ";
        }
        
        return inventoryItems;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addItem(Item tmpItem, int tmpNumOfItem)
    {
        while(tmpNumOfItem > 0)
        {
            items.add(items.size(), tmpItem);
            tmpNumOfItem--;
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void removeItem(int tmpItemIndex)
    {
            items.remove(tmpItemIndex);
    }
}


/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name;
    private int cost;
    private int effNum;
    private String category;
    private String description;
    private String usedDialogue;

    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        // initialise instance variables
        name = "";
        cost = 0;
        effNum = 0;
        category = "";
        description = "";
        usedDialogue = "";
    }
    
    /**
     * Constructor for objects of class Item
     */
    public Item(String tmpName, int tmpCost, int tmpEffNum, String tmpCategory, String tmpDescription, String tmpUsedDialogue)
    {
        // initialise instance variables
        name = tmpName;
        cost = tmpCost;
        effNum = tmpEffNum;
        category = tmpCategory;
        description = tmpDescription;
        usedDialogue = tmpUsedDialogue;
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
    public int getCost()
    {
        return cost;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getEffNum()
    {
        return effNum;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getCategory()
    {
        return category;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void restorativeItem(int tmpEffNum, Inventory tmpInventory)
    {
        
    }
}

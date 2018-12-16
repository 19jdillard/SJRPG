/**
 * Write a description of class FleaMarketVendor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

// NEXT THING TO DO: account for how many items the itemshop has, and if it runs below 0, then you can't buy anymore!
// Fix the fact that if you "are not sure" about being an item, for some reason the program goes "have a nice day!" and then gives one more unnecessary prompt.

public class ItemShop
{
    // INITIALIZATIONS
    private Item[] items;
    private int itemVariety;
    private Character character;

    public ItemShop(int tmpItemVariety, Character tmpCharacter)
    {
        itemVariety = tmpItemVariety;
        items = new Item[itemVariety];
        character = tmpCharacter;
    }

    public void fillShop(Item[] tmpItems)
    {
        for(int i = 0; i < tmpItems.length; i++)
        {
            items[i] = tmpItems[i];
        }
        // the user will have to create a list of items, construct an initialized array of said items, and then use this method).
    }

    public void sellItem()
    {

        int counter = 1;
        int dialogueCounter = 0;

        while(counter == 1)
        {
            System.out.println();

            if(dialogueCounter < 1)
            {
                System.out.println("Hello there! What would you like to buy?");
            }
            else if (dialogueCounter >= 1)
            {
                System.out.println("What would you like to buy?");
            }

            System.out.println();

            for(int i = 0; i < items.length; i++)
            {
                if(i == 0){System.out.print("1: ");}
                if(i > 0){System.out.print(" | ");}
                if(i > 0){System.out.print(i+1 + ": ");}
                System.out.print((items[i]).getName());
            }

            System.out.println();
            
            Scanner scanner = new Scanner(System.in);
            int itemScanNum = scanner.nextInt();
            int itemIndex = itemScanNum - 1;
            
            System.out.println();
            
            System.out.println("How many " + items[itemIndex].getName() + " would you like to purchase?");
            itemScanNum = scanner.nextInt();
            int numItemBuy = itemScanNum;

            System.out.println();

            System.out.println("Are you sure? " + itemScanNum + " " + items[itemIndex].getName() + " ?");
            System.out.println("1: Yes" + "     " + "2: No");
            itemScanNum = scanner.nextInt();

            if(itemScanNum == 1)
            {
                if(character.getJP() - (itemScanNum*items[itemIndex].getCost()) < 0)
                {
                    System.out.println();

                    System.out.println("I'm sorry, but you don't have enough JP to purchase that many of this item!");
                }
                else
                {
                    int totalCost = numItemBuy*items[itemIndex].getCost();
                    character.buyItem(items[itemIndex], totalCost, numItemBuy);

                    System.out.println();

                    System.out.println("Thank you! Would you like anything else?");
                    System.out.println("1: Yes" + "     " + "2: No");
                    itemScanNum = scanner.nextInt();

                    if(itemScanNum == 1)
                    {
                    }
                    else if(itemScanNum == 2)
                    {
                        System.out.println();

                        System.out.println("Have a nice day!");

                        counter--;
                    }
                }
            }

            else if(itemScanNum == 2)
            {
                System.out.println();

                System.out.println("Would you like anything else?");
                System.out.println("1: Yes" + "     " + "2: No");
                itemScanNum = scanner.nextInt();

                if(itemScanNum == 1)
                {
                }
                else if(itemScanNum == 2)
                {
                    System.out.println();

                    System.out.println("Have a nice day!");

                    counter--;
                }
            }
            dialogueCounter++;
        }
    }
}

/**
 * Write a description of class sjrpgNewGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class sjrpgNewGame
{
    public static void main(String[]args)
    {
        System.out.print("\f");
        Scanner scanner = new Scanner(System.in);
        Character character = new Character();
        
        System.out.println("\"Hello fellow Java warrior! What might be your name?\"");
        String introString = scanner.next();
        
        character.changeName(introString);
        
        System.out.println();
        
        System.out.println("\"" + character.getName() + ", is it? Well, I am Java_Bot. It is a pleasure to meet your acqaintance. Do you recall what had last occurred to you? You seem terribly wounded and distraught.\"");
        
        System.out.println();
        
        System.out.println("1: Ugh... I don't know. I suddenly woke up in the dark depths of JavaDocs!");
        System.out.println("2: Injured? Distraught? Excuse me? I'm just fine, thank you. I think I just took a tumble down in the JavaDocs.");
        System.out.println("3: Huh. I have no idea, but here we are in the JavaDocs. Figures.");
        int gameScanNum = scanner.nextInt();
        
        String dialogueChoice = "Uh-oh! This is a run–time error.";
        
        if(gameScanNum == 1)
        {
            dialogueChoice = "\"How most confounding!\"";
            character.hpPlus(5);
            character.spdMinus(1);
        }
        else if(gameScanNum == 2)
        {
            dialogueChoice = "\"Erm... alrighty then, my apologies.\"";
            character.mpPlus(2);
            character.defMinus(1);
        }
        else if (gameScanNum == 3)
        {
            dialogueChoice = "\"And you've amnesia too...\"";
            character.atkPlus(1);
            character.atkMinus(1);
        }
        
        System.out.println();
        
        System.out.println(dialogueChoice);
        System.out.println("\"Well, " + character.getName() + ", I am simply glad to see you are safe. Which may sound queer coming from a stranger, but there is trouble afoot in the land of BlueJay.\"");
        
        System.out.println();
        
        System.out.println("1: Woah, really? What's going on?");
        System.out.println("2: Well great, and just what exactly is happening that's SO important?");
        System.out.println("3: Uh oh. What'd that be?");
        gameScanNum = scanner.nextInt();
        
        if(gameScanNum == 1)
        {
            character.mpPlus(2);
            character.defPlus(1);
        }
        else if(gameScanNum == 2)
        {
            character.atkPlus(1);
            character.atkPlus(1);
        }
        else if (gameScanNum == 3)
        {
            character.defPlus(1);
            character.mpPlus(2);
        }

        System.out.println();
        
        System.out.println("\"O, woe is me! The evil and notorious StackOverflow attempted to import-star our world! Once every package from the library imports, we will be doomed to slow down in speed until we freeze up forever!\"");
        System.out.println();
        
        System.out.println("1: Woah... that's insane. We have to stop it!");
        System.out.println("2: Crap. That's actually not good...");
        System.out.println("3: Yikes! There must be some way to reverse it?");
        gameScanNum = scanner.nextInt();
        
        if(gameScanNum == 1)
        {
            character.atkPlus(1);
            character.atkMinus(1);
        }
        else if(gameScanNum == 2)
        {
            character.defPlus(1);
            character.mpMinus(2);
        }
        else if (gameScanNum == 3)
        {
            character.spdPlus(1);
            character.hpMinus(5);
        }

        System.out.println();
        
        System.out.println("\"Why, there just may be a way to put a stop to this... but BlueJay needs YOUR help! You are one of few last known survivors since the collapse of many worlds...\"");
        System.out.println("\"Here: I shall grant you a newfound strength to seek out StackOverflow and defeat him, once and for all.\"");
        
        character.randomPlus();
        character.randomPlus();
        character.randomPlus();
        character.randomPlus();
        character.randomPlus();
        
        System.out.println();
        System.out.println("Java_Bot works his magic, and... woah! You feel revitalized.");
        System.out.println();
        
        System.out.println("\"Now, let us check your stats...\"");
        
        System.out.println();
        System.out.println("\"" + "Health Points: " + character.getHP() + "     " +  "Magic Points: " + character.getMP() + "\n" + " " + "Attack: " + character.getAtk() + "     " + " " + "Defense: " + character.getDef() + "     " + " " + "Speed: " + character.getSpd() + "\"");
        System.out.println();
        
        System.out.println("\"Now, I shall later have time to explain what each of these mean, but for now–– oh! Look out " + character.getName() + "!" + "\"");
        
        
        // ITEM SHOP #1
        
        Item item = new Item("HealthPlus", 5, 20, "Restorative", "A restorative potion that heals you by 30 hp", character.getName() + " drank the HealthPlus.");
        Item item1 = new Item("DamageDeal", 25, 55, "Destructive", "A destructive potion that deals 25 hp", character.getName() + " threw the DamageDeal!");
        
        Item[] first = {item, item1, item};
        ItemShop shop = new ItemShop(first.length, character);
        shop.fillShop(first);
        shop.sellItem();

        
        Enemy enemy = new Enemy("Basic Bot");
        Enemy enemy1 = new Enemy("Battle Bot");
        Enemy enemy2 = new Enemy("Basic Bot");
        
        // MULTI–CHARACTER BATTLE#1
        ArrayList<Character> characters = new ArrayList<Character>(1);
        characters.add(character);
        ArrayList<Enemy> enemies = new ArrayList<Enemy>(3);
        enemies.add(enemy);
        enemies.add(enemy1);
        enemies.add(enemy2);
        
        BattleSequence battle0 = new BattleSequence(1, 3);
        battle0.fillBattle(characters, enemies);
        battle0.startSequence();
        
    }
}

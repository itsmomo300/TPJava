package tests;

import com.isep.rpg.*;
import java.util.ArrayList;
import java.util.List;

public class UnitTests {
    private static List<Potion> potions;
    private static List<Food> food;

    public UnitTests() {
        potions = new ArrayList<Potion>();
        potions.add(new Potion(0, 150));
        potions.add(new Potion(0, 150));

        food = new ArrayList<Food>();
        food.add(new Food(150, 0));
        food.add(new Food(150, 0));
    }


    /**
     * Ce test permet de savoir si un joueur meurt lorsqu'il reçoit 
     * un coup plus grand que ses pv.
     * @return "OK" si le test est passé ou "KO" sinon
     */
    public static String testIsDeadAfterKO() {
        Hero hero = new Hunter(200, 50, 100, potions, food, 5);
        Enemy enemy = new BasicEnemy(300, 250);
        enemy.attack(hero);
        if (!hero.isAlive())
            return "OK";
        return "KO";
    }

    /**
     * Ce test permet de savoir si le sort est lancé ou non lorsqu'on a pas assez de mana
     * @return "OK" si le test est passé ou "KO" sinon
     */
    public static String testCantSpellWithNoMana() {
        Mage mage = new Mage(200, 50, 100, potions, food, 0); // Mage has 0 mana points here
        Enemy enemy = new BasicEnemy(300, 250);
        mage.attack(enemy);
        if (enemy.getLifePoints() == 300)
            return "OK";
        return "KO";
    }

    /**
     * Ce test permet de savoir si une attaque arrive à l'ennemi avec les dégâts voulus
     * @return "OK" si le test est passé ou "KO" sinon
     */
    public static String testAttackHasArrivedToEnemy() {
        Hero hero = new Warrior(200, 50, 100, potions, food);
        Enemy enemy = new BasicEnemy(300, 250);
        hero.attack(enemy);
        if (enemy.getLifePoints() == 200)  
            return "OK";
        return "KO";
    }

    /**
     * Cet test permet de savoir si le nombre de flèches diminuent pour Hunter après avoir attaquer
     * @return "OK" si le test est passé ou "KO" sinon
     */
    public static String testArrowNumberDecrease() {
        Hunter hero = new Hunter(200, 50, 100, potions, food, 5);
        Enemy enemy = new BasicEnemy(300, 250);
        hero.attack(enemy);
        if (hero.getArrowCounter() == 4)
            return "OK";
        return "KO";
    }

    /**
     * Cet test permet de savoir si les points de mana diminuent après un sort d'un SpellCaster
     * @return "OK" si le test est passé ou "KO" sinon
     */
    public static String testManaDecreaseAfterSpell() {
        Mage mage = new Mage(200, 50, 100, potions, food, 50);
        Enemy enemy = new BasicEnemy(300, 250);
        mage.attack(enemy);
        if (mage.getManaPoints() < 50)
            return "OK";
        return "KO";
    }

    public static void main(String[] args) {
        System.out.println("Tests ...");
        System.out.println("testIsDeadAfterKO() : " + testIsDeadAfterKO() + "\n");
        System.out.println("testCantSpellWithNoMana : " + testCantSpellWithNoMana() + "\n");
        System.out.println("testAttackHasArrivedToEnemy : " + testArrowNumberDecrease() + "\n");
        System.out.println("testArrowNumberDecrease() : " + testArrowNumberDecrease() + "\n");
        System.out.println("testManaDecreaseAfterSpell() : " + testManaDecreaseAfterSpell() + "\n");
    }    
}

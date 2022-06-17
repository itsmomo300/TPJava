package com.isep.rpg;

import java.util.List;

public class Hunter extends Hero {
    private int arrowCounter;

    public Hunter(int lifePoints, int armor, int weaponDamage, List<Potion> potions, List<Food> lembas,
            int arrowCounter) {
        super(lifePoints, armor, weaponDamage, potions, lembas);
        this.arrowCounter = arrowCounter;
    }
    
    public int getArrowCounter() {
        return arrowCounter;
    }

    @Override
    public void useConsumable(Consumable c) {        
        System.out.println("Le consomable " + c.toString() + " est entrain d'être utilisé");
        this.lifePoints += c.getLifePointsToAdd();        
    }

    @Override
    public String getType() {
        return "Hunter";
    }

    @Override
    public void attack(Enemy enemy) {
        if (arrowCounter > 0) {
            System.out.println("Le Hunter lance sa flèche ...");
            arrowCounter--;
            enemy.setLifePoints(enemy.getLifePoints() - weaponDamage);
        } else {
            System.out.println("Le hunter n'a plus de flèches ...");
        }
    }
    
    public void addArrow() {
        arrowCounter++;
    }
      
}

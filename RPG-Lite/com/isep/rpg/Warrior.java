package com.isep.rpg;

import java.util.List;

public class Warrior extends Hero{

    public Warrior(int lifePoints, int armor, int weaponDamage, List<Potion> potions, List<Food> lembas) {
        super(lifePoints, armor, weaponDamage, potions, lembas);        
    }

    @Override
    public void attack(Enemy enemy) {        
        System.out.println("Le Warrior frappe ...");        
        enemy.setLifePoints(enemy.getLifePoints() - weaponDamage);        
    }

    @Override
    public void useConsumable(Consumable c) {        
        System.out.println("Le consomable " + c.toString() + " est entrain d'être utilisé");
        this.lifePoints += c.getLifePointsToAdd();
        
    }

    @Override
    public String getType() {
        return "Warrior";
    }
    
}

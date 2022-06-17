package com.isep.rpg;

import java.util.List;

public class Mage extends SpellCaster{
    protected int cost; // Le coût pour lancer un sort
    public Mage(int lifePoints, int armor, int weaponDamage, List<Potion> potions, List<Food> lembas, int manaPoints) {
        super(lifePoints, armor, weaponDamage, potions, lembas, manaPoints);
        this.cost = 30;
    }

    @Override
    public void attack(Enemy enemy) {
        if (hasMana(cost)) {
            System.out.println("Le Mage lance son sort ... ");
            manaPoints -= cost;
            enemy.setLifePoints(enemy.getLifePoints() - weaponDamage);            
        } else {
            System.out.println("Le Mage n'a pas assez de points de mana ...");            
        }
    }

    @Override
    public void useConsumable(Consumable c) {        
        System.out.println("Le consomable " + c.toString() + " est entrain d'être utilisé");
        this.lifePoints += c.getLifePointsToAdd();
        this.manaPoints += c.getManaPointstoAdd();    
    }
    @Override
    public String getType() {
        return "Mage";
    }
    
    
    
}

package com.isep.rpg;
import java.util.List;


public class Healer extends SpellCaster {
    private int healPoints;
    private int cost;
    public Healer(int lifePoints, int armor, int weaponDamage, List<Potion> potions, List<Food> lembas,
            int manaPoints, int healPoints) {
        super(lifePoints, armor, weaponDamage, potions, lembas, manaPoints);
        this.healPoints = healPoints;
        this.cost = 20;
    }

    
    @Override
    public String getType() {        
        return "Healer";
    }

    @Override
    public void useConsumable(Consumable c) {        
        System.out.println("Le consomable " + c.toString() + " est entrain d'être utilisé");
        this.lifePoints += c.getLifePointsToAdd();
        this.manaPoints += c.getManaPointstoAdd();    
    }

    /**
     * Cette méthode permet de soigner un autre héros par le Healer
     * @param hero
     */
    public void heal(Hero hero) {
        if (hasMana(cost)) {
            System.out.println("Le Healer est entrain de soigner le " + hero.getType());
            hero.setLifePoints(hero.getLifePoints() + healPoints);
        } else {
            System.out.println("Le Healer n'a pas assez de mana pour soigner ...");
        }

    }


    @Override
    public void attack(Enemy enemy) {                
    }


    
}

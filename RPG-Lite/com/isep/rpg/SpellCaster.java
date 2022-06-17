package com.isep.rpg;

import java.util.List;

public abstract class SpellCaster extends Hero {
    protected int manaPoints;
    public SpellCaster(int lifePoints, int armor, int weaponDamage, List<Potion> potions, List<Food> lembas,
            int manaPoints) {
        super(lifePoints, armor, weaponDamage, potions, lembas);
        this.manaPoints = manaPoints;
    }
    
    public abstract void attack(Enemy enemy);    
    
    public boolean hasMana(int cost) {
        return manaPoints > cost;
    }

    public int getManaPoints() {
        return manaPoints;
    }
    public abstract void useConsumable(Consumable c);
}

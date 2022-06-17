package com.isep.rpg;

public class Boss extends Enemy {
    private int healPoints; // Le boss peut heal

    public Boss(int lifePoints, int attackPoints, int healPoints) {
        super(lifePoints, attackPoints);
        this.healPoints = healPoints;
    }
    
    public int getHealPoints(){
        return healPoints;
    }
    
}

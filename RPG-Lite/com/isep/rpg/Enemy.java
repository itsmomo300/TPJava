package com.isep.rpg;

public class Enemy {
    private int lifePoints;
    private int attackPoints;

    public Enemy(int lifePoints, int attackPoints) {
        this.lifePoints = lifePoints;
        this.attackPoints = attackPoints;
    }

    public void attack(Hero hero) {
        if (hero.isDefending) {
            //int damage = attackPoints - hero.getArmor();                        
            int rest = hero.getArmor() - attackPoints;
            rest = rest <= 0 ? 0 : rest;            
            hero.setLifePoints(hero.getLifePoints() - attackPoints + hero.getArmor());
            hero.setArmor(rest);
        } else {
            hero.setLifePoints(hero.getLifePoints() - attackPoints);
        }
    }
    
    public boolean isAlive() {
        return lifePoints > 0;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }
}

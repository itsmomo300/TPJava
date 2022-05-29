package com.rpg;

public class Ennemy {
    private int puissanceAttack;

    public  Ennemy(){}


    public void attack(Hero hero){
        hero.lifePoints = hero.getLifePoints() - this.puissanceAttack;
        System.out.println("Enemy attack");
        this.puissanceAttack++;

    }
}

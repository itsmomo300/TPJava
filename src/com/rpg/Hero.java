package com.rpg;

import java.util.List;

public abstract class Hero {
    protected int lifePoints;
    protected int armor;
    protected int weaponDamage;
    protected List<Potion> potions;
    protected List<Food> lembas;


    public Hero() {
        this.lifePoints = 10;
        this.armor = 10;
        this.weaponDamage = 0;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    public List<Food> getLembas() {
        return lembas;
    }

    public void setLembas(List<Food> lembas) {
        this.lembas = lembas;
    }

    public int  attack(){
        this.armor -- ;
        if (armor == 0){
            System.out.println("Attaque impossible");
        }
        return armor;
    }
    public int defend(){
        this.weaponDamage --;
        if (weaponDamage <= 0){
            System.out.println("Hero dies");
        }
        System.out.println("Hero defends and rest of damage of enemy attack is "+this.weaponDamage);
        return this.weaponDamage;
    }
    public void useConsumable(Consumable consumable){
        consumable = new Food();
        this.lifePoints += consumable.getLifePoints();
    }

    @Override
    public String toString() {
        return "Hero{}";
    }
}

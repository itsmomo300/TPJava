package com.isep.rpg;
import java.util.List;

public abstract class Hero {

    public boolean isDefending = false;
    protected  int lifePoints;
    protected int armor;
    protected int weaponDamage;
    protected List<Potion> potions;
    protected List<Food> lembas;
    

    public Hero(int lifePoints, int armor, int weaponDamage, List<Potion> potions, List<Food> lembas) {
        this.lifePoints = lifePoints;
        this.armor = armor;
        this.weaponDamage = weaponDamage;
        this.potions = potions;
        this.lembas = lembas;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    /**
     * Cette méthode renvoie si le joueur est en vie ou pas
     * @return true is en vie, false sinon
     */
    public boolean isAlive(){
        return lifePoints > 0;
    }

    /**
     * attack()
     * Cette méthode est abstraite car elle dépend du type de l'héros
     */    
    abstract public void attack(Enemy enemy);    

    public void defend() {
        isDefending = true;
    }
    
    
    /**
     * Cetter méthode renvoie le type de l'héros, elle est abstracte car elle dépend de l'héros qui l'appelle
     * @return
     */
    abstract public String getType();

    public boolean hasConsumable() {
        return potions.size() > 0 || lembas.size() > 0;
    }

    public abstract void useConsumable(Consumable c);

    /**
     * Cette méthode rajoute une potion
     * @param p
     */
    public void addPotion(Potion p) {
        potions.add(p);
    }

    /**
     * Cette méthode rajouter une nourriture
     * @param f
     */
    public void addlembas(Food f) {
        lembas.add(f);
    }


    //Getters and setters
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
}
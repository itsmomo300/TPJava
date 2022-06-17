package com.isep.rpg;

public class Consumable {
    private int lifePointsToAdd;
    private int manaPointstoAdd;

    Consumable(int lifePointsToAdd, int manaPointstoAdd) {
        this.lifePointsToAdd = lifePointsToAdd;
        this.manaPointstoAdd = manaPointstoAdd;
    }
    
    public int getLifePointsToAdd() {
        return lifePointsToAdd;
    }

    public int getManaPointstoAdd() {
        return manaPointstoAdd;
    }

    public void setLifePointsToAdd(int lifePointsToAdd) {
        this.lifePointsToAdd = lifePointsToAdd;
    }

    public void setManaPointstoAdd(int manaPoint) {
        this.manaPointstoAdd = manaPoint;
    }
}

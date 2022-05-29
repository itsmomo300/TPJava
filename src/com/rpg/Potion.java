package com.rpg;

import com.rpg.Consumable;

public class Potion implements Consumable {
    @Override
    public int getLifePoints() {
        return 10;
    }
}


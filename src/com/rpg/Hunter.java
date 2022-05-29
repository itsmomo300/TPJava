package com.rpg;

public class Hunter extends Hero{

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    int arrows;

    public Hunter() {
        super();
        this.arrows = 7;
    }

    @Override
    public String toString() {
        return "Hunter";
    }

    @Override
    public int attack() {
        return super.attack();
    }

    @Override
    public int defend() {
        return super.defend();
    }
}

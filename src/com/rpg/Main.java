package com.rpg;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le jeu de RPG");
        generateGame();

    }
    public static void generateGame(){
        Game game = new Game();
        game.initHero();
        System.out.println(game.playGame());
        Ennemy ennemy = new Ennemy();
        Random random = new Random();
        int posEnnemy = random.nextInt(game.getHeroes().size());

        //attack ennemy
        ennemy.attack(game.getHeroes().get(posEnnemy));

        // defend hero

        game.getHeroes().get(posEnnemy).defend();


    }

}

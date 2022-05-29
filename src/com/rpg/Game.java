package com.rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.InputParser;



public class Game {
    protected List<Hero> heroes;
    protected int playerTurn;
    protected InputParser inputParser;

    public Game(){}

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void initHero(){
        List<Hero> heroes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Entrer le nombre de joueur de votre partie");
        int nbreHero = scanner1.nextInt();
        for (int i = 0; i < nbreHero; i++){
            System.out.println("Entrer le nom de votre héro");
            String nom = scanner.nextLine();
            switch (nom) {
                case "Hunter" -> {
                    Hero hunter = new Hunter();
                    heroes.add(hunter);
                }
                case "Mage" -> {
                    Hero warrior = new Warrior();
                    heroes.add(warrior);
                }
                default -> System.out.println("Veuillez entrer un joueur existant");
            }
            // J'ai juste mis deux type de Heros pour ne pas charger. Mais l'idée reste la même pour mes autres héros
        }
        this.heroes = heroes;
        this.playerTurn = 0;
        System.out.println("Le héro qui de jouer est "+ heroes.get(playerTurn));
    }

    public String playGame(){
        return "Bienvenue ! \n Vous démarrez une nouvelle partie.";
    }

}

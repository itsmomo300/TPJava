package com.isep.rpg;

import com.isep.utils.InputParser;
import java.util.List;
import java.util.ArrayList;

public class Game {
    private static List<Hero> heroes = new ArrayList<Hero>();    
    private static int playerTurn;
    private static InputParser inputParser = new InputParser();    
    
    /**
     * checkAliveHeroes
     * Cette méthode permet de trancher de la liste 'heroes' 
     * les héros qui sont morts.
     * @return True si il y'a encore un survivant
     */
    private static boolean checkAliveHeroes() {
        int aliveCounter = 0; // compteur d'héros encore en vie
        for (Hero hero : heroes) {
            if (hero.getLifePoints() > 0)
                aliveCounter++;
        }        
        if (aliveCounter > 0)
            return true;
        return false;
    }
    

    /**
     * Cette méthode génère des enemies avec une probablité de 20% de tomber sur des Boss
     * @return 
     */
    private static List<Enemy> generateEnemies(int number) {
        List<Enemy> enemies = new ArrayList<Enemy>();
        boolean haveBoss = false;
        for (int i = 0; i < number; i++) {
            if (Math.random() < 0.8 || haveBoss)

                enemies.add(new BasicEnemy(150, 50));
            else {
                haveBoss = true;                
                System.out.println("Ce combat se joue contre un Boss");
                enemies.add(new Boss(500, 100, 50));
            }
        }
        return enemies;
    }

    /**
     * Cette méthode permet de voir si il y a au moins un ennemi qui est encore vivant
     * @param enemies
     * @return
     */
    public static boolean areAliveEnemies(List<Enemy> enemies) {
        int aliveCounter = 0;
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getLifePoints() > 0) {
                aliveCounter++;
            }
        }
        if(aliveCounter > 0) 
            return true;
        return false;
    }

    /**
     * Cette méthode est la méthode qui se lance pour jouer la partie
     */
    public static void playGame() {
        System.out.println("----------- Bienvenue dans le jeu, vous démarrez une nouvelle partie -----------\n");
        int heroCount = inputParser.getNumberOfHeroes();
        heroes = inputParser.getHeroes(heroCount);
        do {
            generateCombat(heroCount);
            System.out.println("\n--- Vous avez gagné votre combat ---\n");
            heroes = inputParser.getAwards(heroes);
        } while (checkAliveHeroes());                            
        System.out.println("--- Vous avez perdu ! ---");
        System.out.println("--- La partie est terminée ---");
    }

    public static <T> void removeElement(List<T> list, T element) {        
        for (T e : list) {            
            if (element.equals(e)) {                
                list.remove(e);
                return;
            }
        }
    }

    /**
     * Cette méthode permet de générer chaque combat dans une partie, elle gère le tour à tour
     * @param heroCount
     */
    public static void generateCombat(int heroCount) {
            System.out.println("\n\n\n--- Nouveau combat pour les joueurs ---");
            boolean playerOrEnemy = true; // true si le tour du joueur, false si le tour de l'ennemi
            List<Enemy> enemies = generateEnemies(heroCount);
            int enemyTurn = 0;            
            while (areAliveEnemies(enemies) && checkAliveHeroes()) {
                // Le combat commence ice
                if (playerOrEnemy) { // Le tour du joueur ou de l'ennemi ?
                    System.out.println("\n\n===================================");
                    while (!heroes.get(playerTurn).isAlive()) {
                        playerTurn = (playerTurn + 1) % heroes.size(); // Ca permet de ne pas sortir de l'indice max du tableau des joueurs
                    }
                    System.out.println("C'est le tour du joueur " + (playerTurn) + " de jouer");

                    //Le tour du joueur                      
                    inputParser.playHero(heroes, heroes.get(playerTurn), enemies.get(enemyTurn), enemyTurn, playerTurn);                    
                    playerTurn = (playerTurn + 1) % heroes.size();
                    if (!enemies.get(enemyTurn).isAlive() && areAliveEnemies(enemies)) {
                        removeElement(enemies, enemies.get(enemyTurn)); // On enelve cet ennemi du tableau des ennemis car il est mort
                        enemyTurn = (enemyTurn + 1) % enemies.size(); // Le prohcain ennemi à jouer
                    }
                    playerOrEnemy = false; // On passe le tour à l'ennemi
                } else {
                    while (!enemies.get(enemyTurn).isAlive() && areAliveEnemies(enemies)) {
                        enemyTurn = (enemyTurn + 1) % enemies.size();
                    }
                    //Le tour de l'ennemi
                    enemies.get(enemyTurn).attack(heroes.get(playerTurn));
                    System.out
                            .println("\nL'ennemi " + enemyTurn + " inflige " + enemies.get(enemyTurn).getAttackPoints()
                                    + " points de dégats au joueur " + playerTurn);
                    int pv = heroes.get(playerTurn).getLifePoints() < 0 ? 0 : heroes.get(playerTurn).getLifePoints();
                    System.out.println("Le joueur " + playerTurn + " a " + pv + "PV");
                    if (pv == 0) {
                        System.out.println("Le joueur " + playerTurn + " est mort");
                        removeElement(heroes, heroes.get(playerTurn)); // On enleve ce joueur du tableau des joueurs car il est mort
                    }
                    enemyTurn = (enemyTurn + 1) % enemies.size(); // Le prochain ennemi à jouer
                    playerOrEnemy = true; // On passe le tour au joueur
                }
            }            
    }
    public static void main(String[] args) {
        playGame();
    }
}

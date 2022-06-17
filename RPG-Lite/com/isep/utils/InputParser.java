package com.isep.utils;

import com.isep.rpg.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private Scanner scanner;        

    public InputParser() {
        scanner = new Scanner(System.in);        
    }

    /**
     * Cette méthode permet d'avoir le nombre de joueurs 
     * @return
     */
    public int getNumberOfHeroes() {
        System.out.print("Veuillez entrer le nombre de joueurs : ");
        int heroCount = Integer.parseInt(scanner.nextLine());        
        return heroCount;
    }
    
    /**
     * Cette méthode permet de faire choisir à l'utilisateurs les héros qu'il veut
     * @param n
     * @return
     */
    public ArrayList<Hero> getHeroes(int n) {
        ArrayList<Hero> result = new ArrayList<Hero>();
        // Initialisation de la nourriture
        ArrayList<Food> food = new ArrayList<Food>();
        food.add(new Food(100, 0));
        food.add(new Food(150, 0));
        food.add(new Food(200, 0));

        //Initialisation des potions
        ArrayList<Potion> potions = new ArrayList<Potion>();
        potions.add(new Potion(0, 50));
        potions.add(new Potion(0, 100));
        potions.add(new Potion(0, 120));
        for (int i = 0; i < n; i++) {
            int choice;
            do {
                System.out.println("Choisissez le numéro du héros" + (i + 1) + " : ");
                System.out.print("1 - HUNTER | 2 - HEALER | 3 - MAGE | 4 - WARRIOR : ");
                choice = Integer.parseInt(scanner.nextLine());
            } while (choice < 1 || choice > 4);
            Hero hero;
            switch (choice) {
                case 1:
                    hero = new Hunter(300, 50, 100, potions, food, 10);
                    break;
                case 2:
                    hero = new Healer(300, 50, 100, potions, food, 150, 40);
                    break;
                case 3:
                    hero = new Mage(300, 50, 100, potions, food, 150);
                    break;
                case 4:
                    hero = new Warrior(300, 50, 100, potions, food);
                    break;
                default:
                    hero = new Warrior(300, 50, 100, potions, food);
                    break;
            }
            result.add(hero);
        }
        return result;
    }

    /*
     * Cette méthode permet de choisir quel consommable utiliser
     */
    public String chooseConsumable() {
        int choice;
        System.out.println("Choix des consommables");
        do {
            System.out.println("1 - Lembas");
            System.out.println("2 - Potion");
            System.out.print("Choisir : ");
            choice = Integer.parseInt(scanner.nextLine());
        } while (choice != 1 && choice != 2);
        switch (choice) {
            case 1:
                return "Lembas";
            case 2:
                return "Potion";
            default:
                return null;
        }
    }
    
    /**
     * Cette méthode est la méthode principale du jeu d'un joueur lors de son tour
     * @param heroes Le tableau qui contient tous les héros
     * @param hero le joueur entrain de jouer
     * @param enemy L'ennemi qui peut etre attaqué par le joueur au cas où il attaque
     * @param enemyTurn l'indice de l'ennemi
     * @param playerTurn l'indice du joueur
     */
    public void playHero(List<Hero> heroes, Hero hero, Enemy enemy, int enemyTurn, int playerTurn) {
        System.out.println("Le joueur est de type " + hero.getType());
        int choice;
        do {
            System.out.println("--- Actions possibles --- ");
            System.out.println("1 - Attaquer");
            System.out.println("2 - Défendre");
            System.out.println("3 - Utiliser un consommable");
            System.out.print("Choix : ");
            choice = Integer.parseInt(scanner.nextLine());
        } while (choice < 1 || choice > 3 || choice == 3 && !hero.hasConsumable());

        switch (choice) {
            case 1:
                hero.isDefending = false;
                if (heroes.get(playerTurn).getType().equals("Healer")) {
                    healAnotherHero((Healer) hero, heroes);
                } else {
                    hero.attack(enemy);
                    System.out.println(
                            "Le joueur " + playerTurn + " inflige " + hero.getWeaponDamage()
                                    + " points de dégâts à l'ennemi " + enemyTurn);
                    int enemyPv = enemy.getLifePoints() < 0 ? 0
                            : enemy.getLifePoints();
                    System.out.println("L'ennemi " + enemyTurn + " a " + enemyPv + " PV");
                    if (enemyPv == 0) {
                        System.out.println("L'ennemi " + enemyTurn + " est mort");
                    }
                }
                break;
            case 2:
                hero.defend();
                System.out.println("Le joueur se défend avec son bouclier");
                break;
            case 3:
                String consumable = chooseConsumable();
                if (consumable.equals("Lembas"))
                    hero.useConsumable(hero.getLembas().get(0));
                else
                    hero.useConsumable(hero.getPotions().get(0));
                break;
        }
    }
    
    /**
     * Cette méthode permet de choisir les récompenses après avoir gagner un match
     */
    public List<Hero> getAwards(List<Hero> heroes) {
        System.out.println("\n--- Le temps de récompenses ---\n");
        for (Hero hero : heroes) {
            int choice;
            do {
                System.out.println("1 - Augmenter son armure");
                System.out.println("2 - Augmenter les dégats de son arme");
                System.out.println("3 - Augmenter l'éfficacité de la potion et la nourriture");
                System.out.println("4 - Augmenter le nombre de potion et de nourriture");
                System.out.println("5 - Augmenter le nombre de flèches (choisir si Héros est Hunter)");
                System.out.print("Choix : ");
                choice = Integer.parseInt(scanner.nextLine());
            } while (choice < 1 || choice > 5);

            switch (choice) {
                case 1:
                    hero.setArmor(hero.getArmor() + 50);
                    break;
                case 2:
                    hero.setWeaponDamage(hero.getWeaponDamage() + 50);
                    break;
                case 3:
                    for (int i = 0; i < hero.getLembas().size(); i++) {
                        hero.getLembas().get(i).setLifePointsToAdd(hero.getLembas().get(i).getLifePointsToAdd() + 50);
                        hero.getPotions().get(i).setManaPointstoAdd(hero.getPotions().get(i).getLifePointsToAdd() + 50);
                    }
                    break;
                case 4:
                    hero.addPotion(new Potion(0, 50));
                    hero.addlembas(new Food(50, 0));
                    break;
                case 5:
                    if (hero.getType() == "Hunter") {
                        ((Hunter) hero).addArrow();
                    }
                    break;
                default:
                    break;
            }
        }
        return heroes;
    }
    
    /**
     * Cette méthode permer au Healer de soigner un autre joueur
     * @param healer
     * @param heroes
     */
    public void healAnotherHero(Healer healer, List<Hero> heroes) {
        System.out.println("--- Choix du héros à soigner ---");
        int choice;
        do {
            for (int i = 0; i < heroes.size(); i++) {
                System.out.println((i + 1) + " - Hero numéro " + i);
            }
            System.out.print("Choix : ");
            choice = Integer.parseInt(scanner.nextLine());
        } while (choice < 0 || choice > heroes.size());
        healer.heal(heroes.get(choice));
        System.out.println("Le " + heroes.get(choice).getType() + " a maintenant " + heroes.get(choice).getLifePoints() + "PV");
    }
    
}
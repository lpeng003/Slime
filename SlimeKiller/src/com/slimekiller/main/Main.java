package com.slimekiller.main;

//import java.util.*;


public class Main {

    public static void main(String[] args) {
        Hero player = new Hero();
        player.setHealth(100);
        //player.setAttack(50);

        int enemyCount = 10;
        while (enemyCount > 0) {
            Slime currentEnemy = new Slime();
            currentEnemy.setHealth(20);
            currentEnemy.setExperience(4);

            while (player.isAlive() && currentEnemy.isAlive()) {
                if (player.isAlive()) {
                    System.out.println("player health: " + player.getHealth());
                    System.out.println("slime health: " + currentEnemy.getHealth());
                    System.out.println("player attacks... "+player.doAttack(currentEnemy)+" damage!\n");
                }
                if (currentEnemy.isAlive()) {
                    System.out.println("player health: " + player.getHealth());
                    System.out.println("slime health: " + currentEnemy.getHealth());
                    System.out.println("slime attacks... "+currentEnemy.doAttack(player)+" damage!\n");
                }
            }
            //for user input later
            //Scanner reader = new Scanner(System.in);  // Reading from System.in
            //System.out.println("Enter a number: ");
            //int selection = reader.nextInt(); // Scans the next token of the input as an int.
            //System.out.println(n);

            if (!player.isAlive()) {
                System.out.println("you died");
                break;
            }
            System.out.println("slime killed... "+currentEnemy.getExperience()+"xp earned");
            player.addExperience(currentEnemy.getExperience());
            enemyCount--;
        }
        if(enemyCount == 0){
            System.out.println("good job, you beat all the slimes");
        }
    }
}

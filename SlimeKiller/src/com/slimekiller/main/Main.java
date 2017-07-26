package com.slimekiller.main;

//import java.util.*;


public class Main {

    public static void main(String[] args) {
        Hero player = new Hero();
        Slime enemy = new Slime(1);
        enemy.setHealth(20);
        enemy.setExperience(4);
        Combat combat = new Combat(player, enemy );

        int enemyCount = 1;
        while (enemyCount > 0) {
            combat.initiateCombat();


            if (!player.isAlive()) {
                System.out.println("you died");
                break;
            }
            System.out.println("Slime killed... "+enemy.getExperience()+"xp earned");
            player.addExperience(enemy.getExperience());
            enemyCount--;
        }
        if(enemyCount == 0){
            System.out.println("good job, you beat all the slimes");
        }
    }
}

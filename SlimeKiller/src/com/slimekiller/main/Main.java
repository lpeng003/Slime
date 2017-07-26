package com.slimekiller.main;

//import java.util.*;


public class Main {

    public static void main(String[] args) {
        Hero player = new Hero();
        BattleGround battle = new BattleGround(player);

        int enemyCount = 10;
        while (enemyCount > 0) {
            Slime enemy = new Slime(1);
            enemy.setHealth(20);
            enemy.setExperience(4);

            battle.add(enemy);

            battle.doBattle();
            //battleground.doBattle(enemy,player);

            //for user input later
            //Scanner reader = new Scanner(System.in);  // Reading from System.in
            //System.out.println("Enter a number: ");
            //int selection = reader.nextInt(); // Scans the next token of the input as an int.
            //System.out.println(n);

            if (!player.isAlive()) {
                System.out.println("you died");
                break;
            }
            //System.out.println("slime killed... "+enemy.getExperience()+"xp earned");
            //player.addExperience(enemy.getExperience());
            enemyCount--;
        }
        if(enemyCount == 0){
            System.out.println("good job, you beat all the slimes");
        }
    }
}

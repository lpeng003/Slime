package com.slimekiller.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Combat {
    private Hero currHero;
    private Slime currSlime;

    public Combat() {};

    public Combat(Hero a, Slime b) {

        currHero = a;
        currSlime = b;

    }

    public void initiateCombat() {

        Scanner userInputReader = new Scanner(System.in);
        int userInput;
        int dmg;
        boolean flag = true;
        //Display beginning combat dialogue
        String msg = "Fight Starts!";
        System.out.println(msg);

        System.out.println(currHero.getName() + " vs. " + currSlime.getName());

        while(flag) {
            System.out.println("Choose your action: ");
            System.out.println("1: Attack");
            System.out.println("2: Block");

            userInput = userInputReader.nextInt();
            switch(userInput) {
                case 1: dmg = currHero.doAttack(currSlime);
                        System.out.println("You did " +dmg+" to " +currSlime.getName());
                        System.out.println(currSlime.getName() + " has " + currSlime.getHealth() + " health left");
                        break;
                case 2:
                        break;
                default:
                        System.out.println("Invalid Action");

            }

            if(!currSlime.isAlive() || !currHero.isAlive()) {flag = false;}
        }







    }



}

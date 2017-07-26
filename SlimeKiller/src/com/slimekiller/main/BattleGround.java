package com.slimekiller.main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BattleGround {
    private ArrayList<Unit> fighters;

    public BattleGround(Unit entrant) {
        fighters = new ArrayList<>(1);
        fighters.add(entrant);
    }


    public void add(Unit u){
        fighters.add(u);
    }

    public void doBattle(){
        while (numberAlive() > 1) {
            for(Unit u:fighters){
                if(u.isAlive()){
                    doTurn(u);
                }
            }
        }
    }



/*
            if (unit1.isAlive()) {
                System.out.println(unit1.getName()+" health: " + unit1.getHealth());
                System.out.println(unit2.getName()+" health: " + unit2.getHealth());
                System.out.println(unit1.getName()+" attacks... "+unit1.doAttack(unit2)+" damage!\n");
            }
 */


    private void doTurn(Unit u){
        if(u.isPlayerControlled()){
            getUserChoice(u);
        }
        else {
            System.out.println("run enemy ai for "+u.getName());
            //u.enemyai();
        }
    }
    private int numberAlive(){
        int nAlive = 0;
        for(Unit u:fighters){
            if(u.isAlive()){
                nAlive++;
            }
        }
        return nAlive;
    }
    private int numberPlayerControlledAlive(){
        int nAlive = 0;
        for(Unit u:fighters){
            if(u.isAlive() && u.isPlayerControlled()){
                nAlive++;
            }
        }
        return nAlive;
    }

    private void getUserChoice(Unit u){
        //Expand this method to allow the player to do other things besides just choose to attack a target
        // such as using items or other types of attacks like magic
        printHealths();
        showChoices(u);
        int choice = getUserInt(2);
        switch (choice){
            case 1:
                //attack
                ArrayList<Unit> targets = enemyUnits();
                showPossibleTargets(targets);
                int targetNumber = getUserInt(targets.size())-1;  //subtract 1 so player choices can start at 1 instead of 0
                System.out.println(u.getName()+" does "+u.doAttack(targets.get(targetNumber))+" damage to "+targets.get(targetNumber).getName());
                break;
            case 2:
                System.out.println("this isn't currently implemented");
                break;
        }
        //get an int corresponding to choice from user

    }

    private void showChoices(Unit u){

        System.out.println("1.attack");
        System.out.print("select an action:");
    }

    private void showPossibleTargets(ArrayList<Unit> targets){


        int n = 1;
        for(Unit target:targets){
            System.out.printf("%d. %s\n",n,target.getName());
            n++;
        }
        System.out.print("choose a target:");
    }

    private ArrayList<Unit> enemyUnits(){
        ArrayList<Unit> enemies = new ArrayList<>();
        for(Unit u:fighters){
            if(!u.isPlayerControlled()){
                enemies.add(u);
            }
        }
        return enemies;
    }
    private ArrayList<Unit> playerControlledUnits(){
        ArrayList<Unit> controllable = new ArrayList<>();
        for(Unit u:fighters){
            if(!u.isPlayerControlled()){
                controllable.add(u);
            }
        }
        return controllable;
    }

    private int getUserInt(int maxNum){
        //gets an int from player from between 1 and maxNum inclusive
        int n = -1;
        while(n<1 || n>maxNum) {
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            n = reader.nextInt(); // Scans the next token of the input as an int.
        }
        return n;
    }

    private void printHealths(){
        for(Unit u:fighters){
            System.out.println(u.getName()+" health: " + u.getHealth());
        }
    }
}

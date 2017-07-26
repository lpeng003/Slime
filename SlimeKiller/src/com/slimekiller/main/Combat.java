package com.slimekiller.main;

import java.util.ArrayList;

public class Combat {
    private Hero currHero;
    private Slime currSlime;


    public Combat(Hero a, Slime b) {

        currHero = a;
        currSlime = b;

    }

    private void initiateCombat() {

        //Display beginning combat dialogue
        String msg = "Fight Starts!";
        System.out.println(msg);



    }



}

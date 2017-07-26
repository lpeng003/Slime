package com.slimekiller.main;

/**
 * Created by leonp on 7/13/2017.
 */
public class Slime extends Unit {

    Slime() {
        setName("Slime");
        setMaxHealth(10);
        setHealth(10);
        setMaxMana(0);
        setMana(0);
        setAttack(5);
        setDefence(5);

        setLevel(1);
        setExperience(1);


    }

    Slime(int lvl) {
        setName("Slime");
        setPlayerControlled(false);
        setMaxHealth(10);
        setHealth(10);
        setMaxMana(0);
        setMana(0);
        setAttack(2*lvl);
        setDefence(2*lvl);

        setLevel(lvl);
        setExperience(2*lvl);
    }
}

package com.slimekiller.main;

/**
 * Created by leonp on 7/13/2017.
 */
public class Hero extends Unit {



    public Hero() {
        setName("generic guy");
        setPlayerControlled(true);
        setMaxHealth(100);
        setHealth(100);
        setMaxMana(100);
        setMana(100);
        setAttack(10);
        setDefence(0);
        setLevel(1);
        setExperience(0);
        setLevelUpExperience();
    }


}

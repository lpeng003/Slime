package com.slimekiller.main;

/**
 * Created by leonp on 7/13/2017.
 */
public abstract class Unit {
    private int maxHealth;
    private int health;
    private int maxMana;
    private int mana;
    private int level;
    private int experience;

    private int attack;
    private int defence;
    private int levelUpExperience;




    Unit() {
        maxHealth = 1;
        health = 1;
        maxMana = 1;
        mana = 1;
        attack = 1;
        defence = 1;
    }
    private int experienceRequired(int lvl) {
        //for now the experience scaling is level^2, it should probably changed to something else
        return lvl*lvl+10;
    }
    private void levelUp() {
        level++;
        attack += 1;
        defence += 1;
    }

    public void setHealth(int hp) {health = hp;}
    public void setMaxHealth(int maxHp) {maxHealth = maxHp;}
    public void setMana(int mp) {mana = mp;}
    public void setMaxMana(int maxMp) {maxMana = maxMp;}
    public void setAttack(int atk) {attack = atk;}
    public void setDefence(int def) {defence = def;}
    public void setLevel(int lvl) {level = lvl;}
    public void setExperience(int exp) {experience = exp;}
    public void setLevelUpExperience() {levelUpExperience = experienceRequired(level);}

    public int getAttack() {return attack;}
    public int getDefence() {return defence;}
    public int getHealth() {return health;}
    public int getExperience() {return experience;}

    public void addHealth(int num) {
        health = (num + health >= maxHealth) ? maxHealth : (health + num);
    }
    public void subHealth(int num) {
        health = (health - num <= 0) ? 0 : (health - num);
    }
    public void addMana(int num) {
        mana = (num + mana >= maxMana) ? maxMana : (mana + num);
    }
    public void subMana(int num) {
        mana = (mana - num <= 0) ? 0 : (mana - num);
    }
    public void addExperience(int exp){
                experience += exp;
                while (experience >= levelUpExperience) {
                    levelUp();
                    experience -= levelUpExperience;
                    levelUpExperience = experienceRequired(level);
                    System.out.println("leveled up to level "+level+"!");
        }
        System.out.println("you now have "+experience+"/"+levelUpExperience+"xp");
    }

    public boolean isAlive() {return health > 0;}

    public int doAttack(Unit target) {
        int damageDealt = attack - target.defence;
        target.subHealth(damageDealt);
        return damageDealt;
    }
}

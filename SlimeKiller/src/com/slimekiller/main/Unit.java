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

    Unit() {
        maxHealth = 1;
        health = 1;
        maxMana = 1;
        mana = 1;
        attack = 1;
        defence = 1;
    }

    public void setHealth(int hp) {health = hp;}
    public void setMaxHealth(int maxHp) {maxHealth = maxHp;}
    public void setMana(int mp) {mana = mp;}
    public void setMaxMana(int maxMp) {maxMana = maxMp;}
    public void setAttack(int atk) {attack = atk;}
    public void setDefence(int def) {defence = def;}
    public void setLevel(int lvl) {level = lvl;}
    public void setExperience(int exp) {experience = exp;}

    public int getAttack() {return attack;}
    public int getDefence() {return defence;}
    public int getHealth() {return health;}

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

    public boolean isAlive() {return health > 0;}

    public int doAttack(Unit target) {
        int damageDealt = attack - target.defence;
        target.subHealth(damageDealt);
        return damageDealt;
    }
}

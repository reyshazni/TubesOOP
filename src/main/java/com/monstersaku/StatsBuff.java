package com.monstersaku;

public class StatsBuff {
    // Atribut
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    // Konstruktor
    public StatsBuff() {
        attack = 0;
        defense = 0;
        specialAttack = 0;
        specialDefense = 0;
        speed = 0;
    }

    // Getter
    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    // Setter
    public void setAttack(int attack){
        if (attack > 4) {
            this.attack = 4;
        } else if (attack < -4) {
            this.attack = -4;
        } else {
            this.attack = attack;
        }
    }

    public void setDefense(int defense){
        if (defense > 4) {
            this.defense = 4;
        } else if (defense < -4) {
            this.defense = -4;
        } else {
            this.defense = defense;
        }
    }

    public void setSpecialAttack(int specialAttack){
        if (specialAttack > 4) {
            this.specialAttack = 4;
        } else if (specialAttack < -4) {
            this.specialAttack = -4;
        } else {
            this.specialAttack = specialAttack;
        }
    }

    public void setSpecialDefense(int specialDefense){
        if (specialDefense > 4) {
            this.specialDefense = 4;
        } else if (specialDefense < -4) {
            this.specialDefense = -4;
        } else {
            this.specialDefense = specialDefense;
        }
    }

    public void setSpeed(int speed){
        if (speed > 4) {
            this.speed = 4;
        } else if (speed < -4) {
            this.speed = -4;
        } else {
            this.speed = speed;
        }
    }

    // Other Method
    public double factor(int num) {
        if (num == -4) {
            return (double)(2/6);
        } else if (num == -3) {
            return (double)(2/5);
        } else if (num == -2) {
            return (double)(2/4);
        } else if (num == -1) {
            return (double)(2/3);
        } else if (num == 0) {
            return (double)(1);
        } else if (num == 1) {
            return (double)(3/2);
        } else if (num == 2) {
            return (double)(4/2);
        } else if (num == 3) {
            return (double)(5/2);
        } else if (num == 4) {
            return (double)(6/2);
        }
    }
}   

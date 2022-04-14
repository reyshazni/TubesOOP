package com.monstersaku;

public class Stats {
    // Atribut
    public final double maxHealthPoint;
    private double healthPoint;
    private double attack;
    private double defense;
    private double specialAttack;
    private double specialDefense;
    private double speed;

    // Konstruktor
    public Stats() {
        maxHealthPoint = 0.0;
        healthPoint = 0.0;
        attack = 0.0;
        defense = 0.0;
        specialAttack = 0.0;
        speed = 0.0;
    }

    public Stats(double maxHealthPoint, double healthPoint, double attack, double defense, double specialAttack,
            double specialDefense, double speed) {
        this.maxHealthPoint = maxHealthPoint;
        this.healthPoint = healthPoint;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    // Getter

    public double getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public double getHealthPoint() {
        return healthPoint;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public double getSpecialAttack() {
        return specialAttack;
    }

    public double getSpecialDefense() {
        return specialDefense;
    }

    public double getSpeed() {
        return speed;
    }

    // Setter
    public void setHealthPoint(double healthPoint) {
        this.healthPoint = healthPoint;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public void setSpecialAttack(double specialAttack) {
        this.specialAttack = specialAttack;
    }

    public void setSpecialDefense(double specialDefense) {
        this.specialDefense = specialDefense;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void showStats() {
        System.out.println("Max Health Point      : " + this.maxHealthPoint);
        System.out.println("Current Health Point  : " + this.healthPoint);
        System.out.println("Attack                : " + this.attack);
        System.out.println("Defense               : " + this.defense);
        System.out.println("Special Attack        : " + this.specialAttack);
        System.out.println("Special Defense       : " + this.specialDefense);
        System.out.println("Speed                 : " + this.speed);
    }
}

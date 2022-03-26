package com.monstersaku;

public class Stats {
    // Atribut
    private double healthPoint;
    private double attack;
    private double defense;
    private double specialAttack;
    private double specialDefense;
    private double speed;

    // Konstruktor
    public Stats() {
        healthPoint = 0.0;
        attack = 0.0;
        defense = 0.0;
        specialAttack = 0.0;
        speed = 0.0;
    }

    // Getter
    public double getBaseHealthPoint() {
        return healthPoint;
    }

    public double getBaseAttack() {
        return attack;
    }

    public double getBaseDefense() {
        return defense;
    }

    public double getBaseSpecialAttack() {
        return specialAttack;
    }

    public double getBaseSpecialDefense() {
        return specialDefense;
    }

    public double getBaseSpeed() {
        return speed;
    }

    // Setter
    public void setHealthPoint(double healthPoint){
        this.healthPoint = healthPoint;
    }

    public void setAttack(double attack){
        this.attack = attack;
    }

    public void setDefense(double defense){
        this.defense = defense;
    }

    public void setSpecialAttack(double specialAttack){
        this.specialAttack = specialAttack;
    }

    public void setSpecialDefense(double specialDefense){
        this.specialDefense = specialDefense;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }
}   

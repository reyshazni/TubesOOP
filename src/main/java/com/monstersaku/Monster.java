package com.monstersaku;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monster implements StatusCondition {
    private int id;
    private String name;
    private List<ElementType> elementTypes = new ArrayList<ElementType>();
    private Stats baseStats;
    private List<Move> moves = new ArrayList<Move>();
    private boolean isAlive;
    private String statusCondition = "NONE";
    private boolean isSleeping;
    private int sleepDuration;

    // Konstruktor untuk read
    public Monster() {

    }

    public Monster(int id, String name, List<ElementType> elementTypes, Stats basesStats) {
        this.id = id;
        this.name = name;
        this.elementTypes = elementTypes;
        this.baseStats = basesStats;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ElementType> getElementTypes() {
        return elementTypes;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public String getStatusCondition() {
        return statusCondition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setElementTypes(List<ElementType> elementTypes) {
        this.elementTypes = elementTypes;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setBaseStats(Stats baseStats) {
        this.baseStats = baseStats;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void showMonsterInfo() {
        System.out.println("Id Monster : " + this.id);
        System.out.println("Nama : " + this.name);
        System.out.println("Elements : ");
        for (int i = 0; i < this.elementTypes.size(); i++) {
            System.out.printf("(%d) %s\n", i + 1, this.elementTypes.get(i));
        }
        System.out.println("Stats : ");
        this.baseStats.showStats();
        System.out.println("Moves : ");
        this.showMove();
    }

    public void showMove() {
        for (int i = 0; i < this.moves.size(); i++) {
            if (this.moves.get(i) != null) {
                System.out.printf("(%d) %s, Ammunition : %d\n", i + 1, this.moves.get(i).getName(),
                        this.moves.get(i).getAmmunition());
            }
        }
    }

    public void takeDamage(double damageAttack) {
        double healthPointAfter = this.baseStats.getHealthPoint() - damageAttack;
        if (healthPointAfter <= 0) {
            this.isAlive = false;
            System.out.println(this.name + " has died");
            this.baseStats.setHealthPoint(0);
        } else {
            this.baseStats.setHealthPoint(healthPointAfter);
            ;
            System.out.println("Current health point of " + this.name + " = " + healthPointAfter);
        }
    }

    public void setStatusConditon(String statusCondition) {
        this.statusCondition = statusCondition;
    }

    public void EffectStatusCondition(String statusCondition) {
        double maxHP = baseStats.getMaxHealthPoint();
        switch (statusCondition) {
            case "NONE":
                System.out.println();
            case "BURN":
                System.out.println(this.name + " terkena BURN!");
                System.out.printf("Health Point %s yang terkena BURN akan berkurang %d setiap Turn!\n", this.name,
                        (int) maxHP * (1 / 8));
                burn();
            case "POISON":
                System.out.println(this.name + "terkena POISON!");
                System.out.printf("Health Point %s yang terkena POISON akan berkurang %d setiap Turn!\n", this.name,
                        (int) maxHP * (1 / 16));
                poison();
            case "SLEEP":
                System.out.println(this.name + "terkena SLEEP!");
                System.out.printf("Segala Move yang dipilih oleh %s tidak akan dieksekusi!\n", this.name);
                sleep();
            case "PARALYZE":
                System.out.println(this.name + "terkena PARALYZE");
                System.out.printf("Speed %s yang terkena PARALYZE akan berkurang 50% menjadi %d\n", this.name,
                        (int) maxHP * (1 / 16));
                System.out.printf("Terdapat 25% kemungkinan %s tidak dapat bergerak!\n", this.name);
                paralyze();
        }
    }

    public void burn() {
        double damage = Math.floor((baseStats.getMaxHealthPoint()) * (1 / 8));
        double healthPoint = (baseStats.getHealthPoint());
        if (damage > healthPoint) {
            damage = healthPoint;
        }

        // Set healthPoint setelah terkena damage burn
        baseStats.setHealthPoint(baseStats.getHealthPoint() - damage);
    }

    public void poison() {
        double damage = Math.floor((baseStats.getMaxHealthPoint()) * (1 / 16));
        double healthPoint = (baseStats.getHealthPoint());
        if (damage > healthPoint) {
            damage = healthPoint;
        }

        // Set healthPoint setelah terkena damage poison
        baseStats.setHealthPoint(healthPoint - damage);
    }

    public void sleep() {
        int sleepDuration = 1 + (int) (Math.random() * 7);
        this.isSleeping = true;
        this.sleepDuration = sleepDuration;
        System.out.printf("%s akan terkena SLEEP selama %d Turn.\n", this.name, sleepDuration);
    }

    public void paralyze() {
        // Set speed setelah terkena paralyze
        double speed = (baseStats.getSpeed() * 0.5);
        baseStats.setSpeed(speed);

        int randomNum = 1 + (int) (Math.random() * 4);
        if (randomNum == 1) {
            this.isSleeping = true;
            this.sleepDuration = 1;
            System.out.printf("%s tidak dapat bergerak!\n", this.name);
        }
    }

    public void reduceSleepDuration() {
        this.sleepDuration--;
    }
}

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
    private String statusCondition;

    // Konstruktor untuk read
    public Monster(int id, String name, List<ElementType> elementTypes, Stats basesStats) {
        this.id = id;
        this.name = name;
        this.elementTypes = elementTypes;
        this.baseStats = basesStats;
    }

    public static Monster copyMonster(Monster m) {
        Monster newMonster = new Monster(m.getId(), m.getName(), m.getElementTypes(), m.getBaseStats());
        newMonster.setMoves(m.getMoves());
        return newMonster;
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
            System.out.printf("(%d) %s\n", i + 1, this.moves.get(i).getName());
        }
    }

    public void takeDamage(double damageAttack) {
        double healthPointAfter = this.baseStats.getHealthPoint() - damageAttack;
        if (healthPointAfter <= 0) {
            this.isAlive = false;
            System.out.println(this.name + " has died");
        } else {
            this.baseStats.setHealthPoint(healthPointAfter);
            ;
            System.out.println("Current health point of " + this.name + " = " + healthPointAfter);
        }
    }

    public void setStatusCondiiton(String statusCondition) {
        this.statusCondition = statusCondition;
    }

    public void EffectStatusCondition() {
        if (statusCondition.equals("BURN")) {
            burn();
            System.out.println(this.name + " got burn");
        } else if (statusCondition.equals("POISON")) {
            poison();
            System.out.println(this.name + " got poison");
        } else if (statusCondition.equals("SLEEP")) {
            sleep();
            System.out.println(this.name + " got sleep");
        } else if (statusCondition.equals("PARALYZE")) {
            paralyze();
            System.out.println(this.name + " got paralyze");
        }
    }

    public void burn() {
        double damage = (baseStats.getMaxHealthPoint()) * (1 / 8);
        baseStats.setHealthPoint(baseStats.getHealthPoint() - damage);

        // terus ini damage outputnya berkurang 50% tapi bingung gimana -- bantu jawab
        // uda diimplementasiin di move
    }

    public void poison() {
        double damage = (baseStats.getMaxHealthPoint()) * (1 / 16);
        baseStats.setHealthPoint(baseStats.getHealthPoint() - damage);
    }

    public int sleep() {
        int sleepTurn = 1 + (int) (Math.random() * 7);
        return sleepTurn;
    }

    public void paralyze() {
        double speed = (baseStats.getSpeed() * 0.5);
        baseStats.setSpeed(speed);

        int randomNum = 1 + (int) (Math.random() * 4);
        if (randomNum == 1) {
            // gabisa gerak
        }
    }

    public void setStatusCondition(String statusCondition) {
        this.statusCondition = statusCondition;
    }
}

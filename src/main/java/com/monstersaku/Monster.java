package com.monstersaku;

import java.util.ArrayList;
import java.util.List;

public class Monster implements StatusCondition {
    private int id;
    private String name;
    private List<ElementType> elementTypes = new ArrayList<ElementType>();
    private Stats baseStats;
    private List<Move> moves = new ArrayList<Move>();
    private boolean isAlive = true;
    private String statusCondition = "NONE";
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

    public int getSleepDuration(){
        return this.sleepDuration;
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

    public void burn() {
        double damage = Math.floor((baseStats.getMaxHealthPoint()) * (0.125));
        double healthPoint = (baseStats.getHealthPoint());
        if (damage > healthPoint) {
            damage = healthPoint;
        }

        // Set healthPoint setelah terkena damage burn
        baseStats.setHealthPoint(baseStats.getHealthPoint() - damage);
    }

    public void poison() {
        double damage = Math.floor((baseStats.getMaxHealthPoint()) * (0.0625));
        double healthPoint = (baseStats.getHealthPoint());
        if (damage > healthPoint) {
            damage = healthPoint;
        }

        // Set healthPoint setelah terkena damage poison
        baseStats.setHealthPoint(healthPoint - damage);
    }

    public void sleep() {
        int sleepDuration = 1 + (int) (Math.random() * 7);
        this.sleepDuration = sleepDuration;
        System.out.printf("%s akan terkena SLEEP selama %d Turn.\n", this.name, sleepDuration);
    }

    public void paralyze() {
        // Set speed setelah terkena paralyze
        double speed = (baseStats.getSpeed() * 0.5);
        baseStats.setSpeed(speed);

        int randomNum = 1 + (int) (Math.random() * 4);
        if (randomNum == 1) {
            this.sleepDuration = 1;
            System.out.printf("%s tidak dapat bergerak!\n", this.name);
        }
    }

    public void reduceSleepDuration() {
        if (this.sleepDuration > 0) {
            this.sleepDuration--;
        } else {
            this.statusCondition = "NONE";
        }
    }
}

package com.monstersaku.util.Game;


// Class untuk menghitung effect dan mengatur statsbuff
public class Effect {
    private String statusCondition;
    private int[] statsPoint = new int[6];

    public Effect() {
        statusCondition = "-";
        for (int i = 0; i < statsPoint.length; i++) {
            statsPoint[0] = 0;
        }
    }

    public Effect(String statusConditon) {
        this.statusCondition = statusConditon;
        for (int i = 0; i < statsPoint.length; i++) {
            statsPoint[0] = 0;
        }
    }

    public Effect(int attack) {
        statusCondition = "-";
        statsPoint[1] = attack;
    }

    public Effect(int[] statsPoint) {
        statusCondition = "-";
        this.statsPoint = statsPoint;
    }

    public Effect(String statusCondition, int[] statsPoint) {
        this.statusCondition = statusCondition;
        this.statsPoint = statsPoint;
    }

    public int getHealthPoint() {
        return statsPoint[0];
    }

    public int getAttack() {
        return statsPoint[1];
    }

    public int getDefense() {
        return statsPoint[2];
    }

    public int getSpecialAttack() {
        return statsPoint[3];
    }

    public int getSpecialDefense() {
        return statsPoint[4];
    }

    public int getSpeed() {
        return statsPoint[5];
    }

    public String getStatusCondition() {
        return statusCondition;
    }

    public int[] getStatsPoint() {
        return statsPoint;
    }

    // Converted Stats
    public static double convertedToFactorBuff(double stat, int statBuff) {
        double value = 1;
        double d2 = 2;
        if (statBuff == 0) {
            value = Math.floor(stat * 1);
        } else if (statBuff == 1) {
            value = Math.floor(stat * 3 / d2);
        } else if (statBuff == 2) {
            value = Math.floor(stat * 4 / d2);
        } else if (statBuff == 3) {
            value = Math.floor(stat * 5 / d2);
        } else if (statBuff == 4) {
            value = Math.floor(stat * 6 / d2);
        } else if (statBuff == -1) {
            value = Math.floor(stat * d2 / 3);
        } else if (statBuff == -2) {
            value = Math.floor(stat * d2 / 4);
        } else if (statBuff == -3) {
            value = Math.floor(stat * d2 / 5);
        } else if (statBuff == -4) {
            value = Math.floor(stat * d2 / 6);
        }
        return value;
    }

    public void printDetailEffect() {
        System.out.println("statusCondition: " + statusCondition);
        System.out.printf("statusBuff: ");
        for (int stat : statsPoint) {
            System.out.printf("%s ", stat);
        }
        System.out.println();
    }
}
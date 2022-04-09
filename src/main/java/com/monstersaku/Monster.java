package com.monstersaku;

import java.util.ArrayList;
import java.util.List;

public class Monster {
    private int id;
    private String name;
    private List<ElementType> elementTypes = new ArrayList<ElementType>();
    private Stats baseStats;
    private List<Move> moves = new ArrayList<Move>();
    private boolean isAlive;
    private String statusCondition;

    //Konstruktor untuk read
    public Monster(int id, String name, List<ElementType> elementTypes, Stats basesStats) {
        this.id = id;
        this.name = name;
        this.elementTypes = elementTypes;
        this.baseStats = basesStats;
    }

    public int getId() {
        return id;
    }

    public String getname() {
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

    public void setStatusCondiiton(String statusCondition){
        this.statusCondition = statusCondition;
    }

    public String getStatusCondition(){
        return this.statusCondition;
    }

    public void EffectStatusCondition(){
        if (statusCondition.equals("BURN")){
            burn();
        } else if (statusCondition.equals("POISON")){
            poison();
        } else if (statusCondition.equals("SLEEP")){
            sleep();
        } else if (statusCondition.equals("PARALYZE")){
            paralyze();
        }
    }

    public void burn(){
        double damage = (baseStats.getMaxHealthPoint())*(1/8);
        baseStats.setHealthPoint(baseStats.getHealthPoint() - damage);

        // terus ini damage outputnya berkurang 50% tapi bingung gimana
    }

    public void poison(){
        double damage = (baseStats.getMaxHealthPoint())*(1/16);
        baseStats.setHealthPoint(baseStats.getHealthPoint() - damage);
    }

    public int sleep(){
        int sleepTurn = 1 + (int)(Math.random()*7);
        return sleepTurn;
    }

    public void paralyze(){
        double speed = (baseStats.getSpeed() * 0.5);
        baseStats.setSpeed(speed);

        int randomNum = 1 +(int)(Math.random()*4);
        if (randomNum == 1){
            // gabisa gerak
        }

    }
}

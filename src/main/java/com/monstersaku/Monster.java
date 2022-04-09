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

    public boolean getIsAlive() {
        return isAlive;
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

    public void showMonsterInfo(){
        System.out.println("Id Monster : " + this.id);
        System.out.println("Nama : " + this.name);
        System.out.println("Elements : ");
        for (int i=0; i<this.elementTypes.size(); i++){
            System.out.printf("(%d) %s\n", i+1, this.elementTypes.get(i));
        }
        System.out.println("Stats : "); 
        this.baseStats.showStats();
        System.out.println("Moves : "); 
        this.showMove();
    }

    public void showMove(){
        for (int i=0; i<this.moves.size(); i++) {
            System.out.printf("(%d) %s\n", i+1, this.moves.get(i).getName());
        }
    }

    public void takeDamage(double damageAttack){
        double healthPointAfter = this.baseStats.getHealthPoint() - damageAttack;
        this.baseStats.setHealthPoint(healthPointAfter);
        if (healthPointAfter<=0){
            this.isAlive = false;
        }
    }
}

package com.monstersaku;

import java.util.ArrayList;
import java.util.List;

public class Monster {
    private int id;
    private String name;
    private List<ElementType> elementTypes = new ArrayList<ElementType>();
    private Stats baseStats;
    private List<Move> moves = new ArrayList<Move>();
    private String statusCondition;
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

    public void setStatusCondition(String statusCondition) {
        this.statusCondition = statusCondition;
    }
}

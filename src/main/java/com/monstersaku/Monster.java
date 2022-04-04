package com.monstersaku;

import java.util.ArrayList;
import java.util.List;

public class Monster {
    private int id;
    private String nama;
    private List<ElementType> elementTypes = new ArrayList<ElementType>();
    private Stats baseStats;
    private List<Move> moves = new ArrayList<Move>();
    private boolean isAlive;


    //Konstruktor for read
    public Monster(int id, String nama, List<ElementType> elementTypes, Stats basesStats) {
        this.id = id;
        this.nama = nama;
        this.elementTypes = elementTypes;
        this.baseStats = basesStats;
        isAlive = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
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
    
    public void setNama(String nama) {
        this.nama = nama;
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

    public void killMonster() {
        this.isAlive = false;
    }
}

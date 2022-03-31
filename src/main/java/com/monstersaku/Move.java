package com.monstersaku;

public class Move {
    // Atribut
    private String name;
    private ElementType elementType;
    private int accuracy;
    private int priority;
    private int ammunition;

    // Konstruktor
    public Move(String name, ElementType elementType, int accuracy, int priority, int ammunition) {
        this.name = name;
        this.elementType = elementType;
        this.accuracy = 0;
        this.priority = 0;
        this.ammunition = 0;
    }

    // Getter
    public String name() {
        return name;
    }

    public ElementType elementType() {
        return elementType;
    }

    public int accuracy() {
        return accuracy;
    }

    public int priority() {
        return priority;
    }

    public int ammunition() {
        return ammunition;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    public void setDamage() { // Butuh class Monster

    }
}

package com.monstersaku;

public abstract class Move {
    // Atribut
    private int id;
    private String name;
    private ElementType elementType;
    private int accuracy;
    private int priority;
    private int ammunition;
    private int currentAmmo;

    // Konstruktor
    public Move(int id, String name, ElementType elementType, int accuracy, int priority, int ammunition) {
        this.id = id;
        this.name = name;
        this.elementType = elementType;
        this.accuracy = 0;
        this.priority = 0;
        this.ammunition = 0;
        this.currentAmmo = ammunition;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPriority() {
        return priority;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public int getCurrentAmmo() {
        return currentAmmo;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

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
}

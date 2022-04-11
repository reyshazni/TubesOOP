package com.monstersaku;

import com.monstersaku.util.Game.Effect;

public abstract class Move {
    // Atribut
    private int id;
    private String moveType;
    private String name;
    private ElementType elementType;
    private int accuracy;
    private int priority;
    private int ammunition;
    private int currentAmmo;
    private String target;
    private Effect effect;

    // Konstruktor
    // Kosong
    public Move() {

    }

    // Mengcopy move lain
    public Move(Move move) {
        this.copyMove(move);
    }

    // Konstruktor Penuh
    public void move(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
            int ammunition, String target, Effect effect) {
        this.id = id;
        this.moveType = moveType;
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
        this.currentAmmo = ammunition;
        this.target = target;
        this.effect = effect;
    }

    public void copyMove(Move move) {
        this.id = move.getId();
        this.moveType = move.getMoveType();
        this.name = move.getName();
        this.elementType = move.getElementType();
        this.accuracy = move.getAccuracy();
        this.priority = move.getPriority();
        this.ammunition = move.getAmmunition();
        this.target = move.getTarget();
        this.effect = move.getEffect();
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getMoveType() {
        return moveType;
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

    public String getTarget() {
        return target;
    }

    public Effect getEffect() {
        return effect;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
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

    public void setTarget(String target) {
        this.target = target;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}

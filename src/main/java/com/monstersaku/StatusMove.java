package com.monstersaku;

public class StatusMove extends Move {
    private String target;
    private StatusCondition statCondition;
    private Stats statMove;

    public StatusMove(){
        
    }

    public StatusMove(int id, String name, ElementType elementType, int accuracy, int priority, int ammunition,
    String target, StatusCondition statCondition, Stats statMove) {
        super(id, name, elementType, accuracy, priority, ammunition);
        this.target = target;
        this.statCondition = statCondition;
        this.statMove = statMove;
    }

    public String getTarget() {
        return target;
    }
    public StatusCondition getStatCondition() {
        return statCondition;
    }
    public Stats getStatMove() {
        return statMove;
    }
}

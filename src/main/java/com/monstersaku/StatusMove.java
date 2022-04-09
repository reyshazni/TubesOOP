package com.monstersaku;
import com.monstersaku.util.Game.*;

public class StatusMove extends Move {
    private String target;
    private StatusCondition statCondition;
    private Stats statMove;

    public StatusMove(){
        
    }

    public StatusMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority, 
    int ammunition, String target, Effect effect, StatusCondition statCondition, Stats statMove) {
        move(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect);
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

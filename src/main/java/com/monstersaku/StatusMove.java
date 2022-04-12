package com.monstersaku;

import com.monstersaku.util.Game.*;
import java.util.*;

public class StatusMove extends Move {
    private String target;
    private StatusCondition statCondition;
    private Stats statMove;

    public StatusMove() {
        super();
    }

    public StatusMove(Move move) {
        super(move);
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


    // CAUTION!!! belom ada efek samsek
    public void setDamage(Player playerAttack, Player playerDefend, Scanner myObj) {
        
        Monster source = playerAttack.getCurrentMonster();
        Monster target = playerDefend.getCurrentMonster();

        if (source.getBaseStats().getHealthPoint() <= 0) {
            ifMonsterAlive(source, playerAttack, myObj);
        }
        else {
            System.out.println("BELOM ADA EFEK");
        }
    }
}

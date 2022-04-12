package com.monstersaku;

import java.util.*;
import com.monstersaku.util.Game.*;

public class NormalMove extends Move {
    private int basePower;

    public NormalMove() {
        super();
    }

    public NormalMove(Move move) {
        super(move);
    }

    public NormalMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
            int ammunition, String target, Effect effect, int basePower) {
        move(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect);
        this.basePower = basePower;
    }

    public int getBasePower() {
        return basePower;
    }

    public void setDamage(Player playerAttack, Player playerDefend, Scanner myObj) {
        
        Monster source = playerAttack.getCurrentMonster();
        Monster target = playerDefend.getCurrentMonster();
        if (source.getBaseStats().getHealthPoint() <= 0) {
            ifMonsterAlive(source, playerAttack, myObj);
        }
        else {
            double rdmNumber = (Math.random()*(1-0.85+1)+0.85);
            double burnEffect = 1;
    
            double effective = 1;
            for (ElementType et : target.getElementTypes()) {
                effective = com.monstersaku.util.EffectivityConfig.getEffectivity(this.getElementType(), et);
            }
            if (source.getStatusCondition() == "BURN") {
                burnEffect = 0.5;
            }
            double damageAttack = Math
                    .floor((getBasePower() * (source.getBaseStats().getAttack() / target.getBaseStats().getDefense() + 2)
                            * rdmNumber * effective * burnEffect));
    
            double currentHP;
            currentHP = target.getBaseStats().getHealthPoint() - damageAttack;
    
            if (currentHP <= 0) {
                System.out.println("Enemy has died.");
            } else {
                if (target.getStatusCondition() == "BURN") {
                    currentHP = Math.floor(currentHP * 0.125);
                } else if (target.getStatusCondition() == "POISON") {
                    currentHP = Math.floor(currentHP * 0.0625);
                } else { // currentHP > 0
                    target.getBaseStats().setHealthPoint(currentHP);
                }
            }
        }
    }
}

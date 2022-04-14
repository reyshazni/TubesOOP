package com.monstersaku;

import java.util.*;
import com.monstersaku.util.Game.*;

public class SpecialMove extends Move {
    // private int basePower;

    public SpecialMove() {
        super();
    }

    public SpecialMove(Move move) {
        super(move);
    }

    public SpecialMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
            int ammunition, String target, Effect effect) {
        move(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect);
        // this.basePower = basePower;
    }

    // public int getBasePower() {
    //     return basePower;
    // }

    public void setDamage(Player playerAttack, Player playerDefend, Scanner myObj) {
        
        Monster source = playerAttack.getCurrentMonster();
        Monster target = playerDefend.getCurrentMonster();

        if (source.getBaseStats().getHealthPoint() <= 0) {
            ifMonsterAlive(source, playerAttack, myObj);
        }
        else {
            //Random rdm = new Random();
            double rdmNumber = (new Random().nextInt((int)1.15) + 1);
            double effective = 1;
            double burnEffect = 1;
            double power = super.getEffect().getAttack();
    
            for (ElementType et : target.getElementTypes()) {
                effective = com.monstersaku.util.EffectivityConfig.getEffectivity(this.getElementType(), et);
            }
            if (source.getStatusCondition() == "BURN") {
                burnEffect = 0.5;
            }
            double damageAttack = Math.floor(power
                    * (source.getBaseStats().getSpecialAttack() / target.getBaseStats().getSpecialDefense() + 2)
                    * rdmNumber * effective * burnEffect);
    
            double currentHP;
            currentHP = target.getBaseStats().getHealthPoint() - damageAttack;
    
            if (currentHP <= 0) {
                //System.out.println("Enemy has died.");
                target.getBaseStats().setHealthPoint(0);
            } else {
                if (target.getStatusCondition() == "BURN" || target.getStatusCondition() == "POISON") {
                    target.EffectStatusCondition(target.getStatusCondition());
                } else { // currentHP > 0
                    target.getBaseStats().setHealthPoint(currentHP);
                }
            }
        }
    }
}
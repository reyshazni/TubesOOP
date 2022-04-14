package com.monstersaku;

import java.util.*;
import com.monstersaku.util.Game.*;

public class NormalMove extends Move {

    public NormalMove() {
        super();
    }

    public NormalMove(Move move) {
        super(move);
    }

    public NormalMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
            int ammunition, String target, Effect effect) {
        move(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect);
    }

    public void setDamage(Player playerAttack, Player playerDefend, Scanner myObj) {

        Monster source = playerAttack.getCurrentMonster();
        Monster target = playerDefend.getCurrentMonster();
        if (source.getBaseStats().getHealthPoint() <= 0) {
            System.out.println("Monster sudah mati!");
        } else {
            double rdmNumber = (new Random().nextInt((int) 1.15) + 1);
            double burnEffect = 1;
            double power = super.getEffect().getAttack();

            double effective = 1;
            for (ElementType et : target.getElementTypes()) {
                effective = com.monstersaku.util.EffectivityConfig.getEffectivity(this.getElementType(), et);
            }
            if (source.getStatusCondition() == "BURN") {
                burnEffect = 0.5;
            }
            double damageAttack = Math
                    .floor((power * (source.getBaseStats().getAttack() / target.getBaseStats().getDefense() + 2)
                            * rdmNumber * effective * burnEffect));

            double currentHP;
            currentHP = target.getBaseStats().getHealthPoint() - damageAttack;

            System.out.printf("Power : %f\n", damageAttack);
            if (currentHP <= 0) {
                // System.out.println("Enemy has died.");
                target.getBaseStats().setHealthPoint(0);
            } else {
                // bingung
                if (target.getStatusCondition() == "BURN" || target.getStatusCondition() == "POISON") {
                    target.EffectStatusCondition(target.getStatusCondition());
                } else { // currentHP > 0
                    target.getBaseStats().setHealthPoint(currentHP);
                }
            }
        }
    }
}
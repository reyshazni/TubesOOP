package com.monstersaku;
import java.util.*;
import com.monstersaku.util.Game.*;

public class NormalMove extends Move {
    private int basePower;

    public NormalMove() {

    }

    public NormalMove (int id, String moveType, String name, ElementType elementType, int accuracy, int priority, 
    int ammunition, String target, Effect effect,int basePower) {
        move(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect);
        this.basePower = basePower;
    }

    public int getBasePower() {
        return basePower;
    }

    public void setDamage (Monster source, Monster target, ElementTypeEff elementeffective) {
        Random rdm = new Random();
        double rdmNumber = (rdm.nextInt(85 + 1 - 100) + 85) / 100;
        double burnEffect = 1;
        
        double effective = 1;
        for (ElementType et: target.getElementTypes()) {
            effective = effective * elementeffective.getEffectivity(elementType, elementeffective);
        }
        if (source.getStatusCondition() == "BURN") {
            burnEffect = 0.5;
        }
        double damageAttack = 
        Math.floor((getBasePower() * (source.getBaseStats().getAttack() / target.getBaseStats().getDefense() + 2)
        * rdmNumber * effective * burnEffect ));

        double currentHP;
        currentHP = 
        target.getBaseStats().getHealthPoint() - damageAttack;

        if (currentHP <= 0) {
            System.out.println("Enemy has died.");
        } 
        else {
            double rdmNumber = (new Random().nextInt((int)1.15) + 1);
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
                //System.out.println("Enemy has died.");
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



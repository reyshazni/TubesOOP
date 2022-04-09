package com.monstersaku;
import java.util.*;
import com.monstersaku.util.Game.*;

public class SpecialMove extends Move {
    private int basePower;

    public SpecialMove(){
        
    }

    public SpecialMove (int id, String moveType, String name, ElementType elementType, int accuracy, int priority, 
    int ammunition, String target, Effect effect, int basePower) {
        move(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect);
        this.basePower = basePower;
    }

    public int getBasePower() {
        return basePower;
    }

    public void setDamage (Monster source, Monster target, ElementTypeEff elementeffective) {
        Random rdm = new Random();
        double rdmNumber = (rdm.nextInt(85 + 1 - 100) + 85) / 100;
        double effective = 1;
        double burnEffect = 1;
        
        for (ElementType et: target.getElementTypes()) {
            effective *= elementeffective.getEffectivity(elementType, elementeffective);
        }
        if (source.getStatusCondition() == "BURN") {
            burnEffect = 0.5;
        }
        double damageAttack =
        Math.floor(getBasePower() * (source.getBaseStats().getSpecialAttack() / target.getBaseStats().getSpecialDefense() + 2) 
        * rdmNumber * effective * burnEffect);

        double currentHP;
        currentHP = 
        target.getBaseStats().getHealthPoint() - damageAttack;

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

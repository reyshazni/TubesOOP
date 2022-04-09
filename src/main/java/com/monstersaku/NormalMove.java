package com.monstersaku;
import java.util.*;

public class NormalMove extends Move {
    private int basePower;

    public NormalMove() {

    }

    public NormalMove (int id, String name, ElementType elementType, int accuracy, int priority, int ammunition, int basePower) {
        super(id, name, elementType, accuracy, priority, ammunition);
        this.basePower = basePower;
    }

    public int getBasePower() {
        return basePower;
    }

    public void setDamage (Monster source, Monster target, ElementTypeEff eleff) {
        Random rdm = new Random();
        double rdmNumber = (rdm.nextInt(85 + 1 - 100) + 85) / 100;
        double effective = 1;
        double burnEffect = 1;
        
        for (ElementType et: target.getElementTypes()) {
            effective *= eleff.getEffectivity(this.elementTypes, eleff);
        }
        if (source.getStatusCondition() == StatusCondition.burn) {
            burnEffect = 0.5;
        }
        double damageAttack = 
        Math.floor((getBasePower() * (source.getBaseStats().getAttack() / target.getBaseStats().getDefense() + 2)
        * rdmNumber * effective * burnEffect ));

        double currentHP;
        currentHP = 
        target.getBaseStats().getHealthPoint() - damageAttack;

        if (currentHP <= 0) {
            target.killMonster();
        } 
        else {
            if (target.getStatusCondition() == StatusCondition.burn) {
                currentHP = Math.floor(currentHP * 0.125);
            } else if (target.getStatusCondition() == StatusCondition.poison) {
                currentHP = Math.floor(currentHP * 0.0625);
            } else { // currentHP > 0
                target.getBaseBaseStats().setHealthPoint(currentHP);
            }
        }
    }
}
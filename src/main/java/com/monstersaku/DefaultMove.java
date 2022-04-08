package com.monstersaku;
import java.util.*;

public class DefaultMove extends Move {
    private int basePower;

    public DefaultMove() {
        super(1, "Default Move", ElementType.NORMAL, 100, 0, 9999);
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

        double currentEnemyHP;
        double currentSourceHP;

        currentEnemyHP = 
        target.getBaseStats().getHealthPoint() - damageAttack;
        if (currentEnemyHP <= 0) {
            target.killMonster();
        } else {
            if (target.getStatusCondition() == StatusCondition.burn) {
                currentEnemyHP = Math.floor(currentEnemyHP * 0.125);
            } else if (target.getStatusCondition() == StatusCondition.poison) {
                currentEnemyHP = Math.floor(currentEnemyHP * 0.0625);
            } else { // currentEnemyHP >= 0
                target.getBaseStats().setHealthPoint(currentEnemyHP);
            }
        }
        currentSourceHP = 
        Math.floor(0.75 * source.getBaseStats().getHealthPoint());
        if (currentSourceHP >= 0) {
            source.getBaseStats().setHealthPoint(currentSourceHP);
        }
    }
}

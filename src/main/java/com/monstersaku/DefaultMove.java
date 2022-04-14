package com.monstersaku;
import java.util.*;
import com.monstersaku.util.Game.*;

public class DefaultMove extends Move {
    private int basePower;

    public DefaultMove() {
        Effect effect = new Effect(0);
        move(0, "DEFAULT", "Default Move", ElementType.NORMAL, 100, 0, 9999, "ENEMY", effect);
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
            effective *= elementeffective.getEffectivity(this.elementTypes, elementeffective);
        }
        if (source.getStatusCondition() == "BURN") {
            burnEffect = 0.5;
        }
        double damageAttack = 
        Math.floor((getBasePower() * (source.getBaseStats().getAttack() / target.getBaseStats().getDefense() + 2)
        * rdmNumber * effective * burnEffect ));

        double currentEnemyHP;
        double currentSourceHP;

        if (source.getBaseStats().getHealthPoint() <= 0) {
            ifMonsterAlive(source, playerAttack, myObj);
        }
        else {
            double rdmNumber = (new Random().nextInt((int)1.15) + 1);
            System.out.printf("\n -- RND NUM %f -- \n", rdmNumber);
            double effective = 1;
            double burnEffect = 1;
    
            for (ElementType et : target.getElementTypes()) {
                effective = com.monstersaku.util.EffectivityConfig.getEffectivity(this.getElementType(), et);
            }
        }

        // Source
        currentSourceHP = 
        Math.floor(0.75 * source.getBaseStats().getHealthPoint());
        if (currentSourceHP >= 0) {
            source.getBaseStats().setHealthPoint(currentSourceHP);
        }
    }

    public double getDamageAttack(Monster source, Monster target) {
        // Random rdm = new Random();
        double rdmNumber = (new Random().nextInt((int)1.15) + 1);
        double effective = 1;
        double burnEffect = 1;
        double damageAttack = 
        Math.floor((getBasePower() * (source.getBaseStats().getAttack() / target.getBaseStats().getDefense() + 2)
        * rdmNumber * effective * burnEffect ));
        return damageAttack;
    }
}


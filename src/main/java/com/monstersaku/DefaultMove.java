package com.monstersaku;

import java.util.*;
import com.monstersaku.util.Game.*;

public class DefaultMove extends Move {
    private int basePower = 50;

    public DefaultMove() {
        Effect effect = new Effect(0);
        move(0, "DEFAULT", "Default Move", ElementType.NORMAL, 100, 0, 9999, "ENEMY", effect);
    }

    public int getBasePower() {
        return basePower;
    }

    public void setDamage(Player playerAttack, Player playerDefend, Scanner myObj) {
        
        Monster source = playerAttack.getCurrentMonster();
        Monster target = playerDefend.getCurrentMonster();

        System.out.printf("\n--- %s -> MENYERANG -> %s \n", playerAttack.getName().toUpperCase(), playerDefend.getName().toUpperCase());
        System.out.printf("\nMONSTER %s BERNAMA %d. %s MENYERANG %d. %s \n\n", playerAttack.getName().toUpperCase(), playerAttack.getListOfMonsters().indexOf(source), source.getName().toUpperCase(), playerDefend.getListOfMonsters().indexOf(target), target.getName().toUpperCase());

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
            if (source.getStatusCondition() == "BURN") {
                burnEffect = 0.5;
            }
            double damageAttack = Math
                    .floor((getBasePower() * (source.getBaseStats().getAttack() / target.getBaseStats().getDefense() + 2)
                            * rdmNumber * effective * burnEffect));
    
            double currentEnemyHP;
            double currentSourceHP;

            System.out.printf("\n--- MENYERANG DENGAN %f DAMAGE ---\n", damageAttack);
    
            // Enemy
            currentEnemyHP = target.getBaseStats().getHealthPoint() - damageAttack;
            System.out.printf("\n--- NYAWA %s MENJADI %f ---\n", target.getName().toUpperCase(), currentEnemyHP);
            if (currentEnemyHP <= 0) {
                for(Monster m : playerDefend.getListOfMonsters()) {
                    if (m == target) {
                        System.out.printf("\n-- MONSTER MILIK %s YANG BERNAMA %s BER ID %d TELAH MATI --\n", playerDefend.getName().toUpperCase(),target.getName().toUpperCase(), playerDefend.getListOfMonsters().indexOf(target));
                    }
                }
                target.getBaseStats().setHealthPoint(0);
            } else {
                if (target.getStatusCondition() == "BURN" || target.getStatusCondition() == "POISON") {
                    target.EffectStatusCondition(target.getStatusCondition());
                } else { // currentEnemyHP >= 0
                    target.getBaseStats().setHealthPoint(currentEnemyHP);
                }
            }
    
            // Source
            currentSourceHP = Math.floor(0.75 * source.getBaseStats().getHealthPoint());
            if (currentSourceHP >= 0) {
                source.getBaseStats().setHealthPoint(currentSourceHP);
            }
        }
    }

    public double getDamageAttack(Monster source, Monster target) {
        // Random rdm = new Random();
        double rdmNumber = (new Random().nextInt((int)1.15) + 1);
        double effective = 1;
        double burnEffect = 1;
        double damageAttack = Math
                .floor((getBasePower() * (source.getBaseStats().getAttack() / target.getBaseStats().getDefense() + 2)
                        * rdmNumber * effective * burnEffect));
        return damageAttack;
    }
}
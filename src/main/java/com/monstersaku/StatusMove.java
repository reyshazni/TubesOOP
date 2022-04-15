package com.monstersaku;

import com.monstersaku.util.Game.*;
import java.util.*;

public class StatusMove extends Move {
    private String statusCondition;

    public StatusMove() {
        super();
    }

    public StatusMove(Move move) {
        super(move);
    }

    public StatusMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
<<<<<<< HEAD
            int ammunition, String target, Effect effect) {
        move(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect);
    }

    public void buffSelf(Monster self) {
        double d100 = 100;
        Effect effect = getEffect();
        Stats baseStats = self.getBaseStats();
        Stats currentStats = self.getCurrentStats();
        double healthBuff;

        if (effect.getHealthPoint() != 0) {
            healthBuff = baseStats.getHealthPoint() * (effect.getHealthPoint() / d100);
            double healthPoint = currentStats.getHealthPoint() + healthBuff;
            if (healthPoint >= baseStats.getHealthPoint()) {
                healthPoint = baseStats.getHealthPoint();
            }
            self.getCurrentStats().setHealthPoint(healthPoint);
        }
        double attack = Effect.convertedToFactorBuff(baseStats.getAttack(), effect.getAttack());
        double defense = Effect.convertedToFactorBuff(baseStats.getDefense(), effect.getDefense());
        double specialAttack = Effect.convertedToFactorBuff(baseStats.getSpecialAttack(), effect.getSpecialAttack());
        double specialDefense = Effect.convertedToFactorBuff(baseStats.getSpecialDefense(), effect.getSpecialDefense());
        double speed = Effect.convertedToFactorBuff(baseStats.getSpeed(), effect.getSpeed());
        self.getCurrentStats().setWithOutHealthPoint(attack, defense, specialAttack, specialDefense, speed);

    }

    public void debuffEnemy(Monster enemy) {
        Effect effect = getEffect();
        Stats baseStats = enemy.getBaseStats();
        double attack = Effect.convertedToFactorBuff(baseStats.getAttack(), effect.getAttack());
        double defense = Effect.convertedToFactorBuff(baseStats.getDefense(), effect.getDefense());
        double specialAttack = Effect.convertedToFactorBuff(baseStats.getSpecialAttack(), effect.getSpecialAttack());
        double specialDefense = Effect.convertedToFactorBuff(baseStats.getSpecialDefense(), effect.getSpecialDefense());
        double speed = Effect.convertedToFactorBuff(baseStats.getSpeed(), effect.getSpeed());
        if (effect.getStatusCondition().equals("PARALYZE")) {
            speed = baseStats.getSpeed() / 2;
        }
        enemy.getCurrentStats().setWithOutHealthPoint(attack, defense, specialAttack, specialDefense, speed);
        enemy.setStatusCondition(effect.getStatusCondition());

    }

    public void applyMove(Monster self, Monster enemy) {
        // If self monster's is actually already died on the round
        if (self.getBaseStats().getHealthPoint() < 1) {
            System.out.println("Your monster had died earlier, proceed to next round!!");
        } else {
            if (getAmmunition() > 0) {
                String target = getTarget();
                if (target.equals("OWN")) {
                    buffSelf(self);
                } else if (target.equals("ENEMY")) {
                    debuffEnemy(enemy);
                }
                setAmmunition(getAmmunition() - 1);
            } else {
                System.out.println("Ammunition sudah habis, tidak bisa menggunakan " + getName());
            }
        }
    }

    public static int randomTurnSleepEffect() {
        int range = 7;
        int rand = (int) (Math.random() * range) + 1;
        return rand;
    }

    public static boolean randomTurnsParalzeEffect() {
        double rand = Math.random();
        if (rand <= 0.25) {
            return true;
        } else {
            return false;
        }
=======
            int ammunition, String target, Effect effect, String statusCondition) {
        super.move(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect);
        this.statusCondition = statusCondition;
    }

    // public String getTarget() {
    // return target;
    // }

    public String getStatCondition() {
        return statusCondition;
    }

    public void setDamage(Player playerAttack, Player playerDefend, Scanner myObj) {

        Monster source = playerAttack.getCurrentMonster();
        Monster target = playerDefend.getCurrentMonster();

        if (source.getBaseStats().getHealthPoint() <= 0) {
            System.out.println("Monster sudah mati!");
        } else {
            if (target.getStatusCondition() == "NONE"){
                System.out.println(playerAttack.getCurrentMove().getEffect().getStatusCondition());
                if (playerAttack.getCurrentMove().getEffect().getStatusCondition().equals("BURN")){
                    target.setStatusConditon("BURN");
                } else if (playerAttack.getCurrentMove().getEffect().getStatusCondition().equals("POISON")) {
                    target.setStatusConditon("POISON");
                } else if (playerAttack.getCurrentMove().getEffect().getStatusCondition().equals("SLEEP")){
                    target.setStatusConditon("SLEEP");
                } else if (playerAttack.getCurrentMove().getEffect().getStatusCondition().equals("PARALYZE")){
                    target.setStatusConditon("PARALYZE");
                }
            } else {
                double buffHP = Math.floor(source.getBaseStats().getHealthPoint()
                        + (this.getEffect().getHealthPoint() * source.getBaseStats().getHealthPoint()) / 100);
                if (super.getTarget().equals("ENEMY")) {
                    target.getBaseStats().setAttack(Effect.convertedToFactorBuff(target.getBaseStats().getAttack(),
                            this.getEffect().getAttack()));
                    target.getBaseStats().setDefense(Effect.convertedToFactorBuff(target.getBaseStats().getDefense(),
                            this.getEffect().getDefense()));
                    target.getBaseStats().setSpecialAttack(Effect.convertedToFactorBuff(
                            target.getBaseStats().getSpecialAttack(), this.getEffect().getSpecialAttack()));
                    target.getBaseStats().setSpecialDefense(Effect.convertedToFactorBuff(
                            target.getBaseStats().getSpecialDefense(), this.getEffect().getSpecialDefense()));
                    target.getBaseStats().setSpeed(Effect.convertedToFactorBuff(target.getBaseStats().getSpeed(),
                            this.getEffect().getSpeed()));
                } else { // target = SOURCE
                    source.getBaseStats().setHealthPoint(buffHP);
                }
            }
        } 
>>>>>>> master
    }
}
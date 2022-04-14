package com.monstersaku;

import com.monstersaku.util.Game.*;
import java.util.*;

public class StatusMove extends Move {
    private String target;
    private String statusCondition;
    private Stats statMove;

    public StatusMove() {
        super();
    }

    public StatusMove(Move move) {
        super(move);
    }

    public StatusMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
            int ammunition, String target, Effect effect, String statusCondition, Stats statMove) {
        move(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect);
        this.statusCondition = statusCondition;
        this.statMove = statMove;
    }

    public String getTarget() {
        return target;
    }

    public String getStatCondition() {
        return statusCondition;
    }

    public Stats getStatMove() {
        return statMove;
    }

    // CAUTION!!! belom ada efek samsek
    public void setDamage(Player playerAttack, Player playerDefend, Scanner myObj) {

        Monster source = playerAttack.getCurrentMonster();
        Monster target = playerDefend.getCurrentMonster();

        if (source.getBaseStats().getHealthPoint() <= 0) {
            ifMonsterAlive(source, playerAttack, myObj);
        } else {
            if (playerAttack.getCurrentMove().getEffect().getStatusCondition() == "BURN") {
                target.setStatusConditon("BURN");
            } else if (playerAttack.getCurrentMove().getEffect().getStatusCondition() == "POISON") {
                target.setStatusConditon("POISON");
            } else {
                // double buffHP = Math.floor(source.getBaseStats().getHealthPoint() +
                // (this.statMove.getHealthPoint() * source.getBaseStats().getHealthPoint()) /
                // 100);

                double buffHP = Math.floor(source.getBaseStats().getHealthPoint());
                if (this.target.equals("ENEMY")) {
                    target.getBaseStats().setHealthPoint(Effect.convertedToFactorBuff(
                            target.getBaseStats().getHealthPoint(), this.getEffect().getHealthPoint()));
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
            target.EffectStatusCondition(target.getStatusCondition());
        }
    }
}

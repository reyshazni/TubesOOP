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
                System.out.printf("%s tidak bisa diberikan ke monster lawan karena sudah lawan memiliki status condition!\n", playerAttack.getCurrentMove().getEffect().getStatusCondition());
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
    }
}
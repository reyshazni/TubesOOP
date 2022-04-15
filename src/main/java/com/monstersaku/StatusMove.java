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

    public String getStatCondition() {
        return statusCondition;
    }

    public void setDamage(Player playerAttack, Player playerDefend, Scanner myObj) {

        Monster source = playerAttack.getCurrentMonster();
        Monster target = playerDefend.getCurrentMonster();

        if (source.getInitStats().getHealthPoint() <= 0) {
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
                double buffHP = Math.floor(source.getInitStats().getHealthPoint()
                        + (this.getEffect().getHealthPoint() * source.getInitStats().getHealthPoint()) / 100);
                if (super.getTarget().equals("ENEMY")) {
                    target.getInitStats().setAttack(Effect.convertedToFactorBuff(target.getInitStats().getAttack(),
                            this.getEffect().getAttack()));
                    target.getInitStats().setDefense(Effect.convertedToFactorBuff(target.getInitStats().getDefense(),
                            this.getEffect().getDefense()));
                    target.getInitStats().setSpecialAttack(Effect.convertedToFactorBuff(
                            target.getInitStats().getSpecialAttack(), this.getEffect().getSpecialAttack()));
                    target.getInitStats().setSpecialDefense(Effect.convertedToFactorBuff(
                            target.getInitStats().getSpecialDefense(), this.getEffect().getSpecialDefense()));
                    target.getInitStats().setSpeed(Effect.convertedToFactorBuff(target.getInitStats().getSpeed(),
                            this.getEffect().getSpeed()));
                } else { // target = SOURCE
                    source.getInitStats().setHealthPoint(buffHP);
                }
            }
        } 
    }
}
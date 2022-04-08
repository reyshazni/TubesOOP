package com.monstersaku.util.Game;

import javax.lang.model.element.Element;

public class Turn {
    private int round = 1;

    private TurnOutput output;

    public int getRound() {
        return this.round;
    }

    public void configure(TurnOutput output) {
        this.output = output;
    }

    public Turn (TurnOutput output){
        this.output = output;
    }

    public void startTurn() {
        if (this.round == 1){
            this.output.playerOneTurn();
        }
        if (this.round == 2) {
            this.output.playerTwoTurn();
        }
        if (this.round == 3){
            this.output.didStartAttacking();
            this.output.checkIfEndGame();
        }
    }

    public void increaseRound() {
        if (this.round == 1){
            this.round = 2;
        } else if (this.round == 2) {
            this.round = 3;
        } else {
            this.round = 1;
        }
    }
}

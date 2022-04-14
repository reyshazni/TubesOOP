package com.monstersaku.util.Game;

import java.util.Scanner;

public class Turn {
    private int round = 1;

    private TurnOutput output;

    public int getRound() {
        return this.round;
    }

    public void configure(TurnOutput output) {
        this.output = output;
    }

    public Turn(TurnOutput output) {
        this.output = output;
    }

    public void startTurn(Scanner myObj) {
        if (this.round == 1) {
            this.output.playerTurn(myObj, GameView.getPlayerList().get(0), round);
        }
        if (this.round == 2) {
            this.output.playerTurn(myObj, GameView.getPlayerList().get(1), round);
        }
        if (this.round == 3) {
            System.out.printf("");
            this.output.didStartAttacking(myObj);
            this.output.checkIfEndGame();
            this.output.checkIfMonsterDie(myObj);
        }
    }

    public void increaseRound() {
        if (this.round == 1) {
            this.round = 2;
        } else if (this.round == 2) {
            this.round = 3;
        } else {
            this.round = 1;
        }
    }

    public void decreaseRound() {
        if (this.round == 1) {
            this.round = 3;
        } else if (this.round == 2) {
            this.round = 1;
        } else {
            this.round = 3;
        }
    }
}

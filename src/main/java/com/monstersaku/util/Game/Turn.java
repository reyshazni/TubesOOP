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

    public Turn (TurnOutput output){
        this.output = output;
    }

    public void startTurn(Scanner myObj) {
        if (this.round == 1){
            this.output.playerOneTurn(myObj);
        }
        if (this.round == 2) {
            this.output.playerTwoTurn(myObj);
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

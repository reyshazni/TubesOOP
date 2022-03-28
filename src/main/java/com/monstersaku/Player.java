package com.monstersaku;

import java.lang.System;

public class Player {
    private static int turn = 1;
    private int number;

    public Player(int number) {
        this.number = number;
     }

    public int getNumber() {
        return number;
    }

    public static int getTurn() {
        return turn;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }

    public void setTurn(int turn) {
        Player.turn = turn;
    }

    public void changeTurn() {
        if (turn == 1) {
            Player.turn = 2;
        } else {
            Player.turn = 1;
        }
    }

    public void whosTurn() {
        System.out.printf("Sekarang giliran Player %d", getTurn());
    }
}

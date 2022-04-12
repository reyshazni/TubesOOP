package com.monstersaku.util.Game;

import java.util.Scanner;

import com.monstersaku.Player;

public interface TurnOutput {
    public void didStartAttacking();

    public void playerOneTurn(Scanner myObj, Player Player1);

    public void playerTwoTurn(Scanner myObj);

    public void checkIfEndGame();
}

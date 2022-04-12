package com.monstersaku.util.Game;

import java.util.Scanner;

import com.monstersaku.Player;

public interface TurnOutput {
    public void didStartAttacking();

    public void playerTurn(Scanner myObj, Player player, int round);

    // public void playerTwoTurn(Scanner myObj);

    public void checkIfEndGame();
}

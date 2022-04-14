package com.monstersaku.util.Game;

import java.util.Scanner;

import com.monstersaku.Player;

public interface TurnOutput {
    public void didStartAttacking(Scanner myObj);

    public void playerTurn(Scanner myObj, Player player, int round);

    public void checkIfEndGame();

    public void checkIfMonsterDie(Scanner myObj);
}

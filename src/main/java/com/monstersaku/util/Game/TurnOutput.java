package com.monstersaku.util.Game;

import java.util.Scanner;

public interface TurnOutput {
    public void didStartAttacking();
    public void playerOneTurn(Scanner myObj);
    public void playerTwoTurn(Scanner myObj);
    public void checkIfEndGame();
}

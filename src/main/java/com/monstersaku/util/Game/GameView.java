package com.monstersaku.util.Game;

import java.util.List;
import java.util.Scanner;

import com.monstersaku.Monster;
import com.monstersaku.Player;
import com.monstersaku.util.AddListMonsterPool;
import com.monstersaku.util.MonsterPoolImporter;

public class GameView implements TurnOutput {

    public void startGame(Scanner myObj) {
        List<Monster> monsterPool = MonsterPoolImporter.create();

        // Memasukkan nama player
        System.out.print("Masukkan Nama Player 1: ");
        String namePlayer1 = myObj.next();
        System.out.print("Masukkan Nama Player 2: ");
        String namePlayer2 = myObj.next();

        // Membuat Objek Player Kosong
        Player Player1 = new Player(namePlayer1);
        Player Player2 = new Player(namePlayer2);

        // Memasukkan list monster yang random ke masing-masing player
        AddListMonsterPool.AddMonsters(Player1, monsterPool);
        AddListMonsterPool.AddMonsters(Player2, monsterPool);

        boolean going = true;
        Turn turn = new Turn(this);
        while (going){
            turn.startTurn();
            turn.increaseRound();
        }

    }

    @Override
    public void didStartAttacking() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void playerOneTurn() {
        // TODO Auto-generated method stub
        Display.menuDalamTurn();
    }

    @Override
    public void playerTwoTurn() {
        // TODO Auto-generated method stub
        Display.menuDalamTurn();
        
    }

    @Override
    public void checkIfEndGame() {
        
    }
}

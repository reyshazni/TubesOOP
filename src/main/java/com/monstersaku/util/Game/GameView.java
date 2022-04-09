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
            turn.startTurn(myObj);
            turn.increaseRound();
        }

    }

    @Override
    public void didStartAttacking() {        
    }

    @Override
    public void playerOneTurn(Scanner myObj) {
        Display.menuDalamTurn();
        String Turn1 = myObj.next();
        switch(Turn1) {
            case "1":
                // Move
                break;
            case "2":
                // Switch
                break;
            case "3":
                // Monster Info
                break;
            case "4":
                // Game Info
                break;
            case "5":
                // Help
                Display.help();
                break;
            case "6":
                // Exit
                System.exit(0);
                break;
        }
    }

    @Override
    public void playerTwoTurn(Scanner myObj) {
        Display.menuDalamTurn();
        String Turn2 = myObj.next();
        switch(Turn2) {
            case "1":
                // Move
                break;
            case "2":
                // Switch
                break;
            case "3":
                // Monster Info
                break;
            case "4":
                // Game Info
                break;
            case "5":
                // Help
                Display.help();
                break;
            case "6":
                // Exit
                System.exit(0);
                break;
        }
    }

    @Override
    public void checkIfEndGame() {
        
    }
}

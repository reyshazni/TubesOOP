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
        System.out.println("\n--- Memulai Game Baru! ---");
        System.out.print("Masukkan Nama Player 1: ");
        String namePlayer1 = myObj.next();
        System.out.print("Masukkan Nama Player 2: ");
        String namePlayer2 = myObj.next();
        Display.lineBreak();

        // Membuat Objek Player Kosong
        Player Player1 = new Player(namePlayer1);
        Player Player2 = new Player(namePlayer2);

        // Memasukkan list monster yang random ke masing-masing player
        AddListMonsterPool.AddMonsters(Player1, monsterPool);
        AddListMonsterPool.AddMonsters(Player2, monsterPool);

        boolean going = true;
        Turn turn = new Turn(this);
        while (going) {
            turn.startTurn(myObj);
            turn.increaseRound();
        }

    }

    @Override
    public void didStartAttacking() {
    }

    @Override
    public void playerOneTurn(Scanner myObj, Player Player1) {
        GameConfig ConfigPlayer1 = new

        GameConfig.enterRound(myObj, Player1);
        System.out.println("Masukkan inputmu, Player 1 !!");
        Display.menuDalamTurn();
        String Turn1 = myObj.next();
        switch (Turn1) {
            case "1":
                // Move
                System.out.println("Monster 1 Move\n");
                break;
            case "2":
                // Switch
                System.out.println("Monster 1 Switch\n");
                break;
            case "3":
                // Monster Info
                System.out.println("Monster 1 Info\n");
                break;
            case "4":
                // Game Info
                System.out.println("Game 1 Info\n");
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
        System.out.println("Masukkan inputmu, Player 2 !!");
        Display.menuDalamTurn();
        String Turn2 = myObj.next();
        switch (Turn2) {
            case "1":
                // Move
                System.out.println("Monster 2 Move\n");
                break;
            case "2":
                // Switch
                System.out.println("Monster 2 Switch\n");
                break;
            case "3":
                // Monster Info
                System.out.println("Monster 2 Info\n");
            case "4":
                // Game Info
                System.out.println("Game 2 Info\n");
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

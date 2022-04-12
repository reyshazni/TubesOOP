package com.monstersaku.util.Game;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import com.monstersaku.Monster;
import com.monstersaku.Player;
import com.monstersaku.Move;
import com.monstersaku.util.AddListMonsterPool;
import com.monstersaku.util.MonsterPoolImporter;

public class GameView implements TurnOutput {
    private static List<Player> playerList = new ArrayList<Player>();

    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public static List<Player> getPlayerList() {
        return playerList;
    }

    public void startGame(Scanner myObj) {
        List<Monster> monsterPool = MonsterPoolImporter.create();

        // Memasukkan nama player
        System.out.println("\n--- Memulai Game Baru! ---");
        for (int i = 0; i < 2; i++) {
            System.out.printf("Masukkan Nama Player %d: \n", i + 1);
            String name = myObj.next();
            Player player = new Player(name);
            addPlayer(player);
            // Memasukkan list monster yang random ke masing-masing player
            AddListMonsterPool.AddMonsters(playerList.get(i), monsterPool);
        }
        Display.lineBreak();

        boolean going = true;
        Turn turn = new Turn(this);
        while (going) {
            turn.startTurn(myObj);
            turn.increaseRound();
        }
    }

    @Override
    public void didStartAttacking() {
        Move move1 = playerList.get(0).getCurrentMove();
        Move move2 = playerList.get(1).getCurrentMove();
        if (move1 != null && move2 != null) {
            // Cek prioritas setiap move
            System.out.println("opke");
        }
        System.out.printf("Player memilih untuk move\n");
    }

    @Override
    public void playerTurn(Scanner myObj, Player player, int round) {
        Player currPlayer = player;

        System.out.printf("Masukkan inputmu, %s !!\n", currPlayer.getName());
        Display.menuDalamTurn();
        String Turn = myObj.next();
        switch (Turn) {
            case "1":
                // Moves
                System.out.printf("--- Pilihe move ---\n");
                currPlayer.getCurrentMonster().showMove();
                currPlayer.setCurrentMove(currPlayer.getCurrentMonster().selectMove(myObj));
                System.out.printf("\n\n GERAKAN YG KAMU PILIH ADALAH %s\n\n", currPlayer.getCurrentMove().getName());
                break;
            case "2":
                // Switch
                System.out.printf("Monster %d Switch\n\n", round);
                System.out.printf("Monster yang sedang digunakan adalah: %s\n", currPlayer.getCurrentMonster().getName());
                currPlayer.showAvailableMonster();
                currPlayer.setCurrentMonster(currPlayer.switchMonster(myObj));
                System.out.printf("Monster yg kamu pakai sekarang adalah %s\n",
                        currPlayer.getCurrentMonster().getName());
                break;
            case "3":
                // Monster Info
                Display.lineBreak();
                currPlayer.showAvailableMonster();
                Display.lineBreak();
                break;
            case "4":
                // Game Info
                Display.lineBreak();
                System.out.printf("Game %d Info\n\n", round);
                Display.lineBreak();
                break;
            case "5":
                // Help
                Display.lineBreak();
                Display.help();
                Display.lineBreak();
                break;
            case "6":
                // Exit
                System.out.println("Terima kasih sudah bermain!");
                System.exit(0);
                break;
            default:
                System.out.printf("This player name is %s\n", player.getName());
                break;
        }
    }

    @Override
    public void checkIfEndGame() {

    }
}

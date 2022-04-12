package com.monstersaku.util.Game;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import com.monstersaku.Monster;
import com.monstersaku.Player;
import com.monstersaku.Move;
import com.monstersaku.util.AddListMonsterPool;
import com.monstersaku.util.EffectivityConfig;
import com.monstersaku.util.MonsterPoolImporter;

public class GameView implements TurnOutput {
    private static List<Player> playerList = new ArrayList<Player>();

    public boolean isNotInfo = true;

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
            if (isNotInfo){
                turn.increaseRound();
            } else {
                isNotInfo = true;
            }
            
        }
    }

    @Override
    public void didStartAttacking(Scanner myObj) {
        // Get currentmove lalu apply move
        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);
        // Move move1 = playerList.get(0).getCurrentMove();
        // Move move2 = playerList.get(1).getCurrentMove();
        if (player1.getCurrentMove() != null && player2.getCurrentMove() != null) {
            // Cek prioritas setiap move
            // Asumsi kalo samadengan kita lebih besar move1
            if (player1.getCurrentMove().getPriority() >= player2.getCurrentMove().getPriority()){
                // Priority 1 >= 2
                player1.getCurrentMove().setDamage(player1, player2, myObj);
                player2.getCurrentMove().setDamage(player2, player1, myObj);
            } else {
                // Priority 1 < 2
                player2.getCurrentMove().setDamage(player2, player1, myObj);
                player1.getCurrentMove().setDamage(player1, player2, myObj);
            }
        } else if (player1.getCurrentMove() != null) {
            player1.getCurrentMove().setDamage(player1, player2, myObj);
        } else if (player2.getCurrentMove() != null) {
            player2.getCurrentMove().setDamage(player2, player1, myObj);
        }
        System.out.printf("\nMove dilakukan\n");
    }

    @Override
    public void playerTurn(Scanner myObj, Player player, int round) {
        Player currPlayer = player;

        System.out.printf("Masukkan inputmu, %s !!\n", currPlayer.getName());
        Display.menuDalamTurn();
        switch (myObj.next()) {
            case "1":
                // Moves
                System.out.printf("--- Pilihe move ---\n");
                currPlayer.getCurrentMonster().showMove();
                currPlayer.setCurrentMove(myObj);
                System.out.printf("\n\n GERAKAN YG KAMU PILIH ADALAH %s\n\n", currPlayer.getCurrentMove().getName());
                break;
            case "2":
                // Switch
                System.out.printf("Monster %d Switch\n\n", round);
                System.out.printf("Monster yang sedang digunakan adalah: %s\n", currPlayer.getCurrentMonster().getName());
                currPlayer.showAvailableMonster();
                currPlayer.switchMonster(myObj);
                System.out.printf("Monster baru yang digunakan sekarang adalah: %s dari index ke %d\n\n",
                        currPlayer.getCurrentMonster().getName(), currPlayer.getListOfMonsters().indexOf(currPlayer.getCurrentMonster()));
                break;
            case "3":
                // Monster Info
                Display.lineBreak();
                currPlayer.showAvailableMonster();
                Display.lineBreak();
                this.isNotInfo = false;
                break;
            case "4":
                // Game Info
                Display.lineBreak();
                System.out.printf("Game %d Info\n\n", round);
                Display.lineBreak();
                this.isNotInfo = false;
                break;
            case "5":
                // Help
                Display.lineBreak();
                Display.help();
                Display.lineBreak();
                this.isNotInfo = false;
                break;
            case "6":
                // Exit
                System.out.println("Terima kasih sudah bermain!");
                System.exit(0);
                break;
            default:
                // CAUTION : bikin biar bisa ngulang kalo salah input
                System.out.printf("\nMasukkan input dengan benar!\n");
                this.isNotInfo = false;
                break;
        }
    }

    @Override
    public void checkIfEndGame() {

    }
}

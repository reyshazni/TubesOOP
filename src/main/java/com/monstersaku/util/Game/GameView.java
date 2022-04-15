package com.monstersaku.util.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.monstersaku.Monster;
import com.monstersaku.Player;
import com.monstersaku.util.AddListMonsterPool;
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
            System.out.printf("Masukkan nama player %d: \n", i + 1);
            System.out.print("->> ");
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
            if (isNotInfo) {
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
            if (player1.getCurrentMove().getPriority() > player2.getCurrentMove().getPriority()) {
                // Priority 1 >= 2
                player1.getCurrentMove().setDamage(player1, player2, myObj);
                player2.getCurrentMove().setDamage(player2, player1, myObj);
            } else if (player1.getCurrentMove().getPriority() < player2.getCurrentMove().getPriority()) {
                // Priority 1 < 2
                player2.getCurrentMove().setDamage(player2, player1, myObj);
                player1.getCurrentMove().setDamage(player1, player2, myObj);
            } else {
                // Apabila priority sama, maka akan melakukan random
                Random rdm = new Random();
                int number = rdm.nextInt(2);
                if (number == 0) {
                    // Player 1 dulu baru player 2
                    player1.getCurrentMove().setDamage(player1, player2, myObj);
                    player2.getCurrentMove().setDamage(player2, player1, myObj);
                } else {
                    player2.getCurrentMove().setDamage(player2, player1, myObj);
                    player1.getCurrentMove().setDamage(player1, player2, myObj);
                }
            }
        } else if (player1.getCurrentMove() != null) {
            player1.getCurrentMove().setDamage(player1, player2, myObj);
        } else if (player2.getCurrentMove() != null) {
            player2.getCurrentMove().setDamage(player2, player1, myObj);
        }
        System.out.printf("\n-- Battle Process --\n\n");
        if (player1.getCurrentMove() != null) {
            System.out.printf("Move yang dilakukan Player 1 : %s\n", player1.getCurrentMove().getName());
        }
        if (player2.getCurrentMove() != null) {

            System.out.printf("Move yang dilakukan Player 2 : %s\n", player2.getCurrentMove().getName());
        }
        System.out.printf("Status P1 : %s\n", player1.getCurrentMonster().getStatusCondition());
        System.out.printf("Status P2 : %s\n", player2.getCurrentMonster().getStatusCondition());
    }

    @Override  
    public void playerTurn(Scanner myObj, Player player, int round) {
        Player currPlayer = player;
        // Mengurangi sleepduration monster
        if (!isMonsterSleeping(currPlayer)) {
            decreaseSleepDuration(currPlayer);
            System.out.printf("Masukkan inputmu, %s !!\n", currPlayer.getName());
            Display.menuDalamTurn();
            switch (myObj.next()) {
                case "1":
                    // Moves
                    if(!isMonsterSleeping(currPlayer)){
                        System.out.printf("\n--- Pilihan move ---\n");
                        currPlayer.getCurrentMonster().showMove();
                        currPlayer.setCurrentMove(myObj);
                    } else {
                        // NOTE : Ini harusnya kalo monsternya sleep harusnya bisa pilih menu lagi buat switch
                    }
                    break;
                case "2":
                    // Switch
                    System.out.printf("Monster %d Switch\n\n", round);
                    System.out.printf("Monster yang sedang digunakan adalah: %s\n",
                            currPlayer.getCurrentMonster().getName());
                    currPlayer.showAvailableMonster();
                    currPlayer.switchMonster(myObj);
                    System.out.printf("Monster baru yang digunakan sekarang adalah: %s, monster ke %d\n\n",
                            currPlayer.getCurrentMonster().getName(),
                            currPlayer.getListOfMonsters().indexOf(currPlayer.getCurrentMonster()) + 1);
                    break;
                case "3":
                    // Monster Info
                    Display.lineBreak();
                    System.out.printf("Current Monster : %s", currPlayer.getCurrentMonster().getName());
                    currPlayer.printMyMonster();
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
                    Display.helpTurn();
                    Display.lineBreak();
                    this.isNotInfo = false;
                    break;
                case "6":
                    // Exit
                    System.out.println("##### Terima kasih sudah bermain! #####");
                    System.exit(0);
                    break;
                default:
                    // CAUTION : bikin biar bisa ngulang kalo salah input
                    System.out.printf("\nMasukkan input dengan benar!\n");
                    this.isNotInfo = false;
                    break;
            }
        } else {
            playerTurnBurned(myObj, currPlayer, round);
        }
    }

    @Override
    public void checkIfEndGame() {
        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);

        System.out.println("Jumlah Monster Player 1 : " + player1.countMonster());
        System.out.println("Jumlah Monster Player 2 : " + player2.countMonster());
        Display.lineBreak();

        if (player1.countMonster() == 0 && player2.countMonster() != 0) {
            Display.endGame(player2);
        } else if (player1.countMonster() != 0 && player2.countMonster() == 0) {
            Display.endGame(player1);
        } else if (player1.countMonster() == 0 && player2.countMonster() == 0) {
            System.out.println("TIDAK ADA PEMENANG!");
            System.exit(0);
        }

    }

    public void checkIfMonsterDie(Scanner myObj) {
        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);

        if (player1.getCurrentMonster().getBaseStats().getHealthPoint() <= 0) {
            System.out.printf("Monster dari %s yang sudah mati adalah: %s\n", player1.getName(),
                    player1.getCurrentMonster().getName());
            System.out.printf("%s harus mengganti hero!!\n", player1.getName());
            player1.showAvailableMonster();
            player1.switchMonster(myObj);
            System.out.printf("Monster baru yang digunakan sekarang adalah: %s\n\n",
                    player1.getCurrentMonster().getName());
        }

        if (player2.getCurrentMonster().getBaseStats().getHealthPoint() <= 0) {
            System.out.printf("Monster dari %s yang sudah mati adalah: %s\n", player2.getName(),
                    player2.getCurrentMonster().getName());
            System.out.printf("%s harus mengganti hero!!\n", player2.getName());
            player2.showAvailableMonster();
            player2.switchMonster(myObj);
            System.out.printf("Monster baru yang digunakan sekarang adalah: %s\n\n",
                    player2.getCurrentMonster().getName());
        }
    }

    public void afterDamageCalculation() {
        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);

        for (Monster m : player1.getListOfMonsters()) {
            String statusCondition1 = m.getStatusCondition();
            double maxHP = m.getBaseStats().getMaxHealthPoint();
            switch (statusCondition1) {
                case "NONE":
                    break;
                case "BURN":
                    System.out.println(m.getName() + " terkena BURN!");
                    System.out.printf("Health Point %s yang terkena BURN akan berkurang %d setiap Turn!\n", m.getName(), (int) Math.floor(maxHP * (0.125)));
                    m.burn();
                    break;
                case "POISON":
                    System.out.println(m.getName() + " terkena POISON!");
                    System.out.printf("Health Point %s yang terkena POISON akan berkurang %d setiap Turn!\n", m.getName(), (int) Math.floor(maxHP * (0.0625)));
                    m.poison();
                    break;
                case "SLEEP":
                    System.out.println(m.getName() + " terkena SLEEP!");
                    System.out.printf("Segala Move yang dipilih oleh %s tidak akan dieksekusi!\n", m.getName());
                    m.sleep();
                    break;
                case "PARALYZE":
                    System.out.println(m.getName() + " terkena PARALYZE");
                    System.out.printf("Speed %s yang terkena PARALYZE akan berkurang 50% menjadi %d\n", m.getName(), (int) (m.getBaseStats().getSpeed() * 0.5));
                    System.out.printf("Terdapat 25% kemungkinan %s tidak dapat bergerak!\n", m.getName());
                    m.paralyze();
                    break;
            }
        }

        for (Monster n : player2.getListOfMonsters()) {
            String statusCondition2 = n.getStatusCondition();
            double maxHP = n.getBaseStats().getMaxHealthPoint();
            switch (statusCondition2) {
                case "NONE":
                    break;
                case "BURN":
                    System.out.println(n.getName() + " terkena BURN!");
                    System.out.printf("Health Point %s yang terkena BURN akan berkurang %d setiap Turn!\n", n.getName(), (int) Math.floor(maxHP * (0.125)));
                    n.burn();
                    break;
                case "POISON":
                    System.out.println(n.getName() + " terkena POISON!");
                    System.out.printf("Health Point %s yang terkena POISON akan berkurang %d setiap Turn!\n", n.getName(), (int) Math.floor(maxHP * (0.0625)));
                    n.poison();
                    break;
                case "SLEEP":
                    System.out.println(n.getName() + " terkena SLEEP!");
                    System.out.printf("Segala Move yang dipilih oleh %s tidak akan dieksekusi!\n", n.getName());
                    n.sleep();
                    break;
                case "PARALYZE":
                    System.out.println(n.getName() + " terkena PARALYZE");
                    System.out.printf("Speed %s yang terkena PARALYZE akan berkurang 50% menjadi %d\n", n.getName(), (int) (n.getBaseStats().getSpeed() * 0.5));
                    System.out.printf("Terdapat 25% kemungkinan %s tidak dapat bergerak!\n", n.getName());
                    n.paralyze();
                    break;
            }
        }
    }

    public boolean isMonsterSleeping(Player currPlayer){
        if (currPlayer.getCurrentMonster().getSleepDuration() != 0){
            System.out.printf("Monster %s tidak dapat bergerak selama %d Turn!\n", currPlayer.getName(), currPlayer.getCurrentMonster().getSleepDuration());
            return true;
        } else {
            return false;
        }
    }

    public void decreaseSleepDuration(Player currPlayer){
        for (Monster m: currPlayer.getListOfMonsters()){
            if (m.getSleepDuration() > 0){
                m.reduceSleepDuration();
            }
        }
    }

    public void checkIfMonsterExceedMaxHP() {
        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);

        for (Monster m : player1.getListOfMonsters()) {
            if (m.getBaseStats().getHealthPoint() > m.getBaseStats().getMaxHealthPoint()) {
                m.getBaseStats().setHealthPoint(m.getBaseStats().getMaxHealthPoint());
            }
        }

        for (Monster n : player2.getListOfMonsters()) {
            if (n.getBaseStats().getHealthPoint() > n.getBaseStats().getMaxHealthPoint()) {
                n.getBaseStats().setHealthPoint(n.getBaseStats().getMaxHealthPoint());
            }
        }
    }

    public void playerTurnBurned(Scanner myObj, Player currPlayer, int round) {
        decreaseSleepDuration(currPlayer);
        System.out.printf("Masukkan inputmu, %s !!\n", currPlayer.getName());
        Display.menuDalamTurnBurned();
        switch (myObj.next()) {
            case "1":
                System.out.println("Anda sedang terkena efek!! Tidak bisa move!!");
                playerTurnBurned(myObj, currPlayer, round);
                break;
            case "2":
                // Switch
                System.out.printf("Monster %d Switch\n\n", round);
                System.out.printf("Monster yang sedang digunakan adalah: %s\n",
                        currPlayer.getCurrentMonster().getName());
                currPlayer.showAvailableMonster();
                currPlayer.switchMonster(myObj);
                System.out.printf("Monster baru yang digunakan sekarang adalah: %s, monster ke %d\n\n",
                        currPlayer.getCurrentMonster().getName(),
                        currPlayer.getListOfMonsters().indexOf(currPlayer.getCurrentMonster()) + 1);
                break;
            case "3":
                // Monster Info
                Display.lineBreak();
                System.out.printf("Current Monster : %s", currPlayer.getCurrentMonster().getName());
                currPlayer.printMyMonster();
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
                Display.helpTurn();
                Display.lineBreak();
                this.isNotInfo = false;
                break;
            case "6":
                // Exit
                System.out.println("##### Terima kasih sudah bermain! #####");
                System.exit(0);
                break;
            default:
                // CAUTION : bikin biar bisa ngulang kalo salah input
                System.out.printf("\nMasukkan input dengan benar!\n");
                this.isNotInfo = false;
                break;
        }
    }
}

package com.monstersaku.util.Game;

import com.monstersaku.Player;

public class Display {
    public static void menuAwal() {
        System.out.println("\nSelamat datang di Mobilemon!!");
        System.out.println("Pilih command berikut!!");
        System.out.println("1.START GAME");
        System.out.println("2.HELP");
        System.out.println("3.EXIT GAME");
        System.out.printf("Masukkan Command: ");
    }

    public static void menuDalamTurn() {
        System.out.println("GAME MENU");
        System.out.println("1. MOVE");
        System.out.println("2. SWITCH");
        System.out.println("3. MONSTER INFO");
        System.out.println("4. GAME INFO");
        System.out.println("5. HELP");
        System.out.println("6. EXIT");
        System.out.printf("Masukkan Command: ");
    }

    public static void help() {
        System.out.println("Show Help");
    }

    public static void gameInfo() {
        System.out.println("Show Game Info");
    }

    public static void monsterInfo() {
        System.out.println("Show Monster Info");
    }

    public static void endGame(Player players) {
        System.out.println("--- GAME OVER ---");
        System.out.println(players.getName() + " WON");
    }
}


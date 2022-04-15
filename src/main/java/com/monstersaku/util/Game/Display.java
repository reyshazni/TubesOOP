package com.monstersaku.util.Game;

import com.monstersaku.Player;

public class Display {
    public static void menuAwal() {
        printArt();
        System.out.println("\nSELAMAT DATANG DI GAME MONSTER SAKU!!!");
        System.out.println("");
        System.out.println("Pilih command berikut!!");
        System.out.println("1.START GAME");
        System.out.println("2.HELP");
        System.out.println("3.EXIT GAME");
        System.out.println("Masukkan Command: ");
        System.out.print("->> ");
    }

    public static void menuDalamTurn() {
        System.out.println("GAME MENU");
        System.out.println("1. MOVE");
        System.out.println("2. SWITCH");
        System.out.println("3. MONSTER INFO");
        System.out.println("4. GAME INFO");
        System.out.println("5. HELP");
        System.out.println("6. EXIT");
        System.out.println("Masukkan Command: ");
        System.out.print("->> ");
    }

    public static void menuDalamTurnBurned(){
        System.out.println("GAME MENU");
        System.out.println("1. MOVE (Tidak bisa move karena sedang terkena efek)");
        System.out.println("2. SWITCH");
        System.out.println("3. MONSTER INFO");
        System.out.println("4. GAME INFO");
        System.out.println("5. HELP");
        System.out.println("6. EXIT");
        System.out.println("Masukkan Command: ");
        System.out.print("->> ");
    }

    public static void help() {
        System.out.println("<<<>>> HELP <<<>>>");
        System.out.println("[Deskripsi Game]");
        System.out.println("Monster saku merupakan permainan yang diadaptasi dari Game Pokemon.");
        System.out.println(
                "Permainan ini berjenis Player vs Player (PvP) yang dapat dimainkan oleh 2 pemain yang saling berlawanan.");
        System.out.println(
                "Masing-masing dari pemain akan menerima kombinasi 6 monster yang ditentukan secara acak oleh aplikasi pada setiap permainan.");
        System.out.println("Kedua pemain memakai command line yang sama atau memakai 1 komputer bergiliran.");
        System.out.println("");
        System.out.println("[Cara Bermain Monster Saku]");
        System.out.println("1. Pada main menu pilih command 1 START GAME.");
        System.out.println("2. Selanjutnya masukan input nama kedua pemain.");
        System.out.println("3. Setelah itu setiap pemain akan diberikan kombinasi 6 monster di awal pertarungan.");
        System.out.println(
                "4. Setiap pemain di setiap gilirannya dapat mengganti monster yang akan digunakan(switch) ataupun memilih movenya.");
        System.out.println(
                "5. Move akan dieksekusi secara bergiliran berdasarkan prioritas dan speed dari masing-masing monster.");
        System.out.println("6. Pemain yang masih memiliki monster di akhir permainan akan menjadi pemenang.");
        System.out.println("   Sedangkan pemain yang sudah tidak memiliki monster berarti kalah.");
    }

    public static void helpTurn() {
        System.out.println("<<<>>> HELP <<<>>>");
        System.out.println("1. MOVE");
        System.out.println(
                "Move merupakan aksi monster untuk menyerang monster lawan, heal, dll. Monster tidak dapat melakukan move jika status conditionnya 'SLEEP'.");
        System.out.println("2. SWITCH");
        System.out.println(
                "Switch digunakan untuk mengganti monster yang akan bertarung dengan monster lain yang tersedia.");
        System.out.println("3. MONSTER INFO");
        System.out.println("Monster info akan menampilkan informasi monster-monster yang dimiliki oleh pemain.");
        System.out.println("4. GAME INFO");
        System.out.println("Game info akan menampilkan informasi status game.");
        System.out.println("5. EXIT");
        System.out.println("Keluar dari permainan Monster Saku");
    }

    public static void gameInfo() {
        System.out.println("Show Game Info");
    }

    public static void monsterInfo() {
        System.out.println("Show Monster Info");
    }

    public static void endGame(Player players) {
        System.out.println("--- GAME OVER ---");
        System.out.println("CONGRATULATIONS!! " + players.getName() + " WON!!");
        System.out.println("##### Terima kasih sudah bermain! #####");
        System.exit(0);
    }

    public static void lineBreak() {
        System.out.println("");
    }

    public static final void printArt() {
        System.out.println("===========================================================================");
        System.out.println("<<<    __  __                 _              _____       _              >>>");
        System.out.println("<<<   |  \\/  |               | |            / ____|     | |             >>>");
        System.out.println("<<<   | \\  / | ___  _ __  ___| |_ ___ ___   | (___  __ _| | ___   _     >>>");
        System.out.println("<<<   | |\\/| |/ _ \\| '_ \\/ __| __/ _ \\___|  \\___  \\/ _` | |/ / | | |    >>>");
        System.out.println("<<<   | |  | | (_) | | | \\__ \\ ||  __/ |    ____) | (_| |   <| |_| |    >>>");
        System.out.println("<<<   |_|  |_|\\___/|_| |_|___/\\__\\___|_|    |_____/\\__,_|_|\\_\\__,__|    >>>");
        System.out.println("<<<                                                                     >>>");
        System.out.println("========== TUGAS BESAR IF2212 PEMROGRAMAN BERORIENTASI OBJEK STI ==========");
        System.out.println("=============================== KELOMPOK 10 ===============================");
    }
}

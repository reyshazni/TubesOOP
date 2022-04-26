package com.monstersaku;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.monstersaku.util.EffectivityConfig;
import com.monstersaku.util.MonsterPoolImporter;
import com.monstersaku.util.MovePoolImporter;
import com.monstersaku.util.Game.Display;
import com.monstersaku.util.Game.GameView;

public class Main {
    private static final List<String> CSV_FILE_PATHS = Collections.unmodifiableList(Arrays.asList(
            "configs/monsterpool.csv",
            "configs/monsterpool-4moves.csv",
            "configs/monsterpool-movetest.csv",
            "configs/movepool.csv",
            "configs/element-type-effectivity-chart.csv"));

    public static void readConfig() {
        // Monsterpool dapat berubah untuk memenuhi testing konfigurasi
        // Pilihan pool dapat diganti menggunakan index 0, 1, dan 2.
        MonsterPoolImporter.setFileName(CSV_FILE_PATHS.get(0));
        MovePoolImporter.setFileName(CSV_FILE_PATHS.get(3));
        EffectivityConfig.setFileName(CSV_FILE_PATHS.get(4));
    }

    public static void main(String[] args) {
        try (// Membuat scanner
        Scanner myObj = new Scanner(System.in)) {
            // Membaca Configuration
            readConfig();

            // Membuat while untuk run game
            while (true) {
                // Membuat command awal
                Display.menuAwal();
                String inputGameMenu;
                inputGameMenu = myObj.next();
                switch (inputGameMenu) {
                    case "1":
                        // Memasukkan List Monster
                        GameView gameView = new GameView();
                        gameView.startGame(myObj);
                        break;
                    case "2":
                        // Show Help
                        Display.help();
                        break;
                    case "3":
                        // Exit
                        System.out.println("##### Terima kasih sudah bermain! #####");
                        System.exit(0);
                        break;
                    default:
                        // Invalid
                        System.out.println("Command Tidak Sesuai");
                        Display.menuAwal();
                        inputGameMenu = myObj.next();
                        break;
                }
            }
        }
    }
}

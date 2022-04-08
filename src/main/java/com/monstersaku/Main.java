package com.monstersaku;

import com.monstersaku.*;
import com.monstersaku.util.AddListMonsterPool;
import com.monstersaku.util.MonsterPoolImporter;
import com.monstersaku.util.Game.Display;
import com.monstersaku.util.Game.GameView;
import com.monstersaku.util.Game.Turn;
import com.monstersaku.util.Game.TurnOutput;

import java.lang.System;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import java.util.ArrayList;
import java.util.Scanner;

public class Main implements TurnOutput{
    private static final List<String> CSV_FILE_PATHS = Collections.unmodifiableList(Arrays.asList(
            "configs/monsterpool.csv",
            "configs/movepool.csv",
            "configs/element-type-effectivity-chart.csv"));

    public static void readConfig() {
        MonsterPoolImporter.setFileName(CSV_FILE_PATHS.get(0));
        //CreateObjectMovePool.setFileName(CSV_FILE_PATHS.get(1));
        //FindEffectivity.setFileName(CSV_FILE_PATHS.get(2));
    }        

    public static void main(String[] args) {
        // Membuat scanner
        Scanner myObj = new Scanner(System.in);

        // Membaca Configuration
        readConfig();

        

        // Membuat Masukan Game Menu
        
        // Membuat while untuk run game
        while (true) {
            // Membuat command awal
            Display.menuAwal();
            String inputGameMenu = myObj.next();
            switch (inputGameMenu) {
                case "1":
                    // Memasukkan List Monster
                    GameView gameView = new GameView();
                    gameView.startGame(myObj);
                    break;
                case "2":
                    // Show Help
                    System.out.println("Show Help");
                    break;
                case "3":
                    // Exit
                    System.out.println("Terima kasih sudah bermain!");
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

    @Override
    public void didStartAttacking() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void playerOneTurn() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void playerTwoTurn() {
        // TODO Auto-generated method stub
        
    }

}

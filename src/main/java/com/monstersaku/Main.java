package com.monstersaku;

import com.monstersaku.*;
import com.monstersaku.util.MonsterPoolImporter;

import java.lang.System;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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

        // Membuat command awal
        System.out.println("\nSelamat datang di Mobilemon!!\nPilih command berikut!!");
        System.out.println("\n1.START GAME\n2.HELP\n2.EXIT GAME");

        // Membuat Masukan Game Menu
        System.out.print("Masukkan Command: ");
        int inputGameMenu = myObj.nextInt();

        // Membuat while untuk run game
        while (inputGameMenu == 1) {
            // Memasukkan nama player
            System.out.print("Masukkan Nama Player 1: ");
            String namePlayer1 = myObj.next();
            System.out.print("Masukkan Nama Player 2: ");
            String namePlayer2 = myObj.next();

            
        } 
        
        
    }   
}

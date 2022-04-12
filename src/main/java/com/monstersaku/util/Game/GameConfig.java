package com.monstersaku.util.Game;

import java.util.Scanner;

import com.monstersaku.Player;

public class GameConfig {
    public void enterRound(Scanner myObj, Player player) {
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
}

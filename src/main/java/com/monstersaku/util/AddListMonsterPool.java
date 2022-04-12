package com.monstersaku.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.monstersaku.Monster;
import com.monstersaku.Player;

/* Membuat List Monster Secara Random Untuk Player */

public class AddListMonsterPool {
    public static void AddMonsters(Player player, List<Monster> monsterPool) {
        List<Monster> monsterList = new ArrayList<Monster>();
        List<Monster> monsterListFull = monsterPool;

        int i;
        for (i = 0; i < 6; i++) { // Mengeluarkan 6 monster secara random
            Collections.shuffle(monsterListFull);
            Monster m = Monster.copyMonster(monsterListFull.get(0));
            monsterList.add(m);
        }
        player.setCurrentMonster(monsterList.get(0));
        System.out.printf("MONSTER PERTAMA YANG DIGUNAKAN OLEH %s ADALAH ->> %s\n", player.getName().toUpperCase(), monsterList.get(0).getName().toUpperCase());
        player.setMonsters(monsterList);
    }
}
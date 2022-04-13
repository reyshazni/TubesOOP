package com.monstersaku.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.monstersaku.Monster;
import com.monstersaku.Stats;
import com.monstersaku.Player;

/* Membuat List Monster Secara Random Untuk Player */

public class AddListMonsterPool {
    public static void AddMonsters(Player player, List<Monster> monsterPool) {
        List<Monster> monsterList = new ArrayList<Monster>();
        List<Monster> monsterListFull = monsterPool;

        int i;
        for (i = 0; i < 6; i++) { // Mengeluarkan 6 monster secara random
            Collections.shuffle(monsterListFull);
            Monster m = copyMonster(monsterListFull.get(0));
            m.setMoves(monsterListFull.get(0).getMoves());
            // m.copyMonster(monsterListFull.get(0));
            monsterList.add(m);
        }
        player.setMonsters(monsterList);
    }

    public static Monster copyMonster(Monster m) {
        Stats base = m.getBaseStats();
        Stats copyStats = new Stats(base.getMaxHealthPoint(), base.getHealthPoint(), base.getAttack(), base.getDefense(), base.getSpecialAttack(), base.getSpecialDefense(), base.getSpeed());
        Monster copy = new Monster (m.getId(), m.getName(), m.getElementTypes(), copyStats);
        return copy;
    }

}
package com.monstersaku.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.monstersaku.Monster;
import com.monstersaku.Stats;
import com.monstersaku.Player;

// Class untuk membuat list monster secara random untuk player
public class AddListMonsterPool {
    public static void AddMonsters(Player player, List<Monster> monsterPool) {
        List<Monster> monsterList = new ArrayList<Monster>();
        List<Monster> monsterListFull = monsterPool;

        int i;
        for (i = 0; i < 6; i++) { // Mengeluarkan 6 monster secara random
            Collections.shuffle(monsterListFull);
            Monster m = copyMonster(monsterListFull.get(0));
            m.setMoves(monsterListFull.get(0).getMoves());
            monsterList.add(m);
        }
        player.setMonsters(monsterList);
    }

    public static Monster copyMonster(Monster m) {
        Stats init = m.getInitStats();
        Stats copyStats = new Stats(init.getMaxHealthPoint(), init.getHealthPoint(), init.getAttack(), init.getDefense(), init.getSpecialAttack(), init.getSpecialDefense(), init.getSpeed());
        Monster copy = new Monster (m.getId(), m.getName(), m.getElementTypes(), copyStats);
        return copy;
    }

}
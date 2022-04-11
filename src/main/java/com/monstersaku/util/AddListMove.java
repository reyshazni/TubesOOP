package com.monstersaku.util;

import com.monstersaku.DefaultMove;
import com.monstersaku.Main;
import com.monstersaku.Monster;
import com.monstersaku.Move;
import com.monstersaku.NormalMove;
import com.monstersaku.SpecialMove;
import com.monstersaku.StatusMove;

import com.monstersaku.util.CSVReader;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class AddListMove {
    public static void add(Monster monster, int[] moves, List<Move> movePool) {
        List<Move> mimic = new ArrayList<Move>();
        DefaultMove df = new DefaultMove();
        mimic.add(df);
        for (int i = 0; i < moves.length; i++) {
            int index = moves[i];
            Move move = movePool.get(index);
            if (move instanceof NormalMove) {
                NormalMove nm = new NormalMove(move);
                mimic.add(nm);
            } else if (move instanceof SpecialMove) {
                SpecialMove specialMove = new SpecialMove(move);
                mimic.add(specialMove);
            } else if (move instanceof StatusMove) {
                StatusMove statusMove = new StatusMove(move);
                mimic.add(statusMove);
            }
        }
        monster.setMoves(mimic);
    }
}
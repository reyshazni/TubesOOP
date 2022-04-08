package com.monstersaku.util;

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
        mimic.add(movePool.get(0));
        for (int i = 0; i < moves.length; i++) {
            int index = moves[i];
            Move move = movePool.get(index);
            if (move instanceof NormalMove) {
                NormalMove nm = new NormalMove();
                nm.copyMove(move);
                mimic.add(nm);
            } else if (move instanceof SpecialMove) {
                SpecialMove specialMove = new SpecialMove();
                specialMove.copyMove(move);
                mimic.add(specialMove);
            } else if (move instanceof StatusMove) {
                StatusMove statusMove = new StatusMove();
                statusMove.copyMove(move);
                mimic.add(statusMove);
            }
        }
        monster.setMoves(mimic);
    }
}
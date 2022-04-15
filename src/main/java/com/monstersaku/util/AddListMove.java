package com.monstersaku.util;

import java.util.ArrayList;
import java.util.List;

import com.monstersaku.DefaultMove;
import com.monstersaku.Monster;
import com.monstersaku.Move;
import com.monstersaku.NormalMove;
import com.monstersaku.SpecialMove;
import com.monstersaku.StatusMove;

// Class untuk membuat list move untuk monster
public class AddListMove {
    // Menambahkan List Move ke monster
    public static void add(Monster monster, int[] moves, List<Move> movePool) {
        // Membuat List Dummy
        List<Move> dummyMoves = new ArrayList<Move>();
        DefaultMove df = new DefaultMove();
        dummyMoves.add(df);
        for (int i = 0; i < moves.length; i++) {
            int index = moves[i];
            Move move = movePool.get(index);
            if (move instanceof NormalMove) {
                NormalMove normalMove = new NormalMove(move);
                dummyMoves.add(normalMove);
            } else if (move instanceof SpecialMove) {
                SpecialMove specialMove = new SpecialMove(move);
                dummyMoves.add(specialMove);
            } else if (move instanceof StatusMove) {
                StatusMove statusMove = new StatusMove(move);
                dummyMoves.add(statusMove);
            }
        }
        monster.setMoves(dummyMoves);
    }
}
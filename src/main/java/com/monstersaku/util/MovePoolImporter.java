package com.monstersaku.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.monstersaku.DefaultMove;
import com.monstersaku.ElementType;
import com.monstersaku.Main;
import com.monstersaku.Move;
import com.monstersaku.NormalMove;
import com.monstersaku.SpecialMove;
import com.monstersaku.StatusMove;
import com.monstersaku.util.Game.Effect;

// Class untuk import movepool
public class MovePoolImporter {
    // Membuat wadah untuk menempatkan fileName
    private static String fileName;

    // Membaca nama filename
    public static void setFileName(String fn) {
        fileName = fn;
    };

    public static List<Move> create() {
        List<Move> moves = new ArrayList<Move>();
        DefaultMove df = new DefaultMove();
        moves.add(df);
        try {
            // System.out.printf("Filename: %s\n", fileName);
            CSVReader reader = new CSVReader(new File(Main.class.getResource(fileName).toURI()), ";");
            reader.setSkipHeader(true);
            List<String[]> lines = reader.read();
            for (String[] line : lines) {
                // Create Move
                NormalMove normalMove = new NormalMove();
                SpecialMove specialMove = new SpecialMove();
                StatusMove statusMove = new StatusMove();

                int id = Integer.valueOf(line[0]);
                String moveType = line[1];
                String name = line[2];
                ElementType elementType = ElementType.valueOf(line[3]);
                int accuracy = Integer.valueOf(line[4]);
                int priority = Integer.valueOf(line[5]);
                int ammunition = Integer.valueOf(line[6]);
                String target = line[7];
                if (line.length == 9) {
                    int powerBase = Integer.valueOf(line[8]);
                    Effect effect = new Effect(powerBase);
                    if (moveType.equals("NORMAL")) {
                        normalMove.move(id, moveType, name, elementType, accuracy, priority, ammunition, target,
                                effect);
                        moves.add(normalMove);
                    } else if (moveType.equals("SPECIAL")) {
                        specialMove.move(id, moveType, name, elementType, accuracy, priority, ammunition, target,
                                effect);
                        moves.add(specialMove);
                    }
                } else {
                    String statusCondition = line[8];
                    String[] stats = (line[9]).split(",");
                    int[] statsPoint = { 0, 0, 0, 0, 0, 0 };
                    for (int i = 0; i < 6; i++) {
                        statsPoint[i] = Integer.valueOf(stats[i]);
                    }
                    Effect effect = new Effect(statusCondition, statsPoint);
                    statusMove.move(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect);
                    moves.add(statusMove);
                }
            }

        } catch (Exception e) {
            // do nothing
            System.out.println("Error Import MovePool");
        }
        return moves;
    }
}
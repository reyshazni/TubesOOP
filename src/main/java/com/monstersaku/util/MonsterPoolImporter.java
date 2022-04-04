package com.monstersaku.util;

import com.monstersaku.util.CSVReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.monstersaku.Main;
import com.monstersaku.Monster;
import com.monstersaku.Stats;
import com.monstersaku.ElementType;
import com.monstersaku.ElementTypeEff;

public class MonsterPoolImporter {
    private static String fileName = "configs/monsterpool.csv";

    public static List<Monster> create() {
        List<Monster> monsterlist = new ArrayList<Monster>();

        try {
            CSVReader reader = new CSVReader(new File(Main.class.getResource(fileName).toURI()), ";");
            reader.setSkipHeader(true);
            List<String[]> lines = reader.read();
            for(String[] line : lines){
                
                //ID
                int id = Integer.valueOf(line[0]);
                //NAMA
                String name = line[1];
                //ELEMENTTYPE
                String[] elements = (line[2]).split(",");
                List<ElementType> eltype = new ArrayList<ElementType>();
                for (String el : elements){
                    ElementType elt = ElementType.valueOf(el); 
                    eltype.add(elt);
                }
                //BASESTATS
                String[] bs = (line[3]).split(",");
                int[] baseStats={0,0,0,0,0,0};
                for (int i=0;i<6;i++){
                    baseStats[i] = Integer.valueOf(bs[i]);
                }
                Stats fixBaseStats = new Stats(baseStats[0], baseStats[1], baseStats[2], baseStats[3], baseStats[4], baseStats[5]);
                Monster readMonster = new Monster(id, name, elementTypes, fixBaseStats, fixBaseStats);
                //MOVE
                String[] movstr = ((line[4]).split(","));
                //mau ubah string array to int array
                //hitung panjang movstr dulu
                int count=movstr.length;
                //ubah satu2
                int[] moves=new int[count];int idx;
                for (idx=0;idx<count;idx++){
                    moves[idx] = Integer.valueOf(movstr[idx]);
                }
                //SET UP MOVE MILIK MONSTER
                List<Move> movePool = new ArrayList<Move>();
                movePool = CreateObjectMovePool.create();
                AddListMove.add(readMonster, moves, movePool);
                monsterlist.add(readMonster);
                
            }
        } catch (Exception e) {
            // do nothing
            System.out.println("Unable to make monster list");
        } return monsterlist;
    }
}


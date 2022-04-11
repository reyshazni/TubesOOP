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
import com.monstersaku.Move;

public class EffectivityConfig {
    private static String fileName;

    public static void setFileName(String fn) {
        fileName = fn;
    };

    public static double getEffectivity (ElementType source, ElementType target) {
        double value = 1;

        try {
            CSVReader reader = new CSVReader(new File(EffectivityConfig.class.getResource(fileName).toURI()), ";");
            reader.setSkipHeader(true);
            List<String[]> lines = reader.read();
            for (String[] line : lines) {
                ElementType sourceMonster = ElementType.valueOf(line[0]);
                ElementType targetMonster = ElementType.valueOf(line[1]);

                if (source == sourceMonster && target == targetMonster) {
                    value = Double.valueOf(line[2]);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return value;
    }

}
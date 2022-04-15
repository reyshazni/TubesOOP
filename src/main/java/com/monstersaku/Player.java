package com.monstersaku;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.monstersaku.util.Game.Display;

public class Player {
    private String name;
    private List<Monster> listOfMonster = new ArrayList<Monster>();
    private Monster currentMonster;
    private int numOfMonster;
    private Move currMove;

    // Konstruktor
    public Player(String name) {
        this.name = name;
    }

    public Player(String name, List<Monster> listOfMonster) {
        this.name = name;
        this.listOfMonster = listOfMonster;
    }

    // Getter
    public Monster getCurrentMonster() {
        return currentMonster;
    }

    public String getName() {
        return this.name;
    }

    public int getNumOfMonster() {
        return this.numOfMonster;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setMonsterList(Monster monster) {
        listOfMonster.add(monster);
    }

    public void setMonsters(List<Monster> monsters) {
        this.listOfMonster = monsters;
        System.out.printf("MONSTER PERTAMA YANG DIGUNAKAN OLEH %s ->> %s\n\n", getName().toUpperCase(),
                monsters.get(0).getName().toUpperCase());
        setCurrentMonster(monsters.get(0));
    }

    public void setCurrentMonster(Monster currentMonster) {
        this.currentMonster = currentMonster;
    }

    // Method
    public void addMonster(Monster monster) {
        listOfMonster.add(monster);
    }

    // Method return jumlah monster yang masih hidup (update otomatis ketika dirun)
    public int countMonster() {
        numOfMonster = 0;
        for (Monster monster : listOfMonster) {
            if (monster.getBaseStats().getHealthPoint() > 0) {
                numOfMonster += 1;
            } else {
                numOfMonster += 0;
            }
        }
        return numOfMonster;
    }

    public void printMyMonster() {
        System.out.println();
        System.out.println("Jumlah Monster dari player " + this.getName().toUpperCase() + ": " + countMonster());
        System.out.println("Berikut adalah monster yang dimiliki player " + this.getName() + ": ");
        for (Monster monster : listOfMonster) {
            if (monster.getBaseStats().getHealthPoint() >= 0) {
                System.out.println("");
                System.out.println("----- Current Stats Monster " + monster.getName() + " -----");
                monster.getBaseStats().showStats();
                System.out.println(" ");
            }
        }
    }

    public List<Monster> getListOfMonsters() {
        return this.listOfMonster;
    }

    public void showAvailableMonster() {
        System.out.printf("Monster-monster yang kamu miliki : \n");
        for (Monster m : listOfMonster) {
            double percentage = (m.getBaseStats().getHealthPoint() * 100 / m.getBaseStats().getMaxHealthPoint());
            System.out.printf("--- Monster nomor %d ---\n", listOfMonster.indexOf(m) + 1);
            System.out.printf("Nama : %s\n", m.getName());
            System.out.printf("HP   : %.0f%% (%.2f/%.2f)\n", percentage, m.getBaseStats().getHealthPoint(),
                    m.getBaseStats().getMaxHealthPoint());
            if (percentage > 100) {
                System.out.printf("Monster memiliki shield sebesar %.1f\n",
                        (m.getBaseStats().getHealthPoint() - m.getBaseStats().getMaxHealthPoint()));
            }
            System.out.printf("-----------------------\n");
        }
    }

    public void switchMonster(Scanner myObj) {
        System.out.println("Pilih Monster Baru :");
        System.out.print("->> ");
        int num;
        while (true) {
            num = myObj.nextInt();
            if (listOfMonster.get(num - 1).getBaseStats().getHealthPoint() > 0) {
                break;
            } else {
                System.out.println("Monster yang kamu pilih sudah mati! Pilih monster lainnya!");
                switchMonster(myObj);
                break;
            }
        }
        Monster monster = listOfMonster.get(num - 1);

        currentMonster = monster;
        currMove = null;
    }

    public void setCurrentMove(Scanner myObj) {
        System.out.println("Pilih nomor berapa?");
        System.out.print("->> ");
        int num = myObj.nextInt();
        Display.lineBreak();
        if (num > 0 && num <= (currentMonster.getMoves().size())) {
            if (currentMonster.getMoves().get(num - 1).getAmmunition() > 0) {
                this.currMove = currentMonster.getMoves().get(num - 1);
                this.currMove.setAmmunition(this.currMove.getAmmunition() - 1);
            } else {
                System.out.println("Ammunition Sudah Habis!, Pilih Move Lain!\n");
                setCurrentMove(myObj);
            }
        } else {
            System.out.println("Masukkan Input dengan Benar!");
            setCurrentMove(myObj);
        }
    }

    public Move getCurrentMove() {
        return this.currMove;
    }
}
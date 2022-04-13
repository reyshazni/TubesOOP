package com.monstersaku;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.monstersaku.Monster;
import com.monstersaku.*;

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
        System.out.printf("MONSTER PERTAMA YANG DIGUNAKAN OLEH %s ->> %s\n\n", getName().toUpperCase(), monsters.get(0).getName().toUpperCase());
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
        for (Monster monster : listOfMonster) {
            if (monster.getBaseStats().getHealthPoint() != 0) {
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
            if (monster.getIsAlive()) {
                System.out.println(" ");
                monster.showMonsterInfo();
                System.out.println("");
                System.out.println("----- Current Stats Monster " + monster.getName() + " -----");
                monster.getBaseStats().showStats();
                System.out.println("");
                System.out.println("----- Moves of " + monster.getName() + " -----");
                for (Move move : monster.getMoves()) {
                    System.out.println("id move: " + move.getId());
                    System.out.println("move name: " + move.getName());
                    System.out.println(" ");
                }
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
            System.out.printf("--- Monster nomor %d ---\n", listOfMonster.indexOf(m) + 1);
            System.out.printf("Nama : %s\n", m.getName());
            System.out.printf("HP : %.1f\n", m.getBaseStats().getHealthPoint());
            System.out.printf("-----------------------\n");
        }
    }

    public void switchMonster(Scanner myObj) {
        System.out.printf("Kamu mau pilih monster nomor berapa?? -> ");
        int num;
        while (true) {
            num = myObj.nextInt();
            if (listOfMonster.get(num - 1).getBaseStats().getHealthPoint() > 0) {
                break;
            }
        }

        // CAUTION!!!
        // Belom tambahin kondisi kalo nyawa monster 0, gabisa ganti monster tsb.
        Monster monster = listOfMonster.get(num - 1);

        currentMonster = monster;
        currMove = null;
    }

    public void setCurrentMove(Scanner myObj) {
        System.out.printf("Pilih nomor berapa? --> ");
        int num = myObj.nextInt();
        this.currMove = currentMonster.getMoves().get(num-1);
    }

    public Move getCurrentMove() {
        return this.currMove;
    }
}
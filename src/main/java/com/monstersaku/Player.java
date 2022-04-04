package com.monstersaku;

import java.lang.System;
import java.util.ArrayList;
import java.util.List;

public class Player{
    private String name;
    private List<Monster> listOfMonster = new ArrayList<Monster>();
    private int numOfMonster;

    public Player(String name, List<Monster> listOfMonster){
        this.name = name;
        this.listOfMonster = listOfMonster;
    }
    public Player(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void addMonster(Monster monster){
        listOfMonster.add(monster);
    }
    public int countMonster(){
        for(Monster monster:listOfMonster){
            if (monster.getBaseStats().getHealthPoint() != 0) {
                numOfMonster += 1;
            } else {
                numOfMonster += 0;
            }
           
        }
        return numOfMonster;
    }
    public int outputCount(){
        return this.numOfMonster;
    }
    public void setMonsterList(Monster monster){
        listOfMonster.add(monster);
    }
    public void printMyMonster(){
        System.out.println();
        System.out.println("JUMLAH MONSTER "+ this.getName().toUpperCase()+" : " + countMonster());
        System.out.println("Berikut adalah monster yang dimiliki oleh " + this.getName()+": ");
        for (Monster monster:listOfMonster){
            if (monster.getIsAlive()){
                System.out.println(" ");
                monster.outputMonster();
                System.out.println("");
                System.out.println("----- Current Stats Monster " + monster.getName() + " -----");
                monster.getCurrentStats().printDetailStats();
                System.out.println("");
                System.out.println("----- Moves of " + monster.getName() + " -----");
                for (Move move : monster.getMoves()) {
                    System.out.println("id move: "+move.getId()); 
                    System.out.println("move name: "+move.getName());
                    System.out.println(" ");
                    }  
                System.out.println(" ");              
            }
        }
    }

    public void setMonsters(List<Monster> monsters){
        this.listOfMonster = monsters;
    }

    public List<Monster> getListOfMonsters(){
        return this.listOfMonster;
    }
    
}
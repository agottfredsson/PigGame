package com.company;

import java.util.ArrayList;

public class Player {
    private String playerName;
    private int totalPlayerScore;
    private int totalPotScore;
    private int currentPlayerScore;
    Die die = new Die();

    public Player (String playerName){
                this.playerName = playerName;
    }

    public String getPlayerName(){
        return playerName;
    }

    public int getTotalPlayerScore() {
        return totalPlayerScore;
    }

    public int getCurrentPlayerScore() {
        return currentPlayerScore;
    }

    public void rollDie(){
        currentPlayerScore = die.roll();
        totalPotScore += currentPlayerScore;
    }

    public int getTotalPotScore () {
        return totalPotScore;
    }

    public void setTotalPotScore (int x) {
        totalPotScore = x;
    }

    public void endOfRound () {
        totalPlayerScore += totalPotScore;
    }
}

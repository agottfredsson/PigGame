package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList <Player> listOfPlayers = new ArrayList<>();
        listOfPlayers = initialise();
        playGame(listOfPlayers);
    }
    private static ArrayList<Player> initialise(){
        ArrayList<Player> listOfPlayers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many players?");
        int numberOfPlayer = sc.nextInt();

      for (int i = 0; i < numberOfPlayer; i++) {
        System.out.println("What do you wanna name player " + (i + 1) + ":");
        String newPlayer = sc.next();
        Player player = new Player(newPlayer);
        listOfPlayers.add(player);
      }
        return listOfPlayers;
    }

    private static void playGame (ArrayList<Player> players) {
        Scanner sc = new Scanner(System.in);
        boolean playerHaveWon = false;

        while  (!playerHaveWon) {
        for (int i = 0; i < players.size(); i++) {

            boolean playerWantRollAgain = true;
            players.get(i).setTotalPotScore(0);

            while (playerWantRollAgain) {

                players.get(i).rollDie();

                if (players.get(i).getCurrentPlayerScore() == 1) {
                    System.out.println("\n" + players.get(i).getPlayerName() + "s die is rolling..");
                    System.out.println("You got 1 and lost all your pot points.");
                    pressEnterToContinue();
                    playerWantRollAgain = false;
                }
                else if ((players.get(i).getTotalPotScore() + players.get(i).getTotalPlayerScore()) >= 100){
                        System.out.println("\n" + players.get(i).getPlayerName() + "s die is rolling..");
                        System.out.println("Die shows: " + players.get(i).getCurrentPlayerScore());
                        System.out.println("\n" + players.get(i).getPlayerName() + " won the game!!!");
                        i = 100;
                        playerHaveWon = true;
                        break;
                }
                else {
                        System.out.println("\n" + players.get(i).getPlayerName() + "s die is rolling..");
                        System.out.println("Die shows: " + players.get(i).getCurrentPlayerScore());
                        System.out.println("Total pot score: " + players.get(i).getTotalPotScore());

                        System.out.println("\n" + "Total score: " + players.get(i).getTotalPlayerScore());
                        System.out.println("Do you want to roll again? y/n");
                        String playerWantToPlayAgain = sc.next();

                        if (playerWantToPlayAgain.equals("n")) {
                            players.get(i).endOfRound();
                            playerWantRollAgain = false;
                        }
                    }
                }
            }
        }
    }
    public static void pressEnterToContinue() {
        System.out.println("Press Enter for next player..");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}

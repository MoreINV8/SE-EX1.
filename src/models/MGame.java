package models;

import java.util.ArrayList;

public class MGame {
    private int roundCount = 0;
    private ArrayList<Die> dice;
    private ArrayList<Player> players;
    private Board board;

    public MGame(ArrayList<Die> dice, ArrayList<Player> players, Board board) throws Exception {
        if (dice.size() != 2) {
            throw new Exception("invalid amount of dice...");
        }
        if (players.size() > 8 || players.size() < 2) {
            throw new Exception("invalid amount of players...");
        }

        this.dice = dice;
        this.players = players;
        this.board = board;
    }

    public void playGame(int end) {
        while (roundCount < end) {
            playRound();
            System.out.println("===============================");
            roundCount++;
        }
    }

    private void playRound() {
        for(Player player : players) {
            player.takeTurn();
        }
    }
}

/**
 * @author 6510450305 chaiyapat
 */
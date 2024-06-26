import models.*;

import java.util.ArrayList;

public class Main {
    private static Board initBoard() {
        Board board = new Board();
        try {
            String s = "abcdefghijklmnopqrstuvwxyz1234567890!@#$";
            for (int i = 0; i < s.length(); i++) {
                board.insertSquare(String.valueOf(s.charAt(i)));
            }
        } catch (Exception e) {
            System.out.println("Error occurred cause: " + e.getMessage());
        }

        return board;
    }

    private static ArrayList<Die> initDice() {
        ArrayList<Die> dice = new ArrayList<>();
        dice.add(new Die());
        dice.add(new Die());
        return dice;
    }

    private static ArrayList<Player> initPlayer(Board board, ArrayList<Die> dice) {
        ArrayList<Player> players = new ArrayList<>();
        try {
            players.add(new Player("A", board, dice));
            players.add(new Player("B", board, dice));
            players.add(new Player("C", board, dice));
            players.add(new Player("D", board, dice));
        } catch (Exception e) {
            System.out.println("Error occurred cause: " + e.getMessage());
        }

        return players;
    }

    public static void main(String[] args) {
        Board board = initBoard();
        ArrayList<Die> dice = initDice();
        ArrayList<Player> players = initPlayer(board, dice);

        System.out.println("Init");
        for(Player p : players) {
            p.log();
        }

        System.out.println("START");
        try {
            MGame game = new MGame(dice, players, board);
            game.playGame(7);
        } catch (Exception e) {
            System.out.println("Error occurred cause: " + e.getMessage());
        }
    }
}

/**
 * @author 6510450305 chaiyapat
 */
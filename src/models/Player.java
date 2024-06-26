package models;

import java.util.ArrayList;

public class Player {
    private String name;
    private Piece piece;
    private Board board;
    private ArrayList<Die> dice;

    public Player(String name, Board board, ArrayList<Die> dice) throws Exception {
        this.name = name;
        this.board = board;

        if (dice.size() != 2) {
            throw new Exception("Invalid amount of dice...");
        }
        this.dice = dice;

        this.piece = new Piece();
        piece.setLocation(board.getSquare());
    }

    public void takeTurn() {
        int tolMove = 0;
        for (Die die : dice) {
            die.roll();
            System.out.print(die.getFaceValue() + " ");
            tolMove += die.getFaceValue();
        }
        System.out.println();

        Square oldLoc = piece.getLocation();
        try {
            Square newLoc = board.getSquare(oldLoc, tolMove);
            piece.setLocation(newLoc);

            log();
        } catch (Exception e) {
            System.out.println("Error occurred cause: " + e.getMessage());
        }
    }

    public void log() {
        System.out.println("Player: " + name + " move to city <" + piece.getLocation().getName() + ">");
    }
}

/**
 * @author 6510450305 chaiyapat
 */
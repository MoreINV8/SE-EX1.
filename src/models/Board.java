package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Square> squares = new ArrayList<Square>();

    public void insertSquare(String squareName) throws Exception {
        if (squares.size() == 40) {
            throw new Exception("too much places...");
        }

        squares.add(new Square(squareName));
    }

    public Square getSquare() {
        return squares.get(0);
    }

    public Square getSquare(Square oldLoc, int move) throws Exception {
        int i = 0;
        while (i < 40 && oldLoc != squares.get(i)) {
            i++;
        }

        if (i == 40) {
            throw new Exception("Invalid old location...");
        }

        if (i + move >= 40) {
            return squares.get(i + move - 40);
        }
        return squares.get(i + move);
    }
}

/**
 * @author 6510450305 chaiyapat
 */
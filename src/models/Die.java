package models;

import java.util.Random;

public class Die {
    private int faceValue;

    public int getFaceValue() {
        return faceValue;
    }

    public void roll() {
        Random rand = new Random();

        faceValue = rand.nextInt(1, 7);
    }
}

/**
 * @author 6510450305 chaiyapat
 */
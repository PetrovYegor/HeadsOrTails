package models;

import java.util.Random;

public class Coin {
    public enum Side {
        HEADS, TAILS;
    }

    public Side flip(){
        Random random = new Random();
        var sideNumber = random.nextInt(Side.values().length);
        return Side.values()[sideNumber];
    }
}
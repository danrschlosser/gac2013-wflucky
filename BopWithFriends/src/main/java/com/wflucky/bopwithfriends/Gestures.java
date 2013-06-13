package com.wflucky.bopwithfriends;

import java.util.Random;

/**
 * Created by Andrew
 */
public enum Gestures {

    SWIPE_UP("Swipe Up"),
    SWIPE_DOWN("Swipe Down"),
    SWIPE_LEFT("Swipe Left"),
    SWIPE_RIGHT("Swipe Right"),
    TAP("Tap"),
    DTAP("Double Tap"),
    LONGPRESS("Long Tap");

    private final String name;

    Gestures(String gestureName) {
        this.name = gestureName;
    }

    private static final Random RANDOM = new Random();
    private static final Gestures[] VALUES = Gestures.values();
    private static final int SIZE = VALUES.length;

    public static Gestures getRandom() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
    @Override
    public String toString() {
        return this.name + "!";
    }
}

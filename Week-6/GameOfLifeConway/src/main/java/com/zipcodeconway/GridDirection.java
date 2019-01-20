package com.zipcodeconway;

public enum GridDirection {
    // there's 8 possible positions around 1 "cell"

    N(0, -1),
    NE(1, -1),
    E(1, 0),
    S(0, 1),
    SE(1, 1),
    W(-1, 0),
    SW(-1, 1),
    NW(-1, -1);

    final int x;
    final int y;

    GridDirection(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

package dev.shogi.figures.basic;

import dev.shogi.figures.Figure;

public class Pawn extends Figure {
    public Pawn(boolean isWhite) {
        super("Pawn", "10000000", isWhite, "(P)*");
    }
}

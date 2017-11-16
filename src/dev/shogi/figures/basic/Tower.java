package dev.shogi.figures.basic;

import dev.shogi.figures.Figure;

public class Tower extends Figure {

    public Tower(String name, String drawpattern, boolean isWhite, String symbol){
        super(name, drawpattern, isWhite, symbol);
    }

    public Tower(boolean isWhite) {
        super("Tower", "20202020", isWhite, "R");
    }
}

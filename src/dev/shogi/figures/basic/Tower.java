package dev.shogi.figures.basic;

import dev.shogi.figures.Figure;

public class Tower extends Figure {

    public Tower(String name, String drawpattern, boolean isWhite, String symbol, String imageURL){
        super(name, drawpattern, isWhite, symbol, imageURL);
    }

    public Tower(boolean isWhite) {
        super("Tower", "20202020", isWhite, "R", "");
    }
}

package dev.shogi.figures.basic;

import dev.shogi.figures.Figure;

public class Bishop extends Figure{

    public Bishop(String name, String drawpattern, boolean isWhite, String symbol){
        super(name, drawpattern, isWhite, symbol);
    }


    public Bishop(boolean isWhite) {
        super("Bishop", "02020202", isWhite, "B");
    }

}

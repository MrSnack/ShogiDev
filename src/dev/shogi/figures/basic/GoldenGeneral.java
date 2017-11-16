package dev.shogi.figures.basic;

import dev.shogi.figures.Figure;

public class GoldenGeneral extends Figure {

    public GoldenGeneral(String name, String drawpattern, boolean isWhite, String symbol, String imageURL){
        super(name, drawpattern, isWhite, symbol, imageURL);
    }

    public GoldenGeneral(boolean isWhite) {
        super("Golden General", "11101011", isWhite, "G", "");
    }
}

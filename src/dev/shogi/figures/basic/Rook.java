package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class Rook extends Figure {

    public Rook(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    /*
    public Rook(String name, String drawpattern, boolean isWhite, String symbol, String imageURL){
        super(name, drawpattern, isWhite, symbol, imageURL);
    }

    public Rook(boolean isWhite) {
        super("Rook", "20202020", isWhite, "R", "");
    }
    */

    @Override
    public boolean isOK(Field[][] fieldArray, Field targetField) {
        //TODO Logik implementieren
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des Turms (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u98DB";
    }
}

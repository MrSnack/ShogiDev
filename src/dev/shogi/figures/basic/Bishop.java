package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class Bishop extends Figure {

    public Bishop(Field field, boolean isWhite, boolean isEuropean) {
        super(field, isWhite, isEuropean);
    }

    /*public Bishop(String name, String drawpattern, boolean isWhite, String symbol, String imageURL){
        super(name, drawpattern, isWhite, symbol, imageURL);
    }
    public Bishop(boolean isWhite) {
        super("Bishop", "02020202", isWhite, "B", "");
    }
    */

    @Override
    public boolean isOK(Field[][] fieldArray, Field field) {
        //TODO Logik implementieren
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des Läufers (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u89D2";
    }
}

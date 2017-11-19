package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class Pawn extends Figure {

    public Pawn(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    /*
    public Pawn(boolean isWhite) {
        super("Pawn", "10000000", isWhite, "(P)*", "");
    }
    */

    @Override
    public boolean isOK(Field[][] fieldArray, Field field) {
        //TODO Logik implementieren
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des Bauern (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u6B69";
    }
}

package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class Knight extends Figure {

    public Knight(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    /*
    public Knight(boolean isWhite) {
        super("Knight", "", isWhite, "N", "");
    }
    */

    @Override
    public boolean isOK(Field[][] fieldArray, Field field) {
        //TODO Logik implementieren
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des Springers (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u6842";
    }
}

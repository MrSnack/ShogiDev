package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class Lance extends Figure {

    public Lance(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    /*
    public Lance(boolean isWhite) {
        super("Lance", "20000000", isWhite, "L", "");
    }
    */

    @Override
    public boolean isOK(Field[][] fieldArray, Field targetField) {
        //TODO Logik implementieren
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des Lanzenreiters (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u9999";
    }
}

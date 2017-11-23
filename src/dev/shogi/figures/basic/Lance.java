package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class Lance extends Figure {

    public Lance(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    public Lance(Field field, String name, String abbreviation, boolean isWhite, boolean isEuropeanIcon) {
        super(field, name, abbreviation, isWhite, isEuropeanIcon);
    }

    @Override
    public boolean isOK(Field targetField) {
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

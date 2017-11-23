package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class SilverGeneral extends Figure {

    public SilverGeneral(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    public SilverGeneral(Field field, String name, String abbreviation, boolean isWhite, boolean isEuropeanIcon) {
        super(field, name, abbreviation, isWhite, isEuropeanIcon);
    }

    @Override
    public boolean isOK(Field targetField) {
        //TODO Logik implementieren
        //Drawpattern: 11010101
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des silbernen Generals (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u9280";
    }
}

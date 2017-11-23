package dev.shogi.figures.promoted;

import dev.shogi.board.Field;
import dev.shogi.figures.basic.Bishop;

public class Horse extends Bishop {

    public Horse(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    /*
    public Horse(boolean isWhite) {
        super("Horse", "12121212",isWhite, "+B", "");
    }
    */

    @Override
    public boolean isOK(Field[][] fieldArray, Field targetField) {
        //TODO Logik implementieren
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des beförderten Läufers (Pferd) (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u99AC";
    }
}

package dev.shogi.figures.promoted;

import dev.shogi.board.Field;
import dev.shogi.figures.basic.GoldenGeneral;

public class PromotedLance extends GoldenGeneral {

    public PromotedLance(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    /*
    public PromotedLance(boolean isWhite) {
        super("PromotedLance", "11101011", isWhite, "+L", "");
    }
    */

    @Override
    public boolean isOK(Field[][] fieldArray, Field targetField) {
        //TODO Logik implementieren
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des beförderten Lanzenreiters (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u674F";
    }
}

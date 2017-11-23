package dev.shogi.figures.promoted;

import dev.shogi.board.Field;
import dev.shogi.figures.basic.GoldenGeneral;

public class PromotedSilver extends GoldenGeneral {

    public PromotedSilver(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    /*
    public PromotedSilver(boolean isWhite) {
        super("PromotedSilver", "11101011", isWhite, "+S", "");
    }
    */

    @Override
    public boolean isOK(Field[][] fieldArray, Field targetField) {
        //TODO Logik implementieren
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des beförderten silbernen Generals (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u5168";
    }
}

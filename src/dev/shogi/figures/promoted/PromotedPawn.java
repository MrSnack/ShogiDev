package dev.shogi.figures.promoted;

import dev.shogi.board.Field;
import dev.shogi.figures.basic.GoldenGeneral;

public class PromotedPawn extends GoldenGeneral {

    public PromotedPawn(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    /*
    public PromotedPawn(boolean isWhite) {
        super("PromotedPawn", "11101011", isWhite, "+P", "");
    }
    */

    @Override
    public boolean isOK(Field[][] fieldArray, Field targetField) {
        //TODO Logik implementieren
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des beförderten Bauers (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u3068";
    }
}

package dev.shogi.figures.promoted;

import dev.shogi.board.Field;
import dev.shogi.figures.basic.GoldenGeneral;

public class PromotedKnight extends GoldenGeneral{

    public PromotedKnight(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    public PromotedKnight(Field field, String name, String abbreviation, boolean isWhite, boolean isEuropeanIcon) {
        super(field, name, abbreviation, isWhite, isEuropeanIcon);
    }

    @Override
    public boolean isOK(Field targetField) {
        //TODO Logik implementieren
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des befürderten Springers (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u572D";
    }
}

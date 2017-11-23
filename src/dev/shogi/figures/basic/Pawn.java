package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class Pawn extends Figure {

    public Pawn(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    public Pawn(Field field, String name, String abbreviation, boolean isWhite, boolean isEuropeanIcon) {
        super(field, name, abbreviation, isWhite, isEuropeanIcon);
    }

    @Override
    public boolean isOK(Field targetField) {
        //TODO Logik implementieren
        if(super.isOK(targetField)) {
            if((this.getField().getFieldY() == (targetField.getFieldY() + 1) || this.getField().getFieldY() == (targetField.getFieldY() + 2)) && this.getField().getFieldX() == targetField.getFieldX())
                return true;

        }
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des Bauern (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u6B69";
    }
}

package dev.shogi.figures.promoted;

import dev.shogi.board.Field;
import dev.shogi.figures.basic.GoldenGeneral;

public class PromotedPawn extends GoldenGeneral {

    public PromotedPawn(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    public PromotedPawn(Field field, String name, String abbreviation, boolean isWhite, boolean isEuropeanIcon) {
        super(field, name, abbreviation, isWhite, isEuropeanIcon);
    }

    @Override
    public boolean isOK(Field targetField) {
        if (super.isOK(targetField)) {
            return true;
        } else {
            return false;
        }
    }
}

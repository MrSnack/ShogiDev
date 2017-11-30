package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class Bishop extends Figure {

    public Bishop(Field field, boolean isWhite, boolean isEuropean) {
        super(field, isWhite, isEuropean);
    }

    public Bishop(Field field, String name, String abbreviation, boolean isWhite, boolean isEuropeanIcon) {
        super(field, name, abbreviation, isWhite, isEuropeanIcon);
    }

    @Override
    public boolean isOK(Field targetField) {
        int xStartPos = this.getField().getFieldX();
        int yStartPos = this.getField().getFieldY();

        int xTargetPos = targetField.getFieldX();
        int yTargetPos = targetField.getFieldY();

        //Anzahl uebersprungener Spalten | nach rechts: xGoingFields = positiv | nach links: xGoingFields = negativ
        int xGoingFields = xTargetPos - xStartPos;

        //Anzahl uebersprungener Zeilen | nach unten: yGoingFields = positiv | nach oben: yGoingFields = negativ
        int yGoingFields = yTargetPos - yStartPos;

        if (super.isOK(targetField)) {
            if (Math.abs(xGoingFields) == Math.abs(yGoingFields)) {
                return true;
            }
        }
        return false;
    }

}

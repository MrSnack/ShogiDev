package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class Knight extends Figure {

    public Knight(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    public Knight(Field field, String name, String abbreviation, boolean isWhite, boolean isEuropeanIcon) {
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
            //weißer Springer darf nur nach unten "springen" | schwarzes Pferd nur nach oben "springen"
            if ((this.isWhite() && yGoingFields == 2 && Math.abs(xGoingFields) == 1) ||
                    (!this.isWhite() && yGoingFields == -2 && Math.abs(xGoingFields) == 1)) {
                return true;
            }
        }
        return false;
    }
}

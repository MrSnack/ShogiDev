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
        int xGoingFields = this.getField().getFieldX() - targetField.getFieldX();
        int yGoingFields = this.getField().getFieldY() - targetField.getFieldY();

        int yStartPos = this.getField().getFieldY();
        int yTargetPos = targetField.getFieldY();

        if(super.isOK(targetField)) {
            //Zug: vorwärts (auf y-Achse)
            if (Math.abs(xGoingFields) == 0) {
                //Zug: maximal 1 Schritt
                if (Math.abs(yGoingFields) == 1) {
                    //Zug: weiß nach unten & schwarz nach oben
                    if ((yStartPos > yTargetPos && !isWhite()) || (yStartPos < yTargetPos && isWhite())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

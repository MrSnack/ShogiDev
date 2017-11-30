package dev.shogi.figures.promoted;

import dev.shogi.board.Field;
import dev.shogi.figures.basic.Rook;

public class Dragon extends Rook {
    //Promoted Rook (Dragon)

    public Dragon(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    public Dragon(Field field, String name, String abbreviation, boolean isWhite, boolean isEuropeanIcon) {
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

        if(super.isOK(targetField)){
            return true;
        }else if((Math.abs(xGoingFields) == 1 && Math.abs(yGoingFields) == 1)){
            return true;
        }
        return false;
    }

}

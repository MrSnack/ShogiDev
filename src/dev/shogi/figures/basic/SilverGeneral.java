package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class SilverGeneral extends Figure {

    public SilverGeneral(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    public SilverGeneral(Field field, String name, String abbreviation, boolean isWhite, boolean isEuropeanIcon) {
        super(field, name, abbreviation, isWhite, isEuropeanIcon);
    }

    @Override
    public boolean isOK(Field targetField) {
        //TODO Logik implementieren

        int xStartPos = this.getField().getFieldX();
        int yStartPos = this.getField().getFieldY();

        int xTargetPos = targetField.getFieldX();
        int yTargetPos = targetField.getFieldY();

        //Anzahl uebersprungener Spalten | nach rechts: xGoingFields = positiv | nach links: xGoingFields = negativ
        int xGoingFields = xTargetPos - xStartPos;

        //Anzahl uebersprungener Zeilen | nach unten: yGoingFields = positiv | nach oben: yGoingFields = negativ
        int yGoingFields = yTargetPos - yStartPos;


        if (super.isOK(targetField)) {
            //Fälle in denen der silberne General sich bewegen darf.
            //maximal 1 Feld in alle diagonalen
            //sowie 1 Feld nach oben
            if ((Math.abs(xGoingFields) == 1 && Math.abs(yGoingFields) == 1) ||
                    (this.isWhite() && Math.abs(xGoingFields) == 0 && yGoingFields == 1) ||
                    (!this.isWhite() && Math.abs(xGoingFields) == 0 && yGoingFields == -1)) {
                return true;
            }
        }
        return false;
    }
}

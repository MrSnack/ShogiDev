package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class GoldenGeneral extends Figure {

    public GoldenGeneral(Field field, boolean isWhite, boolean isEuropeanIcon) {
        super(field, isWhite, isEuropeanIcon);
    }

    public GoldenGeneral(Field field, String name, String abbreviation, boolean isWhite, boolean isEuropeanIcon) {
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
            //Fälle in denen der goldene General sich bewegen darf.
            //maximal 1 Feld (hoch, runter, links oder recht)
            //oder diagonal 1 Feld nach vorne
            if ((Math.abs(xGoingFields) == 1 && Math.abs(yGoingFields) == 0) ||
                    (Math.abs(yGoingFields) == 1 && Math.abs(xGoingFields) == 0) ||
                    (this.isWhite() && Math.abs(xGoingFields) == 1 && yGoingFields == 1) ||
                    (!this.isWhite() && Math.abs(xGoingFields) == 1 && yGoingFields == -1)) {
                return true;
            }
        }

        return false;
    }

}

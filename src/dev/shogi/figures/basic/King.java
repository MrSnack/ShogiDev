package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class King extends Figure {


    public King(Field field, boolean isWhite, boolean isEuropean) {
        super(field, isWhite, isEuropean);
    }

    public King(Field field, String name, String abbreviation, boolean isWhite, boolean isEuropeanIcon) {
        super(field, name, abbreviation, isWhite, isEuropeanIcon);
    }

    @Override
    public boolean isOK(Field targetField) {
        //Lässt die Supermethode prüfen, ob zwischen dem Zielfeld und dem momentanen eine Figur steht
        //
        //Danach wird geprüft, ob das Zielfeld auch im Laufmuster des Königs enthalten ist
        //TODO prüfen, ob der könig sich in eine Schachsituation begibt
        int xStartPos = this.getField().getFieldX();
        int yStartPos = this.getField().getFieldY();

        int xTargetPos = targetField.getFieldX();
        int yTargetPos = targetField.getFieldY();

        //Anzahl uebersprungener Spalten | nach rechts: xGoingFields = positiv | nach links: xGoingFields = negativ
        int xGoingFields = xTargetPos - xStartPos;

        //Anzahl uebersprungener Zeilen | nach rechts: xGoingFields = positiv | nach links: xGoingFields = negativ
        int yGoingFields = yTargetPos - yStartPos;


        if (super.isOK(targetField)) {

            //Fälle in denen der König sich bewegen darf
            //Jeweils 1 Feld nach oben, unten, links, rechts, sowie diagonal in alle Richtungen

            if (Math.abs(xGoingFields) <= 1 && Math.abs(yGoingFields) <= 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getImageURL() {
        //Unicode des Königs (jap. Symbol)
        //weiß: König (\u738B)
        //schwarz: "challenging" König (\u7389)
        if (this.isWhite()) {
            return super.getImageURL();
        } else {
            if (this.isEuropeanIcon()) {
                return "/europeanIcons/" + getClass().getSimpleName().toLowerCase() + ".png";
            } else {
                return "/japaneseIcons/challenging" + getClass().getSimpleName().toLowerCase() + ".png";
            }
        }
    }
}

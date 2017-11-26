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
        boolean isValid = false;

        //Lässt die Supermethode prüfen, ob zwischen dem Zielfeld und dem momentanen eine Figur steht
        //
        //Danach wird geprüft, ob das Zielfeld auch im Laufmuster des Königs enthalten ist
        //TODO prüfen, ob der könig sich in eine Schachsituation begibt
        if(super.isOK(targetField)){
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    if(targetField.getFieldX() == (this.getField().getFieldX() + i) || targetField.getFieldY()
                     == (this.getField().getFieldY() + j)){

                            isValid = true;
                    }
                }
            }

            isValid =  true;
        }else {
            isValid = false;
        }
        return isValid;
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
                return "resources/europeanIcons/" + getClass().getSimpleName().toLowerCase() + ".png";
            } else {
                return "resources/japaneseIcons/challenging" + getClass().getSimpleName().toLowerCase() + ".png";
            }
        }
    }
}

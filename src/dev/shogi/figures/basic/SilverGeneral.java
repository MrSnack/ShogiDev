package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class SilverGeneral extends Figure {

    public SilverGeneral(Field field, boolean isWhite) {
        super(field, isWhite);
    }

    /*
    public SilverGeneral(boolean isWhite) {
        super("SilverGeneral", "11010101", isWhite, "S", "");
    }
    */

    @Override
    public boolean isOK(Field[][] fieldArray, Field field) {
        //TODO Logik implementieren
        //Drawpattern: 11010101
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des silbernen Generals (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u9280";
    }
}

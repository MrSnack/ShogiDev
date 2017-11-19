package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class King extends Figure {

    public King(Field field, boolean isWhite) {
        super(field, isWhite);
    }

    /*public King(boolean isWhite) {
            super("King", "11111111", isWhite, "K", "");
        }
        */

    @Override
    public boolean isOK(Field[][] fieldArray, Field field) {
        //TODO Logik implementieren
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des Königs (jap. Symbol)
        //weiß: König (\u738B)
        //schwarz: "challenging" König (\u7389)
        //TODO Symbol innerhalb des Spielsteins einfügen
        if (this.isWhite()) {
            return "\u738B";
        } else {
            return "\u7389";
        }
    }
}

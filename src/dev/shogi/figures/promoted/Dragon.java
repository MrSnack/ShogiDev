package dev.shogi.figures.promoted;

import dev.shogi.board.Field;
import dev.shogi.figures.basic.Rook;

public class Dragon extends Rook {
    //Promoted Rook (Dragon)

    public Dragon(Field field, boolean isWhite) {
        super(field, isWhite);
    }

    /*
    public Dragon(boolean isWhite) {
        super("Dragon","21212121", isWhite, "+R", "");
    }
    */

    @Override
    public boolean isOK(Field[][] fieldArray, Field field) {
        return super.isOK(fieldArray, field);
    }

    @Override
    public String getSymbol() {
        //Unicode des beförderten Turms (Drache) (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u9F8D";
    }
}

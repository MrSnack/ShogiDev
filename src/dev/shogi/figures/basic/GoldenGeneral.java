package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class GoldenGeneral extends Figure {

    public GoldenGeneral(Field field, boolean isWhite) {
        super(field, isWhite);
    }

    /*
        public GoldenGeneral(String name, String drawpattern, boolean isWhite, String symbol, String imageURL){
            super(name, drawpattern, isWhite, symbol, imageURL);
        }

        public GoldenGeneral(boolean isWhite) {
            super("Golden General", "11101011", isWhite, "G", "");
        }
        */
    @Override
    public boolean isOK(Field[][] fieldArray, Field field) {
        //TODO Logik implementieren
        return false;
    }

    @Override
    public String getSymbol() {
        //Unicode des goldenen Generals (jap. Symbol)
        //TODO Symbol innerhalb des Spielsteins einfügen
        return "\u91D1";
    }
}

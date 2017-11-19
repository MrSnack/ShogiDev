package dev.shogi.figures;

import dev.shogi.board.Field;

public abstract class Figure {

    private Field field;
    private String name;
    /**
     * Drawpattern besteht aus 9 Zeichen.
     * 0 = kein Zug
     * 1 = Zug für 1 Feld
     * 2 = Zug für unendlich Felder
     */
    private String drawpattern;
    private boolean isWhite;

    public Figure(Field field, boolean isWhite) {
        this.field = field;
        this.isWhite = isWhite;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public String getDrawpattern() {
        return drawpattern;
    }

    public boolean isWhite(){
        return isWhite;
    }

    public Field getField() { return field; }

    abstract public boolean isOK(Field[][] fieldArray, Field field);

    abstract public String getSymbol();
}

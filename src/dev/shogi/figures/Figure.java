package dev.shogi.figures;

import dev.shogi.board.Field;

public abstract class Figure {

    /**
     * Feld, auf dem die Figur steht
     */
    private Field field;
    /**
     * Name der Figur
     */
    private String name;
    /**
     * Kürzel der Figur - Englisches Symbol
     */
    private String abbreviation;
    /**
     * Drawpattern besteht aus 9 Zeichen.
     * 0 = kein Zug
     * 1 = Zug für 1 Feld
     * 2 = Zug für unendlich Felder
     */
    private String drawpattern;
    /**
     * Boolean zur Bestimmung der Farbe
     */
    private boolean isWhite;
    /**
     * Boolean zur Festlegung der Spielstein-Icons
     */
    private boolean isEuropeanIcon;
    /**
     * Konstruktor einer jeden Figur
     *
     * @param field Feld auf welchem die Figur steht
     * @param isWhite Farbe der Figur
     * @param isEuropeanIcon Iconsatzfestlegung
     */
    public Figure(Field field, boolean isWhite, boolean isEuropeanIcon) {
        this.field = field;
        this.isWhite = isWhite;
        this.isEuropeanIcon = isEuropeanIcon;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String getDrawpattern() {
        return drawpattern;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public abstract boolean isOK(Field[][] fieldArray, Field field);

    public abstract String getSymbol();

//    public abstract String getImageURL(boolean isEuropeanIcon);

    public String getImageURL() {
        if (isEuropeanIcon) {
            return "resources/europeanIcons/" + getClass().getSimpleName().toLowerCase() + ".png";
        } else {
            return "resources/japaneseIcons/" + getClass().getSimpleName().toLowerCase() + ".png";
        }
    }

    public boolean isEuropeanIcon() {
        return isEuropeanIcon;
    }
}

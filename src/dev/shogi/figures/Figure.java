package dev.shogi.figures;

public abstract class Figure {

    private String name;
    /**
     * Drawpattern besteht aus 9 Zeichen.
     * 0 = kein Zug
     * 1 = Zug für 1 Feld
     * 2 = Zug für unendlich Felder
     */
    private String drawpattern;

    private boolean isWhite;

    public Figure(String name, String drawpattern, boolean isWhite) {
        this.name = name;
        this.drawpattern = drawpattern;
        this.isWhite = isWhite;
    }

    public String getName() {
        return name;
    }

    public String getDrawpattern() {
        return drawpattern;
    }
}

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
    private String symbol;

    private String imageURL;

    public Figure(String name, String drawpattern, boolean isWhite, String symbol, String imageURL) {
        this.name = name;
        this.drawpattern = drawpattern;
        this.isWhite = isWhite;
        this.symbol = symbol;
        this.imageURL = imageURL;
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

    public String getSymbol(){
        return symbol;
    }
}

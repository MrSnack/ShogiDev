package dev.shogi.figures.basic;

import dev.shogi.board.Field;
import dev.shogi.figures.Figure;

public class King extends Figure {

    public King(Field field, boolean isWhite, boolean isEuropean) {
        super(field, isWhite, isEuropean);
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

    @Override
    public String getImageURL() {
        if (this.isWhite()) {
            return super.getImageURL();
        } else {
            if (this.isEuropeanIcon()) {
                return "resources/europeanIcons/" + getClass().getSimpleName().toLowerCase() + ".png";
            } else {
                return "resources/japaneseIcons/challening" + getClass().getSimpleName().toLowerCase() + ".png";
            }
        }
    }

    private boolean imSchach(boolean istSchwarz) {

        // K�nig im Schach?
        Figur temp = this.getFigur(istSchwarz, Koenig.class);
        Koenig koenig = temp != null ? (Koenig) temp : null;
        if (koenig != null) {

            Figur fi = null;
            Feld f = koenig.getFeld();

            for (int i = 0; i < feld.length; i++) {
                for (int j = 0; j < feld.length; j++) {
                    if (feld[i][j] != null) {
                        temp = feld[i][j].getFigur();
                        fi = temp != null ? (Figur) temp : null;
                        if (fi != null) {
                            if (fi.istOK(feld, f) && this.istOK(fi, f)) {
                                schlageInsSchachStellendeFigur(fi);
                                System.out.println("K�nig steht im Schach!");
                                return true;
                            }
                        }

                    }

                }
            }

        }
        return false;
    }
}

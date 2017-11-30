package dev.shogi.figures;

import dev.shogi.board.Field;

/**
 * Klasse Figur
 * Vererbende Klasse für alle Figuren auf dem Spielbrett
 * Die Klasse ist zur Festlegung der Methoden aller FIguren zuständig
 * und prueft das Standardverhalten beim Zug im Allgemeinen
 *
 * @author Jannik Wolf
 */
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
     * @param field          Feld auf welchem die Figur steht
     * @param isWhite        Farbe der Figur
     * @param isEuropeanIcon Iconsatzfestlegung
     */
    public Figure(Field field, boolean isWhite, boolean isEuropeanIcon) {
        this.field = field;
        this.isWhite = isWhite;
        this.isEuropeanIcon = isEuropeanIcon;
    }

    /**
     * Konstruktor der Figur
     *
     * @param field          - Feld auf dem Brett, wo die Figur hingestellt/instanziert wird
     * @param name           - Englischer Name der Figur
     * @param abbreviation   - Europaeisches Kuerzel der Figur
     * @param isWhite        - Farbe der Figur zur Bestimmung der Spielseite
     * @param isEuropeanIcon - Festlegung, welcher Symbolstandard genommen wird (europaeisch oder japanisch(
     */
    public Figure(Field field, String name, String abbreviation, boolean isWhite, boolean isEuropeanIcon) {
        this.field = field;
        this.name = name;
        this.abbreviation = abbreviation;
        this.isWhite = isWhite;
        this.isEuropeanIcon = isEuropeanIcon;
    }

    /**
     * Methode zum Setzen des neuen Feldes der Figur.
     *
     * @param field - Zielfeld des Zuges, wo sich die Figur dann befinden soll
     * @param init  - true, wenn die Figur bei der Brettinitialisierung gesetzt wurde
     */
    public void setField(Field field, boolean init) {
        this.field = field;
        if (!init) {
            field.getBoard().getPnlGame().saveTurnEnd(this);
        }
    }

    /**
     * Die Methode gibt die Farbe der Figur zurück.
     *
     * @return Farbe der Figur
     */
    public boolean isWhite() {
        return isWhite;
    }

    /**
     * Die Methode gibt das aktuelle Feld der Figur zurück.
     *
     * @return Feld, auf dem sich die Figur befindet
     */
    public Field getField() {
        return field;
    }

    /**
     * Die Methode gibt den englischen Namen der Figur zurück
     *
     * @return Englischen Namen der Figur
     */
    public String getName() {
        return this.name;
    }

    /**
     * Die Methode prüft drei grundlegene Fälle, wo keine Figur ziehen darf.
     * Diese drei grundelegenen Fälle sind:
     * - Zielfeld darf nicht Startfeld sein
     * - Falls auf dem Zielfeld eine Figur ist, muss sie vom Gegner sein
     * - Figuren dürfen nicht über andere Figuren springen, außer der Springer
     *
     * @param targetField - Zielfeld des Zuges
     * @return true, wenn Figur im Allgemeinen ziehen darf
     */
    public boolean isOK(Field targetField) {
        Field[][] fields = this.getField().getBoard().getPnlGame().getFields();

        int xStartPos = this.getField().getFieldX();
        int yStartPos = this.getField().getFieldY();

        int xTargetPos = targetField.getFieldX();
        int yTargetPos = targetField.getFieldY();

        //Anzahl uebersprungener Spalten | nach rechts: xGoingFields = positiv | nach links: xGoingFields = negativ
        int xGoingFields = xTargetPos - xStartPos;

        //Anzahl uebersprungener Zeilen | nach unten: yGoingFields = positiv | nach oben: yGoingFields = negativ
        int yGoingFields = yTargetPos - yStartPos;

        //Schrittrichtung der Figur
        int xStepDirection = 0;
        int yStepDirection = 0;

        //Stratfeld darf nicht Zielfeld sein
        if (targetField == this.getField()) {
            return false;
        }

        //Figur auf Zieldfeld muss andere Farbe haben
        if (targetField.getFigure() != null && targetField.getFigure().isWhite == this.isWhite ||
                targetField.getFigure() != null && !targetField.getFigure().isWhite == !this.isWhite) {
            return false;
        }

        //Prüfung, ob Figur überhaupt vorwärts geht
        if (Math.abs(xGoingFields) >= 1 || Math.abs(yGoingFields) >= 1) {
            //Festlegen der Schrittrichtung
            //Durch die vier if-Anweisungen ist auch eine Kombination, wie z.B. oben rechts, möglich
            if (xStartPos < xTargetPos) {
                //Schrittrichtung: rechts
                xStepDirection = 1;
            }
            if (yStartPos < yTargetPos) {
                //Schrittrichtung: unten
                yStepDirection = 1;
            }
            if (xStartPos > xTargetPos) {
                //Schrittrichtung: links
                xStepDirection = -1;
            }
            if (yStartPos > yTargetPos) {
                //Schrittrichtung: oben
                yStepDirection = -1;
            }

            //Springer darf überspringen -> Schrittprüfung in der Klasse Knight
            if (this.getName().equalsIgnoreCase("Knight")) {
                return true;
            } else {
                //keine Figur zwischen startField und targetField
                if (Math.abs(xGoingFields) >= 2 || Math.abs(yGoingFields) >= 2) {
                    int xPos = xStartPos + xStepDirection;
                    int yPos = yStartPos + yStepDirection;
                    for (int row = 0; row < (Math.abs(xGoingFields) - 1); row++) {
                        if (fields[xPos][yPos].getFigure() != null) {
                            return false;
                        }
                        xPos += xStepDirection;
                        yPos += yStepDirection;
                    }
                    for (int column = 0; column < (Math.abs(yGoingFields) - 1); column++) {
                        if (fields[xPos][yPos].getFigure() != null) {
                            return false;
                        }
                        xPos += xStepDirection;
                        yPos += yStepDirection;
                    }
                }
            }
        }
        return true;
    }

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

    public void setEuropeanIcon(boolean europeanIcon) {
        this.isEuropeanIcon = europeanIcon;
    }
}

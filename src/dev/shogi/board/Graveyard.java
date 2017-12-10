package dev.shogi.board;

import dev.shogi.figures.Figure;
import dev.shogi.figures.basic.*;

import java.util.ArrayList;

public class Graveyard extends ArrayList<Figure> {

    private boolean isWhite;
    private Board board;

    public Graveyard(Board board, boolean isWhite) {
        this.board = board;
        this.isWhite = isWhite;
    }

    public void addFigure(Figure figure) {
        if (figure.getAbbreviation().contains("+")) {

            switch (figure.getAbbreviation().charAt(1)) {
                case 'R':
                    this.add(new Rook(null, "Rook", "R", this.isWhite, board.isEuropeanIcon()));
                    break;
                case 'B':
                    this.add(new Bishop(null, "Bishop", "B", this.isWhite, board.isEuropeanIcon()));
                    break;
                case 'S':
                    this.add(new SilverGeneral(null, "SilverGeneral", "S", this.isWhite, board.isEuropeanIcon()));
                    break;
                case 'N':
                    this.add(new Knight(null, "Knight", "N", this.isWhite, board.isEuropeanIcon()));
                    break;
                case 'L':
                    this.add(new Lance(null, "Lance", "L", this.isWhite, board.isEuropeanIcon()));
                    break;
                case 'P':
                    this.add(new Pawn(null, "Pawn", "P", this.isWhite, board.isEuropeanIcon()));
                    break;
                default:
                    break;
            }
        } else {
            figure.setWhite(this.isWhite);
            this.add(figure);
        }

    }

    public void removeFigurefromGraveyard(Figure figure) {
        this.remove(figure);
    }

    public ArrayList<Figure> getFigureList(Field field) {
        ArrayList<Figure> toReturnList = new ArrayList<>();
        boolean pawnIsOnColumn = false;
        for (Figure graveyardFigure : this) {
            //Wenn ein eigener Bauer auf der gleichen Linie, wie das Feld liegt, darf der Bauer nicht auf die Friedhofsliste.
            //Es darf nur ein Bauer vom Friedhof genommen werden, wenn keiner der gleichen Farbe auf der Linie steht.
            if (graveyardFigure.getAbbreviation().equals("P")) {
                for (Figure figure : field.getBoard().getPnlGame().getFigures()) {
                    if (figure.getAbbreviation().equals("P")) {
                        if ((figure.getField().getFieldX() == field.getFieldX()) && (graveyardFigure.isWhite() == figure.isWhite())) {
                            pawnIsOnColumn = true;
                        }
                    }
                }
            }

            if (!pawnIsOnColumn) {
                //Es darf kein Springer (Knight) auf die vorletzte Reihe gesetzt werden, da dort keine Zugmöglichkeit mehr besteht
                if ((field.getFieldY() == 7 && this.isWhite) || (field.getFieldY() == 1 && !this.isWhite)) {
                    if (!graveyardFigure.getAbbreviation().equals("N")) {
                        toReturnList.add(graveyardFigure);
                    }
                    //Auf der letzten Reihe dürfen weder Springer, noch Bauern, noch Lanzen vom Friedhof aufgestellt werden.
                } else if ((field.getFieldY() == 8 && this.isWhite) || (field.getFieldY() == 0 && !this.isWhite)) {
                    switch (graveyardFigure.getAbbreviation()) {
                        case "B":
                        case "G":
                        case "R":
                        case "S":
                            toReturnList.add(graveyardFigure);
                            break;
                        default:
                            break;
                    }
                } else {
                    toReturnList.add(graveyardFigure);
                }
            }
        }

        return toReturnList;
    }
}

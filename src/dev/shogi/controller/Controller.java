package dev.shogi.controller;

import dev.shogi.board.Board;
import dev.shogi.board.Field;
import dev.shogi.board.Graveyard;
import dev.shogi.figures.Figure;
import dev.shogi.figures.promoted.*;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {

    private static Controller instance = null;

    private Board board;

    private Graveyard graveyardBlack;
    private Graveyard graveyardWhite;

    private Controller() {
        board = new Board();
        this.createBoard();
        this.createGraveyard();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private void createBoard() {
        board.buildBoard();
    }

    private void createGraveyard() {
        graveyardBlack = new Graveyard(board, board.getPnlGame().isWhite());
        graveyardWhite = new Graveyard(board, !board.getPnlGame().isWhite());
    }

    public void moveFigure(Board board, Figure figure, Field startField, Field targetField) {
        targetField.setFigure(figure);
        if (this.isTsume(board.getPnlGame().isWhite(), figure)) {
            startField.setFigure(figure);
            targetField.removeFigure(true);
            board.getPnlGame().setReversed(true);
            board.getPnlGame().setTurnStart(true);
        }
    }

    private boolean isTsume(boolean isWhite, Figure figureForFigures) {
        //TODO: Fehlermeldung beheben, wenn man König bewegt.
        ArrayList<Figure> figures = figureForFigures.getField().getBoard().getPnlGame().getFigures();

        Figure king = null;

        for (Figure figure : figures) {
            if (figure.isWhite() == isWhite && figure.getAbbreviation().equalsIgnoreCase("K")) {
                king = figure;
            }
        }

        if (king != null) {
            for (Figure figure : figures) {
                if (figure.isWhite() != king.isWhite()) {
                    if (figure.isOK(king.getField())) {
                        JOptionPane.showMessageDialog(null, "Der " + (king.isWhite() ? "weisse " : "schwarze ") + "König ist im Tsume!", "Im Tsume", JOptionPane.INFORMATION_MESSAGE);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void addFigureToGraveyard(Field targetField) {
        if (targetField.getFigure().isWhite()) {
            graveyardWhite.addFigure(targetField.getFigure());
        } else {
            graveyardBlack.addFigure(targetField.getFigure());
        }
    }

    public JComboBox getGraveyardList(Field field, boolean isWhite) {
        JComboBox cbxGraveyard = new JComboBox();
        ArrayList<Figure> graveyardArray;
        if (isWhite) {
            graveyardArray = graveyardBlack.getFigureList(field);
        } else {
            graveyardArray = graveyardWhite.getFigureList(field);
        }

        for (Figure figure : graveyardArray) {
            cbxGraveyard.addItem(figure);
        }

        if (graveyardArray.size() > 0) {
            return cbxGraveyard;
        } else {
            return null;
        }
    }

    public Figure promoteFigure(Figure figure) {
        Figure toReturn = null;

        switch (figure.getAbbreviation()) {
            case ("P"):
                toReturn = new PromotedPawn(figure.getField(), "Promoted Pawn", "+" + figure.getAbbreviation(), figure.isWhite(), figure.isEuropeanIcon());
                break;
            case ("R"):
                toReturn = new Dragon(figure.getField(), "Dragon", "+" + figure.getAbbreviation(), figure.isWhite(), figure.isEuropeanIcon());
                break;
            case ("B"):
                toReturn = new Horse(figure.getField(), "Horse", "+" + figure.getAbbreviation(), figure.isWhite(), figure.isEuropeanIcon());
                break;
            case ("L"):
                toReturn = new PromotedLance(figure.getField(), "Promoted Lance", "+" + figure.getAbbreviation(), figure.isWhite(), figure.isEuropeanIcon());
                break;
            case ("S"):
                toReturn = new PromotedSilver(figure.getField(), "Promoted Silver", "+" + figure.getAbbreviation(), figure.isWhite(), figure.isEuropeanIcon());
                break;
            case ("N"):
                toReturn = new PromotedKnight(figure.getField(), "Promoted Knight", "+" + figure.getAbbreviation(), figure.isWhite(), figure.isEuropeanIcon());
                break;
            default:
                break;
        }
        if (toReturn == null) {
            return figure;
        } else {
            return toReturn;
        }

    }
}

package dev.shogi.controller;


import dev.shogi.board.Board;
import dev.shogi.board.Field;
import dev.shogi.board.Graveyard;
import dev.shogi.figures.Figure;
import dev.shogi.figures.basic.King;
import dev.shogi.figures.promoted.*;

import javax.swing.*;

public class Controller {

    private static Controller instance = null;

    private Board board;

    private JList<Figure> lstGraveyardBlack;
    private JList<Figure> lstGraveyardWhite;

    private Graveyard graveyardBlack;
    private Graveyard graveyardWhite;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Controller (){
        board = new Board();
        this.createGraveyard();
    }

    public void createBoard() {
        board.buildBoard();
    }

    private void createGraveyard() {
        graveyardBlack = new Graveyard(board,board.getPnlGame().isWhite());
        graveyardWhite = new Graveyard(board,!board.getPnlGame().isWhite());
    }

    public void moveFigure(Figure figure, Field startField, Field targetField) {
        targetField.setFigure(figure);

        if (figure.isWhite()) {
            //im Tsume? setz Figur zurück
            if (this.isTsume(board.getPnlGame().isWhite())) {
                startField.setFigure(figure);
                targetField.removeFigure(true);
                board.getPnlGame().setReversed(true);
            }
        } else if (!figure.isWhite()) {
            //im Tsume? setz Figur zurück
            if (this.isTsume(!board.getPnlGame().isWhite())) {
                startField.setFigure(figure);
                targetField.removeFigure(true);
                board.getPnlGame().setReversed(true);
            }
        }
    }

    private boolean isTsume(boolean isWhite) {
        //TODO: Logik des im Schach programmieren
        boolean toReturn = false;
        Field[][] arrayOfFields = board.getPnlGame().getFields();
        Field whiteKingField = new Field();
        Field blackKingField = new Field();
        for (Field fieldsX[]: arrayOfFields) {
            for (Field fieldsXY: fieldsX) {
                if (fieldsXY.getFigure() != null) {
                    if (fieldsXY.getFigure().getName().equals(King.class.getSimpleName())) {
                        if (fieldsXY.getFigure().isWhite()) {
                            whiteKingField = fieldsXY;
                        } else {
                            blackKingField = fieldsXY;
                        }
                    }
                }
            }
        }

        for (Field fieldsX[]: arrayOfFields) {
            for (Field fieldsXY : fieldsX) {
                if(fieldsXY.getFigure() != null) {
                    if(fieldsXY.getFigure().isWhite()) {
                        if (fieldsXY.getFigure().isOK(blackKingField)) {
                         return true;
                        }
                    } else {
                        if(fieldsXY.getFigure().isOK(whiteKingField)) {
                         return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public void testForFigure(Field targetField) {
            if(targetField.getFigure().isWhite()){
                graveyardBlack.addFigure(targetField.getFigure());
            }else{
                graveyardWhite.addFigure(targetField.getFigure());
            }
    }

    public Figure promoteFigure(Figure figure){
            Figure toReturn = null;

        switch(figure.getAbbreviation()){
            case("P"):
                toReturn = new PromotedPawn(figure.getField(),"Promoted Pawn", "+" + figure.getAbbreviation(), figure.isWhite(), figure.isEuropeanIcon());
                break;
            case("R"):
                toReturn = new Dragon(figure.getField(),"Dragon", "+" + figure.getAbbreviation(), figure.isWhite(), figure.isEuropeanIcon());
                break;
            case("B"):
                toReturn = new Horse(figure.getField(),"Horse", "+" + figure.getAbbreviation(), figure.isWhite(), figure.isEuropeanIcon());
                break;
            case("L"):
                toReturn = new PromotedLance(figure.getField(),"Promoted Lance", "+" + figure.getAbbreviation(), figure.isWhite(), figure.isEuropeanIcon());
                break;
            case("S"):
                toReturn = new PromotedSilver(figure.getField(),"Promoted Silver", "+" + figure.getAbbreviation(), figure.isWhite(), figure.isEuropeanIcon());
                break;
            case("N"):
                toReturn = new PromotedKnight(figure.getField(),"Promoted Knight", "+" + figure.getAbbreviation(), figure.isWhite(), figure.isEuropeanIcon());
                break;
            default:
                break;
        }
        if(toReturn == null){
            return figure;
        }else{
            return toReturn;
        }

    }
}

package dev.shogi.controller;

import dev.shogi.board.Board;
import dev.shogi.board.Field;
import dev.shogi.board.Graveyard;
import dev.shogi.figures.Figure;
import dev.shogi.figures.basic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }

    public void createBoard() {
        board.buildBoard();
    }

    public void createGraveyard() {
        graveyardBlack = new Graveyard(board.isWhite());
        graveyardWhite = new Graveyard(!board.isWhite());
    }

    public void moveFigure(Figure figure, Field startField, Field targetField) {
        targetField.setFigure(figure);

        if (figure.isWhite()) {
            //im Tsume? setz Figur zurück
            if (this.isTsume(board.isWhite())) {
                startField.setFigure(figure);
                targetField.removeFigure();
                board.setReversed(true);
            }
        } else if (!figure.isWhite()) {
            //im Tsume? setz Figur zurück
            if (this.isTsume(!board.isWhite())) {
                startField.setFigure(figure);
                targetField.removeFigure();
                board.setReversed(true);
            }
        }
    }

    private boolean isTsume(boolean isWhite) {
        //TODO: Logik des im Schach programmieren
        return false;
    }

}

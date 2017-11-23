package dev.shogi.board;

import dev.shogi.figures.Figure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldListener implements ActionListener {

    Board board = Board.getInstance();
    Figure figure = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO FieldListener-Logik implementieren
        Field field = board.getFields()[((Field) e.getSource()).getX()][((Field) e.getSource()).getY()];
        Field startField = null;
        Field tempField = null;
        Field kingField = null;

    }
}

package dev.shogi.board;

import dev.shogi.controller.Controller;
import dev.shogi.figures.Figure;
import dev.shogi.figures.basic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {

    private final int BOARDSIZE;
    /*
     * weiß = 1 00000001 schwarz = 2 00000010 "beide" = 3 00000011
	 */
    private final int TURNWHITE = 1;
    private final int TURNBLACK = 2;
    private Board board;
    private FieldListener fieldListener = new FieldListener();
    private Field[][] fields;
    private char[] fieldNames;
    /**
     * Angabe des aktuellen Zuges - Welche Farbe darf ziehen
     * Schwarz beginnt beim Shogi
     */
    private int turn = TURNBLACK;

    private boolean isWhite = false;
    private boolean isTurnStart = true;
    private boolean isReversed;

    private boolean isEuropeanIcon;

    public GamePanel(int boardsize, Board board) {
        this.BOARDSIZE = boardsize;
        this.board = board;
        this.initComponents();
    }

    private void initComponents() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setLayout(new GridLayout(BOARDSIZE, BOARDSIZE));
        fields = new Field[BOARDSIZE][BOARDSIZE];
        fieldNames = this.initFieldnames();
        this.initFigures();
    }

    private void initFigures() {
        isEuropeanIcon = board.isEuropeanIcon();
        for (int row = 0; row < fields.length; row++) {
            for (int column = 0; column < fields[0].length; column++) {
                Field field = new Field(board, isWhite, Character.toString(fieldNames[row]) + Character.getNumericValue(fieldNames[column + BOARDSIZE]));
                field.setFieldX(column);
                field.setFieldY(row);
                fields[column][row] = field;
                field.addActionListener(fieldListener);
                this.add(field);
                field.setBackground(isWhite ? new Color(139, 90, 43) : new Color(255, 165, 79));

                if (row == 2) {
                    field.setFigure(new Pawn(field, "Pawn", "P", true, isEuropeanIcon), true);
                } else if (row == 6) {
                    field.setFigure(new Pawn(field, "Pawn", "P", false, isEuropeanIcon), true);
                }
                if (row == 1 && column == 1) {
                    field.setFigure(new Rook(field, "Rook", "R", true, isEuropeanIcon), true);
                } else if (row == 7 && column == 7) {
                    field.setFigure(new Rook(field, "Rook", "R", false, isEuropeanIcon), true);
                }
                if (row == 1 && column == 7) {
                    field.setFigure(new Bishop(field, "Bishop", "B", true, isEuropeanIcon), true);
                } else if (row == 7 && column == 1) {
                    field.setFigure(new Bishop(field, "Bishop", "B", false, isEuropeanIcon), true);
                }
                if (row == 0 && column == 0 || row == 0 && column == 8) {
                    field.setFigure(new Lance(field, "Lance", "L", true, isEuropeanIcon), true);
                } else if (row == 8 && column == 0 || row == 8 && column == 8) {
                    field.setFigure(new Lance(field, "Lance", "L", false, isEuropeanIcon), true);
                }
                if (row == 0 && column == 1 || row == 0 && column == 7) {
                    field.setFigure(new Knight(field, "Knight", "N", true, isEuropeanIcon), true);
                } else if (row == 8 && column == 1 || row == 8 && column == 7) {
                    field.setFigure(new Knight(field, "Knight", "N", false, isEuropeanIcon), true);
                }
                if (row == 0 && column == 2 || row == 0 && column == 6) {
                    field.setFigure(new SilverGeneral(field, "SilverGeneral", "S", true, isEuropeanIcon), true);
                } else if (row == 8 && column == 2 || row == 8 && column == 6) {
                    field.setFigure(new SilverGeneral(field, "SilverGeneral", "S", false, isEuropeanIcon), true);
                }
                if (row == 0 && column == 3 || row == 0 && column == 5) {
                    field.setFigure(new GoldenGeneral(field, "GoldenGeneral", "G", true, isEuropeanIcon), true);
                } else if (row == 8 && column == 3 || row == 8 && column == 5) {
                    field.setFigure(new GoldenGeneral(field, "GoldenGeneral", "G", false, isEuropeanIcon), true);
                }
                if (row == 0 && column == 4) {
                    field.setFigure(new King(field, "King", "K", true, isEuropeanIcon), true);
                } else if (row == 8 && column == 4) {
                    field.setFigure(new King(field, "King", "K", false, isEuropeanIcon), true);
                }
                isWhite = !isWhite;
            }
        }
    }

    private char[] initFieldnames() {
        char[] fieldNames = new char[BOARDSIZE + BOARDSIZE];

        for (int i = 0; i < fieldNames.length; i++) {
            if (i < BOARDSIZE) {
                fieldNames[i] = (char) (97 + i);
            } else {
                fieldNames[i] = Character.forDigit(fieldNames.length - i, 10);
            }
        }

        return fieldNames;
    }

    public Field[][] getFields() {
        return fields;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setReversed(boolean reversed) {
        isReversed = reversed;
    }

    public void saveTurnStart() {
        isTurnStart = false;
    }

    public void saveTurnEnd(Figure figure) {
        turn = figure.isWhite() ? TURNBLACK : TURNWHITE;
        isTurnStart = true;
    }

    public void refreshActiveGame(boolean isEuropeanIcon) {
        Figure figure;
        for (Field[] fieldsX : fields) {
            for (Field fieldXY : fieldsX) {
                if ((figure = fieldXY.getFigure()) != null) {
                    fieldXY.removeFigure(false);
                    figure.setEuropeanIcon(isEuropeanIcon);
                    fieldXY.setFigure(figure, true);
                }
            }
        }
        this.revalidate();
        this.repaint();
    }

    public void restartGame() {
        this.removeAll();
        this.initComponents();
        this.revalidate();
        this.repaint();
    }

    public class FieldListener implements ActionListener {

        Figure figure = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            Field field = null;
            Field startField;
            Field tempField;

            for (Field[] fieldsX : fields) {
                for (Field fieldXY : fieldsX) {
                    if (e.getSource() == fieldXY) {
                        field = fieldXY;
                        break;
                    }
                }
            }

            int turnMemory = turn;
            if (isTurnStart) {
                if ((figure = field.getFigure()) != null) {
                    if (!figure.isWhite() && ((turn & TURNBLACK) != 0) || figure.isWhite() && ((turn & TURNWHITE) != 0)) {
                        field.removeFigure(true);
                    }
                }
            } else if (figure.isOK(field)) {
                tempField = field;
                startField = figure.getField();
                field.setFigure(figure);
                Controller.getInstance().moveFigure(figure, startField, tempField);
                if (!isReversed) {
                    tempField.setFigure(figure);
                } else {
                    turn = turnMemory;
                    isReversed = false;
                }
            } else {
                figure.getField().setFigure(figure);
                turn = turnMemory;
            }

        }
    }
}

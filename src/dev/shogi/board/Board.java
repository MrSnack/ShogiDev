package dev.shogi.board;

import dev.shogi.controller.Controller;
import dev.shogi.figures.Figure;
import dev.shogi.figures.basic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Darstellng des Bretts als GUI
 *
 * @author Jannik Wolf
 */
public class Board extends JFrame {

    private final int BOARDSIZE = 9;
    private final Dimension BOARDSIZEMAX = new Dimension(1000, 900);
    private final Dimension BOARDSIZEMIN = new Dimension(550, 450);

    private JPanel pnlGame = new JPanel();
    private JPanel pnlMenu = new JPanel();

    private FieldListener fieldListener = new FieldListener();

    private Field[][] fields = new Field[BOARDSIZE][BOARDSIZE];
    private char[] fieldNames = this.initFieldnames();

    /*
	 * weiß = 1 00000001 schwarz = 2 00000010 "beide" = 3 00000011
	 */
    private final int TURNWHITE = 1;
    private final int TURNBLACK = 2;

    /**
     * Angabe des aktuellen Zuges - Welche Farbe darf ziehen
     * Schwarz beginnt beim Shogi
     */
    private int turn = TURNBLACK;

    private boolean isWhite = false;
    private boolean isTurnStart = true;
    private boolean isReversed;

    public void buildBoard() {
        this.setTitle("Shogi");
        this.setMaximumSize(BOARDSIZEMAX);
        this.setMinimumSize(BOARDSIZEMIN);
        this.setPreferredSize(BOARDSIZEMAX);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        pnlGame.setLayout(new GridLayout(BOARDSIZE, BOARDSIZE));
        //TODO Menu-Layout wählen
        //TODO Menu Spielsteinauswahl hinzufügen (europäisch oder japanisch)
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.initFigures();

        pnlMenu.setVisible(true);
        pnlGame.setVisible(true);
        pnlGame.setSize(900, 900);
        pnlMenu.setSize(100, 900);
        this.getContentPane().add(pnlGame, BorderLayout.CENTER);
        this.getContentPane().add(pnlMenu, BorderLayout.EAST);
        this.pack();
        this.setVisible(true);
    }

    private void initFigures() {

        for (int row = 0; row < fields.length; row++) {
            for (int column = 0; column < fields[0].length; column++) {
                Field field = new Field(this, isWhite, Character.toString(fieldNames[row]) + Character.getNumericValue(fieldNames[column + BOARDSIZE]));
                field.setFieldX(column);
                field.setFieldY(row);
                fields[column][row] = field;
                field.addActionListener(fieldListener);
                pnlGame.add(field);
                field.setBackground(isWhite ? new Color(139, 90, 43) : new Color(255, 165, 79));

                if (row == 2) {
                    field.setFigure(new Pawn(field, "Pawn", "P", true, true), true);
                } else if (row == 6) {
                    field.setFigure(new Pawn(field, "Pawn", "P", false, true), true);
                }
                if (row == 1 && column == 1) {
                    field.setFigure(new Rook(field, "Rook", "R", true, true), true);
                } else if (row == 7 && column == 7) {
                    field.setFigure(new Rook(field, "Rook", "R", false, true), true);
                }
                if (row == 1 && column == 7) {
                    field.setFigure(new Bishop(field, "Bishop", "B", true, true), true);
                } else if (row == 7 && column == 1) {
                    field.setFigure(new Bishop(field, "Bishop", "B", false, true), true);
                }
                if (row == 0 && column == 0 || row == 0 && column == 8) {
                    field.setFigure(new Lance(field, "Lance", "L", true, true), true);
                } else if (row == 8 && column == 0 || row == 8 && column == 8) {
                    field.setFigure(new Lance(field, "Lance", "L", false, true), true);
                }
                if (row == 0 && column == 1 || row == 0 && column == 7) {
                    field.setFigure(new Knight(field, "Knight", "N", true, true), true);
                } else if (row == 8 && column == 1 || row == 8 && column == 7) {
                    field.setFigure(new Knight(field, "Knight", "N", false, true), true);
                }
                if (row == 0 && column == 2 || row == 0 && column == 6) {
                    field.setFigure(new SilverGeneral(field, "SilverGeneral", "S", true, true), true);
                } else if (row == 8 && column == 2 || row == 8 && column == 6) {
                    field.setFigure(new SilverGeneral(field, "SilverGeneral", "S", false, true), true);
                }
                if (row == 0 && column == 3 || row == 0 && column == 5) {
                    field.setFigure(new GoldenGeneral(field, "GoldenGeneral", "G", true, true), true);
                } else if (row == 8 && column == 3 || row == 8 && column == 5) {
                    field.setFigure(new GoldenGeneral(field, "GoldenGeneral", "G", false, true), true);
                }
                if (row == 0 && column == 4) {
                    field.setFigure(new King(field, "King", "K", true, true), true);
                } else if (row == 8 && column == 4) {
                    field.setFigure(new King(field, "King", "K", false, true), true);
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

    void saveTurnStart() {
        isTurnStart = false;
    }

    public void saveTurnEnd(Figure figure) {
        turn = figure.isWhite() ? TURNBLACK : TURNWHITE;
        isTurnStart = true;
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
                        field.removeFigure();
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
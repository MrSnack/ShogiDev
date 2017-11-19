package dev.shogi.board;

import dev.shogi.figures.Figure;
import dev.shogi.figures.basic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame {

    private final int BOARDSIZE = 9;
    private final Dimension BOARDSIZEMAX = new Dimension(1000, 900);
    private final Dimension BOARDSIZEMIN = new Dimension(550, 450);

    private boolean isWhite = false;

    private JPanel pnlGame = new JPanel();
    private JPanel pnlMenu = new JPanel();
    private JList<Figure> lstGraveyardBlack;
    private JList<Figure> lstGraveyardWhite;

    private FieldListener fieldListener = new FieldListener();

    private Graveyard graveyardBlack = new Graveyard(isWhite);
    private Graveyard graveyardWhite = new Graveyard(!isWhite);
    private Field[][] fields = new Field[BOARDSIZE][BOARDSIZE];
    private char[] fieldNames = this.initFieldnames();

    public Board() {}

    public void buildBoard() {
        this.setTitle("Shogi");
        this.setMaximumSize(BOARDSIZEMAX);
        this.setMinimumSize(BOARDSIZEMIN);
        this.setPreferredSize(BOARDSIZEMAX);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pnlGame.setLayout(new GridLayout(BOARDSIZE, BOARDSIZE));
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
        for (int x = 0; x < fields.length; x++) {
            for (int y = 0; y < fields[0].length; y++) {
                Field f = new Field(this, isWhite, Character.toString(fieldNames[x]) + Character.getNumericValue(fieldNames[y + BOARDSIZE]));
                fields[x][y] = f;
                f.addActionListener(fieldListener);
                pnlGame.add(f);
                f.setBackground(isWhite ? new Color(139, 90, 43) : new Color(255, 165, 79));

                if (x == 2) {
                    f.setFigure(new Pawn(f, true, true), true);
                } else if (x == 6) {
                    f.setFigure(new Pawn(f, false, true), true);
                }
                if (x == 1 && y == 1) {
                    f.setFigure(new Rook(f, true, true), true);
                } else if (x == 7 && y == 7) {
                    f.setFigure(new Rook(f, false, true), true);
                }
                if (x == 1 && y == 7) {
                    f.setFigure(new Bishop(f, true, true), true);
                } else if (x == 7 && y == 1) {
                    f.setFigure(new Bishop(f, false, true), true);
                }
                if (x == 0 && y == 0 || x == 0 && y == 8) {
                    f.setFigure(new Lance(f, true, true), true);
                } else if (x == 8 && y == 0 || x == 8 && y == 8) {
                    f.setFigure(new Lance(f, false, true), true);
                }
                if (x == 0 && y == 1 || x == 0 && y == 7) {
                    f.setFigure(new Knight(f, true, true), true);
                } else if (x == 8 && y == 1 || x == 8 && y == 7) {
                    f.setFigure(new Knight(f, false, true), true);
                }
                if (x == 0 && y == 2 || x == 0 && y == 6) {
                    f.setFigure(new SilverGeneral(f, true, true), true);
                } else if (x == 8 && y == 2 || x == 8 && y == 6) {
                    f.setFigure(new SilverGeneral(f, false, true), true);
                }
                if (x == 0 && y == 3 || x == 0 && y == 5) {
                    f.setFigure(new GoldenGeneral(f, true, true), true);
                } else if (x == 8 && y == 3 || x == 8 && y == 5) {
                    f.setFigure(new GoldenGeneral(f, false, true), true);
                }
                if (x == 0 && y == 4) {
                    f.setFigure(new King(f, true, true), true);
                } else if (x == 8 && y == 4) {
                    f.setFigure(new King(f, false, true), true);
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

    public class FieldListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO FieldListener-Logik implementieren
        }
    }
}
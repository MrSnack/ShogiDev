package dev.shogi.board;

import dev.shogi.figures.Figure;
import dev.shogi.utilities.ImageProcessing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Field extends JButton {

    private Board board;
    private boolean isWhite;
    /**
     * Name ist die Position bestehend aus Buchstabe und Zahl.
     */
    private String name;
    private Figure figure = null;
    private int fieldX = -1;
    private int fieldY= -1;
    public Field() {
    }

    public Field(String name) {
        this.name = name;
    }

    public Field(Board board, boolean isWhite, String name) {
        this.board = board;
        this.isWhite = isWhite;
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }

    public int getFieldX() {
        return fieldX;
    }

    void setFieldX(int fieldX) {
        this.fieldX = fieldX;
    }

    public int getFieldY() {
        return fieldY;
    }

    void setFieldY(int fieldY) {
        this.fieldY = fieldY;
    }

    public void setFigure(Figure figure) { this.setFigure(figure, false); }

    void setFigure(Figure figure, boolean init) {
        //init gegen Beförderung von Figuren bei der Initialisierung
        /*if(!init && figur.getClass().getCanonicalName().equals("schach.Bauer") && (spalte == 0 || spalte == 8)) {
            figur = new Dame(this, figur.getSchwarz());
        }*/
        this.figure = figure;
        figure.setField(this, init);
        this.setForeground(figure.isWhite() ? Color.white : Color.black);
        this.setFont(new Font("Dialog", Font.BOLD, 36));
        //this.setText(figure.getSymbol());
        try {
            BufferedImage bufferedImage = ImageIO.read(this.getClass().getResource(figure.getImageURL())/*new File(figure.getImageURL())*/);
            if (figure.isWhite()) {
                bufferedImage = ImageProcessing.rotate180(bufferedImage);
            }
            Image img = bufferedImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            this.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void removeFigure(boolean isTurn) {
        this.figure = null;
        if (isTurn) {
            board.getPnlGame().saveTurnStart();
        }
        this.setIcon(null);
    }
}

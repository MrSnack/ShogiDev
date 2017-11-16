package dev.shogi.board;

import dev.shogi.figures.Figure;

import javax.swing.*;

public class Field extends JButton {

    private int x;
    private int y;
    /**
     * Name ist die Position bestehend aus Buchstabe und Name.
     */
    private String name;
    private Figure figure = null;

    public Field() {
    }

    public Field(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }
}

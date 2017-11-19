package dev.shogi.board;

import dev.shogi.figures.Figure;

import java.util.ArrayList;

public class Graveyard extends ArrayList<Figure> {

    private boolean isWhite;

    public Graveyard(boolean isWhite){
        this.isWhite = isWhite;
    }

    public boolean addFigure(Figure figure){
        return this.add(figure);
    }

    public boolean removeFigure(Figure figure) {
        return super.remove(figure);
    }

    public ArrayList<Figure> getFigureList() {
        return this;
    }
}

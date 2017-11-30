package dev.shogi.board;

import dev.shogi.figures.Figure;

import java.util.ArrayList;

public class Graveyard extends ArrayList<Figure> {

    private boolean isWhite;

    public Graveyard(boolean isWhite){
        this.isWhite = isWhite;
    }

    public void addFigure(Figure figure){
         this.add(figure);
    }

    public void removeFigure(Figure figure) {
         this.remove(figure);
    }

    public ArrayList<Figure> getFigureList() {
        return this;
    }
}

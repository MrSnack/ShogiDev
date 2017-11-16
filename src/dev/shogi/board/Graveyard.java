package dev.shogi.board;

import dev.shogi.figures.Figure;

import java.util.ArrayList;

public class Graveyard {

    private ArrayList<Figure> figureList;
    private boolean isWhite;

    public Graveyard(boolean isWhite){
        figureList = new ArrayList<>();
        this.isWhite = isWhite;
    }

    public void add(Figure figure){
        figureList.add(figure);
    }

    public void remove(Figure figure){
        figureList.remove(figure);

    }

    public ArrayList<Figure> getFigureList() {
        return figureList;
    }
}

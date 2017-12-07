package dev.shogi.board;

import dev.shogi.figures.Figure;
import dev.shogi.figures.basic.*;

import java.util.ArrayList;

public class Graveyard extends ArrayList<Figure> {

    private boolean isWhite;
    private Board board;

    public Graveyard(Board board, boolean isWhite){
        this.board = board;
        this.isWhite = isWhite;
    }

    public void addFigure(Figure figure){
        if(figure.getAbbreviation().contains("+")){

            switch (figure.getAbbreviation().charAt(1)){
                case 'R':
                            this.add(new Rook(null,"Rook", "R",this.isWhite, board.isEuropeanIcon()));
                    break;
                case'B':
                            this.add(new Bishop(null,"Bishop","B",this.isWhite,board.isEuropeanIcon()));
                    break;
                case'S':
                            this.add(new SilverGeneral(null,"SilverGeneral","S",this.isWhite,board.isEuropeanIcon()));
                    break;
                case'N':
                            this.add(new Knight(null,"Knight","N", this.isWhite, board.isEuropeanIcon()));
                    break;
                case'L':
                            this.add(new Lance(null, "Lance", "L", this.isWhite,board.isEuropeanIcon()));
                    break;
                case'P':
                            this.add(new Pawn(null,"Pawn","P",this.isWhite, board.isEuropeanIcon()));
                    break;
                default:
                    break;
            }
        }else{
            this.add(figure);
        }

    }

    public void removeFigurefromGraveyard(Figure figure) {
         this.remove(figure);
    }

    public ArrayList<Figure> getFigureList() {
        return this;
    }
}

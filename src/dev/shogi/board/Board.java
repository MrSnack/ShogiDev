package dev.shogi.board;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    private final int BOARDSIZE = 9;
    private final Dimension BOARDSIZEMAX = new Dimension(1000, 900);
    private final Dimension BOARDSIZEMIN = new Dimension(550, 450);
    private JPanel pnlGame = new JPanel();
    private JPanel pnlMenu = new JPanel();

    private Field[][] fields = new Field[BOARDSIZE][BOARDSIZE];
    private String[] fieldNames = new String[]{"9", "8", "7", "6", "5", "4", "3", "2", "1", "a", "b", "c", "d", "e", "f", "g", "h", "i"};

    public void buildBoard() {

        this.setTitle("Shogi");
        this.setMaximumSize(BOARDSIZEMAX);
        this.setMinimumSize(BOARDSIZEMIN);
        this.setPreferredSize(BOARDSIZEMIN);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        pnlGame.setLayout(new GridLayout(9, 9));

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                fields[x][y] = new Field(x, y, fieldNames[x] + fieldNames[y + 9]);
                pnlGame.add(fields[x][y]);
            }
        }

        this.add(pnlGame, BorderLayout.CENTER);
        this.add(pnlMenu, BorderLayout.EAST);

        this.setVisible(true);
    }
}
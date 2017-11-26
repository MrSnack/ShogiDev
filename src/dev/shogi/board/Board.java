package dev.shogi.board;

import javax.swing.*;
import java.awt.*;

/**
 * Darstellng des Bretts als GUI
 *
 * @author Jannik Wolf
 */
public class Board extends JFrame {

    private final int BOARDSIZE = 9;
    private final Dimension BOARDSIZEMAX = new Dimension(1000, 900);
    private final Dimension BOARDSIZEMIN = new Dimension(550, 450);

    private boolean isEuropeanIcon = true;

    private GamePanel pnlGame = new GamePanel(BOARDSIZE, this);
    private MenuPanel pnlMenu = new MenuPanel(this);

    public void buildBoard() {
        this.setTitle("Shogi");
        this.setMaximumSize(BOARDSIZEMAX);
        this.setMinimumSize(BOARDSIZEMIN);
        this.setPreferredSize(BOARDSIZEMAX);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        pnlMenu.setVisible(true);
        pnlGame.setVisible(true);
        pnlGame.setSize(900, 900);
        pnlMenu.setSize(100, 900);
        this.getContentPane().add(pnlGame, BorderLayout.CENTER);
        this.getContentPane().add(pnlMenu, BorderLayout.EAST);
        this.pack();
        this.setVisible(true);
    }

    public boolean isEuropeanIcon() {
        return isEuropeanIcon;
    }

    public void setEuropeanIcon(boolean europeanIcon) {
        isEuropeanIcon = europeanIcon;
    }

    public GamePanel getPnlGame() {
        return pnlGame;
    }
}
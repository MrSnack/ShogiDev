package dev.shogi.board;

import javax.swing.*;
import java.awt.*;

/**
 * Darstellng des Bretts als GUI
 *
 * @author Jannik Wolf
 */
public class Board extends JFrame {

    /**
     * Festlegung der maximalen Anzahl an Feldern in einer Reihe oder Spalte
     */
    private final int BOARDSIZE = 9;
    /**
     * Maximale Groesse des Programmfensters
     */
    private final Dimension BOARDSIZEMAX = new Dimension(1000, 900);
    /**
     * Minimale Groesse des Programmfensters
     */
    private final Dimension BOARDSIZEMIN = new Dimension(550, 450);

    /**
     * Festlegung der Spielsteinicons - Europaeisch oder Japanisch
     */
    private boolean isEuropeanIcon = true;

    /**
     * Panel zur Erzeugung des Spielfeldes
     */
    private GamePanel pnlGame = new GamePanel(BOARDSIZE, this);
    /**
     * Panel zur Erzeugung des Menues
     */
    private MenuPanel pnlMenu = new MenuPanel(this);

    /**
     * Methode zum Aufbau des Boards (JFrame)
     */
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

    /**
     * Getter für die Auswahl der Spielsteinicons
     *
     * @return true, wenn europaeische Spielsteinicons gewaehlt sind, ansonsten false (jap. Icons)
     */
    public boolean isEuropeanIcon() {
        return isEuropeanIcon;
    }

    /**
     * Festlegung der Spielsteinicons
     * @param europeanIcon - true, wenn europaeische Icons, ansonsten false (japanische Icons)
     */
    public void setEuropeanIcon(boolean europeanIcon) {
        isEuropeanIcon = europeanIcon;
    }

    /**
     * Getter, um das GamePanel und Methoden daraus zu bekommen
     * @return das aktuelle GamePanel
     */
    public GamePanel getPnlGame() {
        return pnlGame;
    }

    /**
     * Gett, um das MenuPanel und Methoden daraus zu bekommen
     *
     * @return das aktuelle MenuPanel
     */
    public MenuPanel getPnlMenu() {
        return pnlMenu;
    }
}
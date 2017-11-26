package dev.shogi.board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {

    private Board board;

    private JRadioButton rbtnEuropeanIcons;
    private JRadioButton rbtnJapaneseIcons;
    private ButtonGroup btngIconsGroup = new ButtonGroup();
    private Box boxIcons = Box.createVerticalBox();

    public MenuPanel(Board board) {
        this.board = board;
        this.initComponents();
        this.initActions();
    }

    private void initComponents() {
        rbtnEuropeanIcons = new JRadioButton("Europäische Steine", board.isEuropeanIcon());
        rbtnJapaneseIcons = new JRadioButton("Japanische Steine", !board.isEuropeanIcon());
        btngIconsGroup.add(rbtnEuropeanIcons);
        btngIconsGroup.add(rbtnJapaneseIcons);
        boxIcons.add(rbtnEuropeanIcons);
        boxIcons.add(rbtnJapaneseIcons);
        boxIcons.setBorder(BorderFactory.createTitledBorder("Steinsatz"));

        this.setLayout(new GridBagLayout());
        //TODO Menu-Layout wählen
        //TODO Menu Spielsteinauswahl hinzufügen (europäisch oder japanisch)
        GridBagConstraints grid = new GridBagConstraints();
        grid.insets = new Insets(5, 5, 5, 5);
        grid.anchor = GridBagConstraints.NORTH;

        grid.gridheight = 1;
        grid.gridwidth = 2;
        grid.gridx = 0;
        grid.gridy = 0;
        this.add(boxIcons, grid);

    }

    private void initActions() {
        rbtnEuropeanIcons.addActionListener((ActionEvent e) -> {
            board.setEuropeanIcon(true);
            board.getPnlGame().refreshActiveGame(true);
        });
        rbtnJapaneseIcons.addActionListener((ActionEvent e) -> {
            board.setEuropeanIcon(false);
            board.getPnlGame().refreshActiveGame(false);
        });
    }
}

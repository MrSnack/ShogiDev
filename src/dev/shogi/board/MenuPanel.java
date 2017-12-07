package dev.shogi.board;

import dev.shogi.utilities.ImageProcessing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class MenuPanel extends JPanel {

    private final String whiteIconPath = "resources/defaultIcons/defaultWhiteIcon.png";
    private final String blackIconPath = "resources/defaultIcons/defaultBlackIcon.png";

    private Board board;
    private File icon;

    private JLabel lblActivePlayer = new JLabel();
    private JLabel lblActiveGraveyard = new JLabel();
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
        this.changeActivePlayer(!board.getPnlGame().isWhite());
        rbtnEuropeanIcons = new JRadioButton("Europäische Steine", board.isEuropeanIcon());
        rbtnJapaneseIcons = new JRadioButton("Japanische Steine", !board.isEuropeanIcon());
        btngIconsGroup.add(rbtnEuropeanIcons);
        btngIconsGroup.add(rbtnJapaneseIcons);
        boxIcons.add(rbtnEuropeanIcons);
        boxIcons.add(rbtnJapaneseIcons);
        boxIcons.setBorder(BorderFactory.createTitledBorder("Steinsatz"));

        this.setLayout(new GridBagLayout());
        //TODO Graveyard zum Menu mit Labels hinzufügen
        GridBagConstraints grid = new GridBagConstraints();
        grid.insets = new Insets(5, 5, 5, 5);
        grid.anchor = GridBagConstraints.PAGE_START;

        grid.gridheight = 2;
        grid.gridwidth = 2;
        grid.gridx = 0;
        grid.gridy = 0;
        this.add(lblActivePlayer, grid);

        grid.gridheight = 2;
        grid.gridy = 2;
        this.add(lblActiveGraveyard, grid);

        grid.gridheight = 1;
        grid.gridwidth = 2;
        grid.gridx = 0;
        grid.gridy = 4;
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

    public void changeActivePlayer(boolean isWhite) {
        if (isWhite) {
            icon = new File(whiteIconPath);
        } else {
            icon = new File(blackIconPath);
        }
        try {
            BufferedImage bufferedImage = ImageIO.read(icon);
            if (isWhite) {
                bufferedImage = ImageProcessing.rotate180(bufferedImage);
            }
            Image img = bufferedImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            lblActivePlayer.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

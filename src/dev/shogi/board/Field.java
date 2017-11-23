package dev.shogi.board;

import dev.shogi.figures.Figure;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Field extends JButton {

    private Board board;
    private boolean isWhite;
    /**
     * Name ist die Position bestehend aus Buchstabe und Zahl.
     */
    private String name;
    private Figure figure = null;
    private int fieldX = -1;
    private int fieldY= -1;
    public Field() {
    }

    public Field(String name) {
        this.name = name;
    }

    public Field(Board board, boolean isWhite, String name) {
        this.board = board;
        this.isWhite = isWhite;
        this.name = name;
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

    public int getFieldX() {
        return fieldX;
    }

    public void setFieldX(int fieldX) {
        this.fieldX = fieldX;
    }

    public int getFieldY() {
        return fieldY;
    }

    public void setFieldY(int fieldY) {
        this.fieldY = fieldY;
    }

    void setFigure(Figure figure, boolean init) {
        //init gegen Beförderung von Figuren bei der Initialisierung
        /*if(!init && figur.getClass().getCanonicalName().equals("schach.Bauer") && (spalte == 0 || spalte == 8)) {
            figur = new Dame(this, figur.getSchwarz());
        }*/
        this.figure = figure;
        figure.setField(this);
        this.setForeground(figure.isWhite() ? Color.white : Color.black);
        this.setFont(new Font("Dialog", Font.BOLD, 36));
        //this.setText(figure.getSymbol());
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(figure.getImageURL()));
            if (figure.isWhite()) {
                bufferedImage = rotate180(bufferedImage);
            }
            Image img = bufferedImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            this.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private BufferedImage rotate180( BufferedImage inputImage ) {
        //We use BufferedImage because it’s provide methods for pixel manipulation
        int width = inputImage.getWidth(); //the Width of the original image
        int height = inputImage.getHeight();//the Height of the original image

        BufferedImage returnImage = new BufferedImage( width, height, inputImage.getType()  );
        //we created new BufferedImage, which we will return in the end of the program
        //it set up it to the same width and height as in original image
        // inputImage.getType() return the type of image ( if it is in RBG, ARGB, etc. )

        for( int x = 0; x < width; x++ ) {
            for( int y = 0; y < height; y++ ) {
                returnImage.setRGB( width - x - 1, height - y - 1, inputImage.getRGB( x, y  )  );
            }
        }
        //so we used two loops for getting information from the whole inputImage
        //then we use method setRGB by whitch we sort the pixel of the return image
        //the first two parametres is the X and Y location of the pixel in returnImage and the last one is the //source pixel on the inputImage
        //why we put width – x – 1 and height –y – 1 is hard to explain for me, but when you rotate image by //180degree the pixel with location [0, 0] will be in [ width, height ]. The -1 is for not to go out of
        //Array size ( remember you always start from 0 so the last index is lower by 1 in the width or height
        //I enclose Picture for better imagination  ... hope it help you
        return returnImage;
        //and the last return the rotated image

    }
}

package dev.shogi.starter;

import dev.shogi.controller.Controller;

public class Shogi {

    public static void main(String[] args) {
        System.out.println("Startet!");
        Controller.getInstance();
    }
}
package Kursach.Main;

import Kursach.Display.Display;
import Kursach.Game.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by daniil on 14.12.16.
 */
public class Main {
    public static void main(String[] args) {

        Game tanks = new Game();
        tanks.start();

    }
}
package Kursach.Game;


import Kursach.Texture.Road;

import javax.swing.*;

/**
 * Created by daniil on 21.12.16.
 */
public class Main {
    public static void main(String[] args) {

        JFrame f = new JFrame("NFS");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 890);
        f.add(new Road());
        f.setVisible(true);
    }
}

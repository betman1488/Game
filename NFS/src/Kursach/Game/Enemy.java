package Kursach.Game;

import Kursach.Texture.Road;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniil on 22.12.16.
 */
public class Enemy {

    public int x;
    public int y;
    int v;

    public Image img = new ImageIcon(getClass().getClassLoader().getResource("res/1bot.png")).getImage();
    Road road;

    public Rectangle getRect() {
        return new Rectangle(x, y, 100, 20);
    }

    public Enemy (int x, int y, int v, Road road) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }

    public void muve () {
        y++;

    }

}

package Kursach.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;

/**
 * Created by daniil on 22.12.16.
 */
public class Player {

    public static final int MAX_V = 5; // максимальная скорость
    public static final int MAX_LEFT = 10; //максимальная координата левого края
    public static final int MAX_RIGHT = 410; // максимальная координата правого края

    Image imgR = new ImageIcon(getClass().getClassLoader().getResource("res/right.png")).getImage();
    Image imgL = new ImageIcon(getClass().getClassLoader().getResource("res/left.png")).getImage();
    Image imgC = new ImageIcon(getClass().getClassLoader().getResource("res/Player.png")).getImage();

    public Image img = imgC;




    public Rectangle getRect() {
        return new Rectangle(x, y, 130, 30);
    }

    public double v = 0; //скорость
    double dv = 0; //ускорение
    public int s = 0; //пройденый путь

    public int x = 210;
    public int y = 600;
    public double dx = 0;

    public int layer1 = 0; // первый слой
    public int layer2 = 900; // второй слой

    public void muve () {
        s += v; // подсчет пройденого пути
        v += dv; // подсчет скорости

        if (v <= 0)
            v = 0;
        if (v >= MAX_V)
            v = MAX_V;
        if (x <= MAX_LEFT)
            x = MAX_LEFT;
        if (x >= MAX_RIGHT)
            x = MAX_RIGHT;
        x -= dx; // управление скоростью
        if (layer2 - v <= 0) { //цилк дороги
            layer1 = 0;
            layer2 = 900;
        }
        else {
            layer1 -= v; //илюзия движения
            layer2 -= v;
        }
    }

    public void keyPressed (KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dv = 0.01;
            y = y - 5;
        }
        if (key == KeyEvent.VK_SPACE) {
            dv = -0.01;
        }
        if (key == KeyEvent.VK_DOWN) {
            y = y + 5;
        }
        if (key == KeyEvent.VK_LEFT) {
            dx = 1;
            img = imgL;
            if (key == KeyEvent.VK_UP & img == imgL)
                y = y - 15;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = -1;
            img = imgR;
            if (key == KeyEvent.VK_UP &img == imgR)
                y = y - 15;
        }
    }

    public void keyReleased (KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_SPACE) {
            dv = 0;
        }

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            dx = 0;
            img = imgC;
        }
    }

}

package Kursach.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by daniil on 22.12.16.
 */
public class Player {

    public static final int MAX_V = 50; // максимальная скорость
    public static final int MAX_LEFT = 10; //максимальная координата левого края
    public static final int MAX_RIGHT = 410; // максимальная координата правого края

    public Image img = new ImageIcon("res/Player.png").getImage();
    Image imgR = new ImageIcon("res/right.png").getImage();
    Image imgL = new ImageIcon("res/left.png").getImage();

    int v = 0; //скорость
    int dv = 0; //ускорение
    int s = 0; //пройденый путь

    public int x = 210;
    public int y = 600;
    public int dx = 0;

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
            dv = 5;
        }
        if (key == KeyEvent.VK_DOWN) {
            dv = -5;
        }
        if (key == KeyEvent.VK_LEFT) {
            dx = 10;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = -10;
        }
    }

    public void keyReleased (KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dv = 0;
        }

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

}

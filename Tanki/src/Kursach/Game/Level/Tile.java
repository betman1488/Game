package Kursach.Game.Level;

import Kursach.Graphics.Sprite;
import Kursach.Graphics.SpriteSheet;
import Kursach.Utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by daniil on 19.12.16.
 */
public class Tile {

    private BufferedImage image;
    private TyleType type;

    protected Tile(BufferedImage image, int scale, TyleType type) {
        this.type = type;
        this.image = Utils.resize(image, image.getWidth() * scale, image.getHeight() * scale);

    }

    public void render(Graphics2D g, int x, int y) {
        g.drawImage(image, x, y, null);
    }

    public TyleType type() { //узнать тип тайла
        return type;
    }
}

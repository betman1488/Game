package Kursach.Graphics;

import Kursach.Utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by daniil on 17.12.16.
 */
public class Sprite {

    private SpriteSheet sheet;
    private float scale; //на сколько большим хотим рисовать спрайт
    private BufferedImage image;


    public Sprite(SpriteSheet sheet, float sclae) {
        this.sheet = sheet;
        this.scale = sclae;
        image = sheet.getSprite(0);
        image = Utils.resize(image, (int) (image.getWidth() * sclae), (int) (image.getHeight() * sclae));
    }

    public void render(Graphics2D g, float x, float y) {
          g.drawImage(image, (int)(x), (int)(y), null);

    }

}

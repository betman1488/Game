package Kursach.Graphics;

import Kursach.Utils.ResourseLoader;

import java.awt.image.BufferedImage;

/**
 * Created by daniil on 17.12.16.
 */
public class TextureAtlas {

    BufferedImage image;    //держит само изображение

    public TextureAtlas(String imageName) {
        image = ResourseLoader.loadImage(imageName);
    }

    public BufferedImage cut(int x, int y, int w, int h) {
        return image.getSubimage(x, y, w, h); //вырезание новой картинки
    }

}

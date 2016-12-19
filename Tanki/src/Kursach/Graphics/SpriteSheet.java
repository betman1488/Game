package Kursach.Graphics;

import java.awt.image.BufferedImage;

/**
 * Created by daniil on 17.12.16.
 */
public class SpriteSheet {

    private BufferedImage sheet; // большая картинка
    private int spriteCount; //колво спрайтов в большой (sheet) картинки
    private int scale; // размер одного спрайта
    private int spritesInWidth; //кол-во спрайтов в ширину

    public SpriteSheet(BufferedImage sheet, int spriteCount, int scale) {
        this.sheet = sheet;
        this.spriteCount = spriteCount;
        this.scale = scale;

        this.spritesInWidth = sheet.getWidth() / scale; // находим 4 спрайта в картинке
    }

    public BufferedImage getSprite(int index) {

        index = index % spriteCount; // сброс спрайта для показа с начала

        int x = index % spritesInWidth * scale; // выташить одну картинку
        int y = index / spritesInWidth * scale; // выташить одну картинку

        return sheet.getSubimage(x, y, scale, scale);
    }
}

package Kursach.Game;

import Kursach.Graphics.Sprite;
import Kursach.Graphics.SpriteSheet;
import Kursach.Graphics.TextureAtlas;
import Kursach.Io.Input;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by daniil on 17.12.16.
 */
public class Player2 extends Entity {

    public static final int SPRITE_SCALE = 16;
    public static final int SPRITES_PER_HEADING = 1; //для анимации

    private enum Heading{ //направление
        NORTH(8 * SPRITE_SCALE, 8 * SPRITE_SCALE, 1 *SPRITE_SCALE, 1 * SPRITE_SCALE), //верх
        EAST(14 * SPRITE_SCALE, 8 * SPRITE_SCALE, 1 *SPRITE_SCALE, 1 * SPRITE_SCALE), //право
        SOUTH(12 * SPRITE_SCALE, 8 * SPRITE_SCALE, 1 *SPRITE_SCALE, 1 * SPRITE_SCALE), //низ
        WEST(10 * SPRITE_SCALE, 8 * SPRITE_SCALE, 1 *SPRITE_SCALE, 1 * SPRITE_SCALE); //лево

        private int x, y, h, w; //координата самого спрайта

        Heading(int x, int y, int h, int w) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.w = w;
        }

        protected BufferedImage texture(TextureAtlas atlas) {//рисуем
            return atlas.cut(x, y, w, h);
        }
    }

    private Heading heading; //в какую сторону смотрит наш танк
    private Map<Heading, Sprite> spriteMap; //вытаскивает правильный спрайт
    private float scale;
    private float speed;

    public Player2(float x, float y, float scale, float speed, TextureAtlas atlas) {
        super(EntityType.Player, x, y);

        heading = Heading.NORTH; // направление носа в начале танка
        spriteMap = new HashMap<Heading, Sprite>(); //карта
        this.scale = scale;
        this.speed = speed;

        for (Heading h : Heading.values()) {
            SpriteSheet sheet = new SpriteSheet(h.texture(atlas), SPRITES_PER_HEADING, SPRITE_SCALE);
            Sprite sprite = new Sprite(sheet, scale);
            spriteMap.put(h, sprite); //направлние с прайт связали
        }
    }

    @Override
    public void update(Input input) {

        float newX = x;
        float newY = y;

        if (input.getKay(KeyEvent.VK_W)) {
            newY -= speed;
            heading = Heading.NORTH;
        } else if (input.getKay(KeyEvent.VK_D)) {
            newX += speed;
            heading = Heading.EAST;
        } else if (input.getKay(KeyEvent.VK_S)) {
            newY += speed;
            heading = Heading.SOUTH;
        } else if (input.getKay(KeyEvent.VK_A)) {
            newX -= speed;
            heading = Heading.WEST;
        }

        if (newX < 0) {
            newX = 0;
        } else if (newX >= Game.WIDTH - SPRITE_SCALE * scale) {
            newX = Game.WIDTH - SPRITE_SCALE * scale;
        }

        if (newY < 0) {
            newY = 0;
        } else if (newY >= Game.HEIGHT - SPRITE_SCALE * scale) {
            newY = Game.HEIGHT - SPRITE_SCALE * scale;
        }

        x = newX;
        y = newY;
    }


    @Override
    public void render(Graphics2D g) {
        spriteMap.get(heading).render(g, x, y); // рисует спрайт в правильном направление
    }
}


package Kursach.Game;

import Kursach.Io.Input;

import java.awt.*;

/**
 * Created by daniil on 17.12.16.
 */
public abstract class Entity {

    public final EntityType type; // тип файла


    protected float x;  //место нахождения вещей
    protected float y;  //место нахождения вещей

    public Entity(EntityType type, float x, float y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public abstract void update(Input input);


    public abstract void render(Graphics2D g);
}

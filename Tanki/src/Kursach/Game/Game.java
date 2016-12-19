package Kursach.Game;

import Kursach.Display.Display;
import Kursach.Game.Level.Level;
import Kursach.Graphics.TextureAtlas;
import Kursach.Io.Input;
import Kursach.Utils.Time;

import java.awt.*;


/**
 * Created by daniil on 16.12.16.
 */
public class Game implements Runnable{

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "Tanks";
    public static final int CLEAR_COLOR = 0xff000000;
    public static final int NUM_BUFFERS = 3;

    public static final float UPDATE_RATE = 60.0f ; //сколько раз мы хотим считать нашу физику
    public static final float UPDATE_INTERVAL= Time.SECOND/ UPDATE_RATE;//сколько времени должно проходить между каждым обдейтом
    public static final long IDLE_TIME = 1; //остановка чтоб ничего не делал (нужен для запуска других фредов)

    public static final String ATLAS_FILE_NAME = "texture_atlas.png";

    private boolean running;    //проверка бежит игра или нет
    private Thread gameThread;  //процесс который дополнительно запускаем
    private Input input;
    private TextureAtlas atlas;
    private Graphics2D graphics;
    private Player player;
    private Player2 player2;
    private Level lvl;


    public Game(){
        running = false;
        Display.create(WIDTH, HEIGHT, TITLE, CLEAR_COLOR, NUM_BUFFERS);
        graphics = Display.getGraphics();
        input = new Input();
        Display.addInpetListener(input);
        atlas = new TextureAtlas(ATLAS_FILE_NAME);
        player = new Player(300, 300, 2, 3, atlas);
        player2 = new Player2(400, 400, 2, 4, atlas);
        lvl = new Level(atlas);

    }

    public synchronized void start(){ //synchronized вызывается из одного процессора

        if(running)
            return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start(); //запустит метод run

    }

    public synchronized void stop(){ //не может останавливать два вреда игру

        if(!running)
            return;
        running = false;
        try{
            gameThread.join(); //ждет пока добежит функция start
        }catch (InterruptedException e) {
            e.printStackTrace(); //распечатать где этот эксепш произошел
        }

        cleanUp(); //функция очишения

    }

    private void update(){ //физика игры
        player.update(input);
        player2.update(input);
        lvl.update();
    }

    private void render(){
        Display.clear(); // чистим экран
        lvl.render(graphics);
        player.render(graphics);
        player2.render(graphics);
        lvl.renderMetal(graphics);
        lvl.renderGrass(graphics);
        Display.swapBuffers(); //закончили рисовать и хотим показать
    }

    public void run() {

        int fps = 0;
        int upd = 0;
        int updlups = 0;

        long count = 0;

        float delta = 0;

        long lastTime = Time.get(); //время в котором бежала прошлая итерация лупа
        while (running){ //пока он true он будет бежать (следит чтоб всегда было 60)
            long now = Time.get(); //берет тикушее время
            long elapseTime = now - lastTime;   //(наносек) сколько времени прошло последней пробежке лупа
            lastTime = now; //прошлое время делаем нового времени

            count += elapseTime; //время которое проходит по ходу игры

            boolean render = false; //для проверки изменения игры
            delta += ( elapseTime / UPDATE_INTERVAL );//колво аптейтов
            while (delta > 1){
                update();
                upd++;
                delta--; //держит равновесие с аптейтом (60 по теории)
                if(render) {
                    updlups++;
                }
                else {
                    render = true; // перерисуем экран
                }

            }

            if(render){ // если были изменения
                render(); //рисуем заново новую картинку
                fps++;
            }
            else{
                try {
                    Thread.sleep(IDLE_TIME); //дать другим фредам работу
                } catch (InterruptedException e) { //поиск проблемы
                    e.printStackTrace(); //печать проблемы
                }
            }

            if(count >= Time.SECOND){
                Display.setTitle(TITLE + "       || Fps:" + fps + " | Upd:" + upd + " | Updlups:" + updlups);
                upd = 0;
                fps = 0;
                updlups = 0;
                count = 0;
            }

        }

    }

    private void cleanUp(){
        Display.destroy(); //уничтожаем окно после закрытия
    }

}

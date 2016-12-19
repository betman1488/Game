package Kursach.Display;

import Kursach.Io.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

/**
 * Created by daniil on 14.12.16.
 */
public abstract class Display {

    private static boolean created = false;
    private static JFrame window;
    private static Canvas content;

    private static BufferedImage buffer;
    private static int[] bufferData; //запись информации image
    private static Graphics bufferGraphics;
    private static int clearColor; //очистка buffer

    private static BufferStrategy bufferStrategy;


    public static void create(int width, int height, String title, int _clearColor, int numBuffers) {
        if (created)
            return;

        window = new JFrame(title); //окно
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content = new Canvas(); //лист

        Dimension size = new Dimension(width, height); //размер листа
        content.setPreferredSize(size); // передаем параметры листа


        window.setResizable(false); //неменяемы размер
        window.getContentPane().add(content); //возврашает внутренную часть окна
        window.pack(); //изменяет размер окна чтоб он подходил точно по размера листа
        window.setVisible(true); //видимость окна
        window.setLocationRelativeTo(null); //центр окна

        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        bufferData = ((DataBufferInt) buffer.getRaster().getDataBuffer()).getData(); //вытаскиваем arr из buffera
        bufferGraphics = buffer.getGraphics(); //множество операций с графикой
        ((Graphics2D) bufferGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        clearColor = _clearColor;

        content.createBufferStrategy(numBuffers);
        bufferStrategy = content.getBufferStrategy();

        created = true;
    }

    public static void clear() { //заполнение фона //функция заменяет фор луп пробег по bufferData и ставка clearColor
        Arrays.fill(bufferData, clearColor);

    }

    public static void swapBuffers() { //меняет на новую сцену
        Graphics g = bufferStrategy.getDrawGraphics(); // вернет графический baffer обьект на котором мы должны рисовать
        g.drawImage(buffer, 0, 0, null);
        bufferStrategy.show();  //показывает перерисованый бафер
    }

    public static Graphics2D getGraphics() {
        return (Graphics2D) bufferGraphics;
    }

    public static void destroy(){
        if(!created)
            return;
        window.dispose();
    }

    public static void setTitle(String title){ //меняет имя окна
        window.setTitle(title);
    }

    public static void addInpetListener(Input inputListener) {
        window.add(inputListener);
    }
}

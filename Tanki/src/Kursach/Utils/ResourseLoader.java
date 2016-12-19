package Kursach.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by daniil on 17.12.16.
 */
public class ResourseLoader {

    public static final String PATH = "res/"; //держит путь к папке

    public static BufferedImage loadImage(String fileName) {

        BufferedImage image = null;

        try{
            image = ImageIO.read(new File( PATH + fileName)); // загрузка нового файла
        }catch (IOException e) {
            e.printStackTrace();
        }

        return image;


    }

}

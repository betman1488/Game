package Kursach.Utils;

import java.awt.image.BufferedImage;

/**
 * Created by daniil on 19.12.16.
 */
public class Utils {

    public static BufferedImage resize(BufferedImage image, int width, int height) { // изменение картинки
        BufferedImage newImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
        newImage.getGraphics().drawImage(image, 0, 0, width, height, null); //на новом бафере нарисовали новую картинку



        return newImage;
    }

}

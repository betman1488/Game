package Kursach.Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by daniil on 22.12.16.
 */
public class Audio implements Runnable {

    @Override
    public void run() {

        try {
            File p = new File("Need+For+Speed+-+Underground.mp3");

            AudioInputStream ais = AudioSystem.getAudioInputStream(p);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 1000);
            clip.stop();
            clip.close();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

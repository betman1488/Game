package Kursach.Io;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by daniil on 17.12.16.
 */
public class Input extends JComponent {

    private boolean[] map; //значение кнопок

    public Input(){

        map = new boolean[256];

        for(int i = 0; i < map.length; i++) {

            final int KEY_CODE = i; //копия кода кнопки

            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(i, 0, false)/*нажатие кнопки*/ , i * 2); //карту в которую мы можем добавлять значения и давать название когда окно в фокусе
            getActionMap().put(i * 2, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    map[KEY_CODE] = true;
                }
            });

            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(i, 0, true)/*нажатие кнопки*/ , i * 2 + 1); //карту в которую мы можем добавлять значения и давать название когда окно в фокусе
            getActionMap().put(i * 2 + 1, new AbstractAction() { //каждый раз когда мы вызываем кнопку
                @Override
                public void actionPerformed(ActionEvent e) {
                    map[KEY_CODE] = false; // делаем ее false
                }
            });
        }

    }

    public boolean[] getMap(){ //какие кнопки нажаты
        return Arrays.copyOf(map, map.length);  //возвращает всю катру
    }

    public boolean getKay(int keyCode){ //нажата ли кнопка
        return map[keyCode];
    }


}

package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Igra21 {
    static int enemyWin = 0;
    static int igrokWin = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nДобро пожаловать в игру \"21\".\n");

        begin();

        while (true) {
            System.out.println("\t\tСоперник: " + enemyWin + "\t\t Вы: " + igrokWin + "\n\nПродолжим играть?\n \"Enter - закончить\" - \"еще\".");
            if (reader.readLine().equals("еще")) {
                begin();
            }
            else {
                System.out.println("Конец игры!");
                break;
            }
        }
    }

    public static void begin() throws IOException {
        Igra igra = new Igra();
        igra.beginGame();
        igra.hodIgroka();
        igra.hodEnemy();
        igra.ktoVin();
        enemyWin += igra.enemyWin;
        igrokWin += igra.igrokWin;
    }
}

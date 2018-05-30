package Game;

import Koloda.Koloda;
import Player.Enemy;
import Player.Igrok;
import Koloda.Karta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Igra
{

    int enemyWin = 0;
    int igrokWin = 0;
    boolean trueGame = true;
    Koloda koloda = new Koloda();
    Igrok igrok = new Igrok();
    Enemy enemy = new Enemy();

    public void beginGame(){
        koloda.zapolnenie();
        polosa();
        System.out.println("\t\tИгра началась, новая колода создана.");
        polosa();
        igrok.addKatra(koloda.getKarta());
        igrok.addKatra(koloda.getKarta());
        enemy.addKatra(koloda.getKarta());
        enemy.addKatra(koloda.getKarta());
        System.out.println("\t\t\tВы берете 2 карты.");
        polosa();
    }

    public void hodIgroka() throws IOException
    {
        trueGame = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\t\t\t\tВаш ход\n");
        while (igrok.points() < 21){
            System.out.println("\tУ Вас " + igrok.points() + " очков\t\t" + "\n\n \"1\" - Взять карту \n \"2\" - Проверить карты на руках\n \"3\" - Закончить ход");
            polosa();
            String otvet = reader.readLine();
            if (otvet.equals("1")) {
                Karta prom = koloda.getKarta();
                igrok.addKatra(prom);
                System.out.println("\nВы получили: " + prom.nominal + ", эта карта стоит " + prom.sila + " очков");
                polosa();
            }
            if (otvet.equals("2")) {
                System.out.println("У Вас на руках: \n " + igrok.moiKarti());
                polosa();
            }
            if (otvet.equals("3")) {
                System.out.println("Вы набрали " + igrok.points() + "\n");
                polosa();
                System.out.println("\n\t\t\t\tХод соперника.\n");
                break;
            }
        }
        if (igrok.points() == 21){
            System.out.println("Вы набрали " + igrok.points() + " это 21!!! Вы Выиграли!\n");
            trueGame = false;
            igrokWin = 1;
            polosa();
        }
        if (igrok.points() > 21){
            System.out.println("Вы набрали " + igrok.points()+" это больше 21. Вы Проиграли.\n");
            trueGame = false;
            enemyWin = 1;
            polosa();
        }
    }

    public void hodEnemy()
    {
            if (trueGame){
            System.out.println("У соперника: " + enemy.moiKarti());
            polosa();
        }
        while (enemy.points() < 21 && enemy.points() <= igrok.points() && trueGame){
            System.out.println("У соперника " + enemy.points() + " очков.");
            if (enemy.points() < 11){
                Karta prom = koloda.getKarta();
                enemy.addKatra(prom);
                System.out.println("Соперник взял карту " + prom.nominal + " эта карта стоит " + prom.sila+" очков");
                polosa();
                continue;
            }else if (enemy.points() < 14 && enemy.toDuThis(80)){
                Karta prom = koloda.getKarta();
                enemy.addKatra(prom);
                System.out.println("Соперник взял карту " + prom.nominal + " эта карта стоит " + prom.sila + " очков");
                polosa();
                continue;
            }else if (enemy.points() < 16 && enemy.toDuThis(60)){
                Karta prom = koloda.getKarta();
                enemy.addKatra(prom);
                System.out.println("Соперник взял карту " + prom.nominal + " эта карта стоит " + prom.sila + " очков");
                polosa();
                continue;
            }else if (enemy.points() < 18 && enemy.toDuThis(40)){
                Karta prom = koloda.getKarta();
                enemy.addKatra(prom);
                System.out.println("Соперник взял карту " + prom.nominal + " эта карта стоит " + prom.sila + " очков");
                polosa();
                continue;
            }else {
                System.out.println("Я думаю мне хватит " + enemy.points() + " очков, чтоб выиграть.");
                polosa();
                break;
            }
        }
        if (enemy.points() < 21 && enemy.points() > igrok.points()){
            System.out.println("Я думаю мне хватит " + enemy.points() + " очков, чтоб выиграть.");
            polosa();
        }

        if (enemy.points() == 21){
            System.out.println("У соперника " + enemy.points() + " это 21!");
            polosa();
        }
        if (enemy.points() > 21){
            System.out.println("У соперника " + enemy.points() + " это больше 21, Соперник Проиграл.");
            igrokWin = 1;
            trueGame = false;
            polosa();
        }

    }

    public void ktoVin(){
        if (trueGame){
            if (enemy.points() > igrok.points()) {
                System.out.println("У Вас " + igrok.points() + " очков. У соперника " + enemy.points() + ", \n\tВЫ ПРОИГРАЛИ.\n" );
                polosa();
                enemyWin = 1;

            }
            else {
                System.out.println("У Вас " + igrok.points() + " очков. У соперника " + enemy.points() + ", \n\tВЫ ВЫИГРАЛИ.\n" );
                polosa();
                igrokWin = 1;

            }
        }
    }

    public void polosa(){
        System.out.println("-------------------------------------------------");
    }

}

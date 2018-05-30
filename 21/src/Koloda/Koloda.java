package Koloda;

import java.util.ArrayList;
import java.util.Random;

public class Koloda
{
    ArrayList<Karta> koloda = new ArrayList();

    public void zapolnenie(){
        for (int i = 1; i <= 4; i++){
            koloda.add(new Karta("Туз", 11));
            koloda.add(new Karta("Валет", 2));
            koloda.add(new Karta("Дама", 3));
            koloda.add(new Karta("Король", 4));
            koloda.add(new Karta("2", 2));
            koloda.add(new Karta("3", 3));
            koloda.add(new Karta("4", 4));
            koloda.add(new Karta("5", 5));
            koloda.add(new Karta("6", 6));
            koloda.add(new Karta("7", 7));
            koloda.add(new Karta("8", 8));
            koloda.add(new Karta("9", 9));
            koloda.add(new Karta("10", 10));
        }
    }
    public Karta getKarta(){
        Random random = new Random();
        int mestoKarti = random.nextInt(koloda.size());
        Karta prom = koloda.get(mestoKarti);
        koloda.remove(mestoKarti);
        return prom;
    }

}

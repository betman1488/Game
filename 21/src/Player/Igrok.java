package Player;

import Koloda.Karta;

import java.util.ArrayList;

public class Igrok
{
    ArrayList<Karta> moiKarti = new ArrayList();

    public void addKatra(Karta karta){
        moiKarti.add(karta);
    }

    public int points(){
        int point = 0;
        for (Karta i : moiKarti){
            point += i.sila;
        }
        return point;
    }

    public String moiKarti(){
        String katri = "";
        for (Karta i : moiKarti){
           katri += "* " + i.nominal + " = " + i.sila + " *\t ";
        }
        return katri;
    }
}

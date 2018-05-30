package Player;


import java.util.Random;

public class Enemy extends Igrok {
    public Boolean toDuThis(int shans){
        Random random = new Random();
        if (random.nextInt(100) < shans)
            return true;
        else
            return false;
    }
}

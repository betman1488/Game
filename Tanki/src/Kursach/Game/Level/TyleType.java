package Kursach.Game.Level;

/**
 * Created by daniil on 19.12.16.
 */
public enum TyleType {

    EMPTY(0), BRICK(1), METAL(2), WATER(3), GRASS(4), ICE(5);

    private int n;

    TyleType(int n) {
        this.n = n;
    }

    public int numeric() { // число
        return n;
    }

    public static TyleType fromNumeric(int n) {
        switch (n) {
            case 1:
                return BRICK;
            case 2:
                return METAL;
            case 3:
                return WATER;
            case 4:
                return GRASS;
            case 5:
                return ICE;
                default:
                    return EMPTY;
        }
    }
}

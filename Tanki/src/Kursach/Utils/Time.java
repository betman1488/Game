package Kursach.Utils;

/**
 * Created by daniil on 16.12.16.
 */
public class Time {

    public static final long SECOND	= 1000000000l; //время в нано секундах

    public static long get(){ //вернет просто время
        return System.nanoTime();
    }
}

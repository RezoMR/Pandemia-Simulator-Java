package sk.uniza.fri.pomocneTriedy;

import java.util.Random;
/**
 * 20. 5. 2021 - 2:45
 *
 * @author Matúš Remeň
 * Trieda slúži na vracanie random čísiel
 *
 */
public class Nahodne {



    public static int od1do100() {
        Random r = new Random();
        return r.nextInt(100 + 1 - 1) + 1;

    }

    public static int od1do2() {
        Random r = new Random();
        return r.nextInt(2 + 1 - 1) + 1;

    }
    public static int od1do1000() {
        Random r = new Random();
        return r.nextInt(1000 + 1 - 1) + 1;
    }

}




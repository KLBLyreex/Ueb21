package Aufgabe1;

import java.util.Random;

public class Producer {

    private Random rnd = new Random();

    public int zufallsZahl(){
        return rnd.nextInt(1001);
    }
}

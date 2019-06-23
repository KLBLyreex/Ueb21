package Aufgabe1;

import java.util.Random;

/**
 * @author Aaron Betzholz / Jan Ehrhardt
 * @version 23.06.2019
 *
 * Producer Klasse, erzeugt eine zufaellige Zahl
 */
public class Producer {

    private Random rnd = new Random();

    /**
     * Gibt eine Zufaellige Zahl zurueck (Zwischen 0 und 1000)
     * @return zufaellige Zahl
     */
    public int zufallsZahl(){
        return rnd.nextInt(1001);
    }
}

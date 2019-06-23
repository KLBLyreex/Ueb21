package Aufgabe1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Aaron Betzholz / Jan Ehrhardt
 * @version 23.06.2019
 *
 * Consumer Klasse welche die Quersumme von Zahlen zu einer Schlange hinzufuegt
 */
public class Consumer {

    private TreeMap<Integer, LinkedList<Long>> zaehlerBaum = new TreeMap<>();

    /**
     * Fuegt eine Zahl der liste hinzu
     * @param i die Zahl welche hinzugefuegt werden soll
     */
    public void consume(int i){
        int result = crossTotal(i);

        long zeitStempel = System.currentTimeMillis();
        if(zaehlerBaum.get(result) == null){
            LinkedList<Long> linkedList = new LinkedList<>();
            linkedList.add(zeitStempel);
            zaehlerBaum.put(result, linkedList);
        } else {
            zaehlerBaum.get(result).add(zeitStempel);
        }
    }

    /**
     * Anzahl der verschiedenen Ergebnisse
     * @return wie viele unterschiedliche Ergebnisse es gibt
     */
    public int numberOfDifferentResults() {
        return this.zaehlerBaum.keySet().size();
    }


    /**
     * Zaehlt wie oft die Zahl i vorkommt
     * @param i die gesuchte Zahl
     * @return Anzahl der Vorkommnisse
     */
    public int numberOfOccurrences(int i) {
        if (this.zaehlerBaum.containsKey(i)) {
            return this.zaehlerBaum.get(i).size();
        }
        return 0;
    }


    /**
     * Liefert die Quersumme aufsteigend
     * @return quersumme
     */
    public Set<Integer> getCrossTotalsAscending() {
        return this.zaehlerBaum.keySet();
    }

    /**
     * Liefert die Quersumme absteigend
     * @return quersumme
     */
    public Set<Integer> getCrossTotalsDescending() {
        return this.zaehlerBaum.descendingKeySet();
    }

    /**
     * Liefert einen Zeitstempel fuer das Ergebnis
     * @param i der gesuchte Wert
     * @return einen Zeitstempel
     */
    public Deque<Long> getTimestampsForResult(int i) {
        return this.zaehlerBaum.get(i);
    }

    /**
     * Quersummen berechnung
     * @param i die uebergeben Zahl fuer die Quersumme
     * @return die quersumme
     */
    private int crossTotal(int i){
        int result = 0;

        while(0 != i){
            result += i % 10;
            i = i / 10;
        }
        return result;
    }
}

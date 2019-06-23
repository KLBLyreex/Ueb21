package Aufgabe1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

public class Consumer {

    private TreeMap<Integer, LinkedList<Long>> zaehlerBaum = new TreeMap<>();

    public void consume(int i){
        int result = quersumme(i);

        long zeitStempel = System.currentTimeMillis();
        if(zaehlerBaum.get(result) == null){
            LinkedList<Long> linkedList = new LinkedList<>();
            linkedList.add(zeitStempel);
            zaehlerBaum.put(result, linkedList);
        } else {
            zaehlerBaum.get(result).add(zeitStempel);
        }
    }

    private int quersumme(int i){
        int result = 0;

        while(0 != i){
            result += i % 10;
            i = i / 10;
        }
        return result;
    }

    public int anzahlUnterschiedlicheErgebnisse() {
        return this.zaehlerBaum.keySet().size();
    }


    public int anzahlVorkommnisse(int i) {
        if (this.zaehlerBaum.containsKey(i)) {
            return this.zaehlerBaum.get(i).size();
        }
        return 0;
    }


    public Set<Integer> getQuersummeAufsteigend() {
        return this.zaehlerBaum.keySet();
    }


    public Set<Integer> getQuersummeAbsteigend() {
        return this.zaehlerBaum.descendingKeySet();
    }


    public Deque<Long> getZeitStempel(int i) {
        return this.zaehlerBaum.get(i);
    }
}

package Aufgabe1;

import java.util.*;

/**
 * @author Aaron Betzholz / Jan Ehrhardt
 * @version 23.06.2019
 *
 * Dialog-Test, welche alle Implementierten Methoden von Consumer testet
 */
public class Dialog {

    private static final String FEHLER_FALSCHER_PARAMETER = "Gib ein ob du FIFO oder NORMAL machen moechtest.";

    private Queue<Integer> schlange;

    private Consumer consumer = new Consumer();
    private Producer producer = new Producer();

    public static void main(String[] args){
        new Dialog().run(args);
    }

    /**
     * Entscheidet wie die weitere Verarbeitung statt finden soll ueber den mitgegebenen Parameter
     * @param args start Parameter
     */
    public void run(String[] args){
        if(args.length == 0){
            throw new IllegalArgumentException(FEHLER_FALSCHER_PARAMETER);
        }
        if(args[0].equalsIgnoreCase("FIFO")){
            schlange = new ArrayDeque<>();
        } else if(args[0].equalsIgnoreCase("NORMAL")){
            schlange = new PriorityQueue<>();
        } else {
            throw new IllegalArgumentException(FEHLER_FALSCHER_PARAMETER);
        }
        testAusgabe();
    }

    /**
     * Testet in einem Dialog die implementierten Methoden
     */
    private void testAusgabe(){
        int anzahl = 25;
        System.out.println("Es werden " + anzahl + " Zahlen der Schlange hinzugefuegt");
        zahlenHinzufuegen(anzahl);
        System.out.println("Anzahl der Zahlen, welche NICHT im Consumer sind: " + schlange.size());
        System.out.println("Folgende Zahlen sind NICHT im Consumer: ");
        ausgabeSchlange();
        System.out.println("Verschiedene Quersummen im Consumer: " + consumer.numberOfDifferentResults());
        System.out.println("Quersummen im Consumer (Aufsteigend): ");
        ausgabeQuersummeAufsteigend();
        System.out.println("Quersummen in Consumer (Absteigend): ");
        ausgabeQuersummeAbsteigend();
        System.out.println("Quersumme mit Zeitstempel (Aufsteigend): ");
        quersummeZeitstempelAufsteigend();
        System.out.println("Quersumme mit Zeitstempel (Absteigend): ");
        quersummeZeitstempelAbsteigend();
    }

    /**
     * Testet den Zeitstempel der Consumer Klasse
     * Gibt von der Consumer Klasse die Quersummen Aufsteigend mit Zeitstempel aus
     */
    private void quersummeZeitstempelAufsteigend(){
        for(Integer i : consumer.getCrossTotalsAscending()){
            System.out.print(i + ": " + consumer.getTimestampsForResult(i) + ", ");
        }
        System.out.print("\n");
    }

    /**
     * Testet den Zeitstempel der Consumer Klasse
     * Gibt von der Consumer Klasse die Quersummen Absteigend mit Zeitstempel aus
     */
    private void quersummeZeitstempelAbsteigend(){
        for(Integer i : consumer.getCrossTotalsDescending()){
            System.out.print(i + ": " + consumer.getTimestampsForResult(i) + ", ");
        }
        System.out.print("\n");
    }

    /**
     * Gibt den Inhalt der Zahlen in der Schlange aus, welche NICHT
     * in die Consumer Klasse gelegt wurden
     */
    private void ausgabeSchlange(){
        for(Integer i : schlange){
            System.out.print(i + ", ");
        }
        System.out.print("\n");
    }

    /**
     * Gibt die Quersummen der Consumer Klasse absteigend aus
     */
    private void ausgabeQuersummeAbsteigend(){
        for(Integer i : consumer.getCrossTotalsDescending()){
            System.out.print(i + ", ");
        }
        System.out.print("\n");
    }

    /**
     * Gibt die Quersummen der Consumer Klasse Aufsteigend aus
     */
    private void ausgabeQuersummeAufsteigend(){
        for(Integer i : consumer.getCrossTotalsAscending()){
            System.out.print(i + ", ");
        }
        System.out.print("\n");
    }

    /**
     * Fuegt der Liste die zufaellig generierte Zahl hinzu
     * @param anzahl Anzahl der Durchlaeufe
     */
    private void zahlenHinzufuegen(int anzahl){
        Random rnd = new Random();
        for(int i = 0; i < anzahl; i++){
            int y = rnd.nextInt(3);
            if(y > 0){
                schlange.add(producer.produce());
            } else {
                if(schlange.size() == 0){
                    schlange.add(producer.produce());
                }
                consumer.consume(schlange.remove());
            }
        }
    }
}

package Aufgabe1;

import java.util.Scanner;

public class Dialog {

    private int MENU_BEENDEN = 0;


    private Scanner input = new Scanner(System.in);
    private int eingabe = -1;

    private Consumer consumer = new Consumer();
    private Producer producer = new Producer();

    //TODO: Aufgabe 1A
    public static void main(String[] args){
        new Dialog().run();
    }

    public void run(){
        while(eingabe != 0){

        }
    }

    private void menuAusgabe(){
        System.out.println("##########");
        System.out.println("0 = Menu Beenden");
        System.out.println("1 = ");
    }
}

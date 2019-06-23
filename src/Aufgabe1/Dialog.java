package Aufgabe1;

import java.util.Scanner;

public class Dialog {

    private int MENU_BEENDEN = 0;


    private Scanner input = new Scanner(System.in);

    private Consumer consumer = new Consumer();
    private Producer producer = new Producer();

    public static void main(String[] args){
        new Dialog().run();
    }

    public void run(){

    }
}

package Aufgabe1;

public class Main {

    Consumer consumer = new Consumer();

    public static void main(String[] args){
        new Main().run();
    }

    public void run(){
        consumer.consume(100);
        consumer.consume(100);
        consumer.consume(200);
        consumer.consume(300);
        System.out.println(consumer.getTimestampsForResult(2));
    }
}

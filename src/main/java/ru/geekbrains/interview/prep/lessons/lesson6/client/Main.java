package ru.geekbrains.interview.prep.lessons.lesson6.client;


import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        CountDownLatch connectCheck = new CountDownLatch(1);
        Network net = Network.getInstance();
        try {
            net.connect(connectCheck);
            connectCheck.await();

            System.out.println("Вызываем метод GET");
            net.sendGET();
            Thread.sleep(1000);

            System.out.println("Вызываем метод POST");
            net.sendPOST();

        } catch (InterruptedException e) {
            e.printStackTrace();
            net.disconnect();
        }
    }
}

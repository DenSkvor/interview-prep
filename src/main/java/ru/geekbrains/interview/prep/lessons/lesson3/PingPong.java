package ru.geekbrains.interview.prep.lessons.lesson3;

public class PingPong {
    private static final String PING = "ping";
    private static final String PONG = "pong";

    private volatile String action = PING;

    public void play(int count){
        new Thread(() -> {
            for (int i = 0; i < count; i++) ping();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) pong();
        }).start();
    }

    private synchronized void ping(){
        while (!action.equals(PING)){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(action);
        action = PONG;
        notify();
    }

    private synchronized void pong(){
        while (!action.equals(PONG)){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(action);
        action = PING;
        notify();
    }
}

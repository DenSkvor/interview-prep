package ru.geekbrains.interview.prep.lessons.lesson3;


public class Main {


    public static void main(String[] args) {
        doTask1();

        doTask2();
    }

    private static void doTask1() {
        new PingPong().play(5);
    }

    private static void doTask2() {
        Counter counter = new Counter(3);

        for (int i = 0; i < 3; i++) {
            int n = i + 1;
            new Thread(() -> {
                try {
                    Thread.sleep(1000 * (int) (Math.random() * 3));
                    System.out.println("Поток " + n + " запустился.");

                    counter.increment();

                    System.out.println("Поток " + n + " выполняет что-то важное.");
                    Thread.sleep(1000 * (int) (Math.random() * 5));
                    System.out.println("Поток " + n + " завершил выполнение.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        counter.waitAll();
        System.out.println("Все потоки запущены.");
    }


}

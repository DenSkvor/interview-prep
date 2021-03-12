package ru.geekbrains.interview.prep.lessons.lesson3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private volatile int currentCount;
    private final int thresholdCount;

    private final Lock lock;

    public Counter(int count){
        thresholdCount = count;
        this.lock = new ReentrantLock();
    }

    public void increment(){
        try{
            lock.lock();
            currentCount++;
        }
        finally {
            lock.unlock();
        }
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void waitAll(){
        while (getCurrentCount() < thresholdCount){}
    }

}

package com.infosupport.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadLockingDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter sharedCounter = new Counter(0);
        AtomicInteger counter = new AtomicInteger(0);

        Thread t1 = new Thread(() -> increment(sharedCounter, 100_000));
        Thread t2 = new Thread(() -> increment(sharedCounter, 100_000));

        System.out.println("Starting ThreadLockingDemo");

        long start = System.nanoTime();

        t1.start();
        t2.start();

        t1.join(); // join t1 met de main thread
        t2.join(); // join t2 met de main thread

        long stop = System.nanoTime();

        System.out.println(sharedCounter.getValue());
        System.out.println("Took " + (stop - start) / 1000 + " µs.");
    }

    private static void increment(Counter c, int n) {
        for (int i = 0; i < n; i++) {
            c.incrementValue();
        }
    }

    private static void increment(AtomicInteger c, int n) {
        for (int i = 0; i < n; i++) {
            c.incrementAndGet();
        }
    }

    private static class Counter {
        ReentrantReadWriteLock plasketting = new ReentrantReadWriteLock();

        private int value;

        public Counter(int i) { this.value = i; }

        public void incrementValue() {
            plasketting.writeLock().lock();
            int oldValue = this.value;
            Thread.yield();
            this.value = oldValue + 1;
            plasketting.writeLock().unlock();
        }

        public int getValue() {
            plasketting.readLock().lock();
            int val = value;
            plasketting.readLock().unlock();

            return val;
        }
    }
}

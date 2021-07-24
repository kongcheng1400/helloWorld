package com.concur.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitLockConditionDemo extends Thread {
    private volatile boolean fire = false;
    private Lock lock = new ReentrantLock();
    private Condition condition= lock.newCondition();
    @Override
    public void run() {
        lock.lock();
        try {
            while (!fire) {
                System.out.println("awaiting fire!");
                condition.await();
            }

            System.out.println("got fire!");
        } catch (InterruptedException e) {
            Thread.interrupted();
        }

    }

    public void fire() {
        lock.lock();
        try {
            this.fire = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ExplicitLockConditionDemo wt = new ExplicitLockConditionDemo();
        wt.start();
        Thread.sleep(1000);
        System.out.println("fire");
        wt.fire();
    }



}

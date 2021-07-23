package com.executor.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExeDemo {
    static class LongRunningTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("long running finished");
        }
    }

    static class FixedDelayTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(10);
        timer.schedule(new LongRunningTask(), 10, TimeUnit.MILLISECONDS);
        timer.scheduleWithFixedDelay(new FixedDelayTask(), 10, 1000, TimeUnit.MILLISECONDS);
        System.out.println("wait 20S to see...");
        Thread.sleep(20000);
        timer.shutdown();
    }
}

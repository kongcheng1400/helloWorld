package com.executor.demo;

import java.util.Timer;
import java.util.TimerTask;

public class BasicTimer {
    static class DelayTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("delayed task");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new DelayTask(), 1000, 300);
        System.out.println("time task is running now");
        Thread.sleep(5000);
        timer.cancel();
    }
}

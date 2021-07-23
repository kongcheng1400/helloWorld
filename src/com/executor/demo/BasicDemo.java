package com.executor.demo;

import java.util.Random;
import java.util.concurrent.*;

public class BasicDemo {
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            var sleepSeconds1 = new Random().nextInt(1000);
            Thread.sleep(sleepSeconds1);
            return sleepSeconds1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new Task());
        //模拟执行其他任务
        Thread.sleep(100);
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}

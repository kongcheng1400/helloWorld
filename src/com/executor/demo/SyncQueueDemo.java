package com.executor.demo;

import java.util.concurrent.*;

public class SyncQueueDemo {
     static class ThreadTask implements Runnable {
        public ThreadTask() {

        }
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }


    private static ExecutorService pool;
    public static void main(String[] args) {
        pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 3; i++) {
            pool.execute(new ThreadTask());
        }
    }
}

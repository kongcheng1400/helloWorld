package com.harry.theadDemo;


public class LatchDemo{
    static class Worker extends Thread{
        MyLatch latch;
        public Worker(MyLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep((int)(Math.random()));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



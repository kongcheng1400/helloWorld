package com.harry.theadDemo;

public class WaitThread extends Thread{
    private volatile boolean fire = false;
    @Override
    public void run() {
        try {
            synchronized (this) {
                while (!fire) {
                    System.out.println("Worker is waiting!");
                    wait();
                    System.out.println("Worker received fire from main!");
                }
            }
            System.out.println("work thread fired!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void fire() {
        this.fire = true;
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
        WaitThread wth = new WaitThread();
        wth.start();
        System.out.println("worker thread state is " + wth.getState());
        Thread.sleep(1000);
        System.out.println("worker thread state is " + wth.getState());
        System.out.println("fire from main!");
        wth.fire();
        System.out.println("worker thread state is " + wth.getState());
    }
}

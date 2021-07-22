package com.harry.theadDemo;

public class HelloRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello, Runnable!");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread run = new Thread(new HelloRunnable());
        System.out.println("beginning: " + run.getState());
        run.start();
        System.out.println("in: " + run.getState());
        run.join();
        System.out.println("after: " + run.getState());
    }


}

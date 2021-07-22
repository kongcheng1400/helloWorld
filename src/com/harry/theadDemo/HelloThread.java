package com.harry.theadDemo;

public class HelloThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        System.out.println("hello!");
    }

    public static void main(String[] args){
        Thread thd = new HelloThread();
        thd.start();
    }

}

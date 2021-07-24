package com.harry.theadDemo;

public class Counter {
    private int count;
    public synchronized void incr() {
        count++;
    }
    public synchronized int getCount() {
        return count;
    }
    @Override
    public String toString()
    {
        return String.valueOf(count);
    }
}

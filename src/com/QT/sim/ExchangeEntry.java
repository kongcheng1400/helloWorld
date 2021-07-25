package com.QT.sim;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExchangeEntry {
    private String exName;
    private Lock lock = new ReentrantLock();
    private Condition condition= lock.newCondition();

    public ExchangeEntry(String name) {
        exName = name;
    }

    public void getPrice()
    {
        lock.lock();
        try {
            System.out.println(exName + " get price.");
        } finally {
            lock.unlock();
        }
    }

    public void getMarginLevel()
    {
        lock.lock();
        try {
            System.out.println(exName + " get margin Level!");
        } finally {
            lock.unlock();
        }
    }

    public void trade()
    {
        lock.lock();
        try {
            System.out.println(exName + "Trade!");
        } finally {
            lock.unlock();
        }
    }

    public void getOrders()
    {
        lock.lock();
        try {
            System.out.println(exName + "get old orders!");
        } finally {
            lock.unlock();
        }
    }
}

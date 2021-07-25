package com.QT.sim;

public class TaskCleanOldOrder implements Runnable{
    private ExchangeEntry ex;

    public TaskCleanOldOrder(ExchangeEntry ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        ex.getOrders();
        ex.trade();
    }

}

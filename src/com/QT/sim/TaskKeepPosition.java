package com.QT.sim;
public class TaskKeepPosition implements Runnable{
    private ExchangeEntry ex;
    public TaskKeepPosition(ExchangeEntry ex) {
        this.ex = ex;
    }
    @Override
    public void run() {
        ex.getMarginLevel();
        ex.trade();
    }
}

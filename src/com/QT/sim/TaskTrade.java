package com.QT.sim;

public class TaskTrade implements Runnable {
    private ExchangeEntry exEn;

    public TaskTrade(ExchangeEntry exEn) {
        this.exEn = exEn;
    }
    @Override
    public void run()
    {
        exEn.getPrice();
        System.out.println("Update oderbook!");
        System.out.println("Update Trades amount!");
        exEn.trade();
    }

}

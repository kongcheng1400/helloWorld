package com.QT.sim;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BinanceSim {
    public static void  main(String[] args)
    {
        String exName = "MyBinance";
        int scanOrderInterval = 1000;
        int tradeInterval = 300;
        int keepPositionInterval = 2000;

        ExchangeEntry exen = new ExchangeEntry("QT simulation with Binance: ");

        ScheduledExecutorService timer = new ScheduledThreadPoolExecutor(10);
        timer.scheduleWithFixedDelay(new TaskTrade(exen), 10, tradeInterval, TimeUnit.MILLISECONDS);
        timer.scheduleWithFixedDelay(new TaskCleanOldOrder(exen), 5000, scanOrderInterval, TimeUnit.MILLISECONDS);
        timer.scheduleWithFixedDelay(new TaskKeepPosition(exen), 8000, keepPositionInterval, TimeUnit.MILLISECONDS);

    }
}

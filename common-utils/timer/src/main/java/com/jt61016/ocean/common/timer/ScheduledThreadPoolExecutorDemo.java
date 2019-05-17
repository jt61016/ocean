package com.jt61016.ocean.common.timer;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangtao
 * @date 2019/1/28 下午8:16.
 */
public class ScheduledThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(8);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello, now is " + new Date());
            }
        },
        0, 1, TimeUnit.SECONDS);
    }



}

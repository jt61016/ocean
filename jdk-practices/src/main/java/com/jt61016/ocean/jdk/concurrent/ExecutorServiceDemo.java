package com.jt61016.ocean.jdk.concurrent;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jiangtao
 * @date 2019/3/11 下午5:37.
 */
public class ExecutorServiceDemo {
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        /*Long time0 = System.currentTimeMillis();
        System.out.println("任务开始");
        //backTask();
        frontTask();
        System.out.println("任务结束");
        System.out.println(System.currentTimeMillis() - time0);*/
        Date time = new Date();
        System.out.println(time.getTime());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(time));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(getEndOfDay(time)));

    }
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime() - 500), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        Date d1 = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("===" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(d1));
        Date d2 = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant().truncatedTo(ChronoUnit.SECONDS));
        System.out.println("===" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(d2));
        return d2;
    }


    private static void backTask() {
        executor.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("后端任务 " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executor.shutdown();
    }

    private static void frontTask() {
        for (int i = 0; i < 5; i++) {
            System.out.println("任务 " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

package com.jt61016.ocean.jdk.utils.timer;

import java.util.Date;

/**
 * @author jiangtao
 * @date 2019/1/25 下午3:26.
 */
public class MyTimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer("test");
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("just 4 test, now is " + new Date());
            }
        };
        System.out.println("now is " + new Date());
        timer.schedule(timerTask, 3000, 2000);
    }
}

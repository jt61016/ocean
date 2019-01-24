package com.jt61016.ocean.common.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * JDK原生Timer&TimerTask
 *
 * @author jiangtao
 * @date 2019/1/24 下午1:48.
 */
public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // delay in milliseconds before task is to be executed.
        long delay = 3000;
        // period time in milliseconds between successive task executions.
        long period = 1000;
        System.out.println("now is " + new Date());
        timer.schedule(new MyTask("t1"), 10000);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.schedule(new MyTask("t2"), 2000);
    }

}

class MyTask extends TimerTask {

    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " : now is " + new Date());
    }
}

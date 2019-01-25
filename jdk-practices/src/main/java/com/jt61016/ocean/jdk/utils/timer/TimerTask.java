package com.jt61016.ocean.jdk.utils.timer;

/**
 * 定时任务
 *
 * @author jiangtao
 * @date 2019/1/25 下午12:57.
 */
public abstract class TimerTask implements Runnable {
    long nextExecutionTime;

    long period = 0;

    /**
     * 定时任务的具体执行内容
     */
    @Override
    public abstract void run();
}

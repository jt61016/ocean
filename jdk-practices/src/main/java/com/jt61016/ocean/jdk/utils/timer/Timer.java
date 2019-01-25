package com.jt61016.ocean.jdk.utils.timer;

/**
 * 定时器
 *
 * @author jiangtao
 * @date 2019/1/25 下午12:56.
 */
public class Timer {
    TaskQueue queue = new TaskQueue();

    Thread timerThread = new TimerThread(queue);

    public Timer() {
        timerThread.setName("myTimer");
        timerThread.start();
    }

    public Timer(String name) {
        timerThread.setName(name);
        timerThread.start();
    }

    public void schedule(TimerTask task, long delay, long period) {
        if (delay <= 0 || period < 0) {
            throw new IllegalArgumentException("argument error");
        }
        sched(task, delay, period);
    }

    private void sched(TimerTask task, long delay, long period) {
        task.nextExecutionTime = System.currentTimeMillis() + delay;
        task.period = period;
        synchronized(queue) {
            queue.add(task);
            if (task == queue.getMin()) {
                queue.notify();
            }
        }
    }
}

/**
 * 定时器执行线程
 */
class TimerThread extends Thread {
    TaskQueue queue;

    public TimerThread(TaskQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized(queue) {
                    if (queue.isEmpty()) {
                        queue.wait();
                    }

                    TimerTask task = queue.getMin();
                    long currentTime = System.currentTimeMillis();
                    long executioneTime = task.nextExecutionTime;
                    boolean timeReached = currentTime >= executioneTime;
                    if (timeReached) {
                        if (task.period == 0) {
                            queue.removeMin();
                        } else {
                            queue.rescheduleMin(task.nextExecutionTime + task.period);
                        }
                        task.run();
                    } else {
                        queue.wait(executioneTime - currentTime);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queue.clear();
        }
    }
}

/**
 * 任务容器,最小堆
 */
class TaskQueue {
    private static final int MAX_SIZE = 64;

    TimerTask[] queue = new TimerTask[MAX_SIZE];
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     * @param e 待添加元素
     */
    public void add(TimerTask e) {
        if (MAX_SIZE <= size) {
            throw new RuntimeException("overflow");
        }
        queue[size] = e;
        size++;
        shiftUp(size - 1);
    }

    /**
     * 移除最小(即堆顶)元素
     *
     * @return 最小元素值
     */
    public TimerTask removeMin() {
        TimerTask min = queue[0];
        queue[0] = queue[--size];
        shiftDown(0);
        return min;
    }

    /**
     * 获取(即堆顶)最小元素
     *
     * @return 最小元素值
     */
    public TimerTask getMin() {
        return queue[0];
    }

    public void rescheduleMin(long newNextExecutionTime) {
        queue[0].nextExecutionTime = newNextExecutionTime;
        shiftDown(0);
    }

    /**
     * 清空堆
     */
    public void clear() {
        for (int i = 0; i < queue.length; i++) {
            queue[i] = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(queue[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * 元素k向上调整,维持最小堆
     *
     * @param k 需要调整的元素位置
     */
    private void shiftUp(int k) {
        while(k > 0) {
            int parentIndex = parentIndex(k);
            if (queue[parentIndex].nextExecutionTime <= queue[k].nextExecutionTime) {
                break;
            }
            swap(parentIndex, k);
            k = parentIndex;
        }
    }

    /**
     * 元素k向下调整,维持最小堆
     *
     * @param k 需要调整的元素位置
     */
    private void shiftDown(int k) {
        while (leftKidIndex(k) < size) {
            int smallerKidIndex = leftKidIndex(k);
            if (rightKidIndex(k) <= size
                    && queue[smallerKidIndex].nextExecutionTime > queue[rightKidIndex(k)].nextExecutionTime) {
                smallerKidIndex = rightKidIndex(k);
            }
            if (queue[smallerKidIndex].nextExecutionTime < queue[k].nextExecutionTime) {
                swap(smallerKidIndex, k);
            }
            k = smallerKidIndex;
        }
    }

    private int parentIndex(int i) {
        return (i + 1 >> 1) - 1;
    }

    private int leftKidIndex(int i) {
        return (i << 1) + 1;
    }

    private int rightKidIndex(int i) {
        return (i << 1) + 2;
    }

    private void swap(int i, int j) {
        if (i >= size || j >= size) {
            throw new RuntimeException("overflow");
        }
        TimerTask tmp = queue[i];
        queue[i] = queue[j];
        queue[j] = tmp;
    }
}

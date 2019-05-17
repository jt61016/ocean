package com.jt61016.ocean.jvm.concurrence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiangtao
 * @date 2018/12/14 下午8:51.
 */
public class AtomicTest {
    public static AtomicInteger race = new AtomicInteger(0);

    public static void increase() {
        race.incrementAndGet();
    }

    public static void main(String[] args) {
        List<Long> l1 = new ArrayList<>();
        l1.add(1L);
        l1.add(2L);
        l1.add(3L);

        /*List<Long> l2 = new ArrayList<>();
        l2.add(1L);
        l2.add(2L);
        l2.add(3L);*/
        List<Long> l2 = Arrays.asList(2L, 3L);

        if (l1.containsAll(l2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        if (l2.containsAll(l1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        l1.retainAll(l2);
    }
}

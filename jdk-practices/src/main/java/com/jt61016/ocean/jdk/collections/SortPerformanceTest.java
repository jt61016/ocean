package com.jt61016.ocean.jdk.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangtao
 * @date 2018/12/26 下午3:53.
 */
public class SortPerformanceTest {
    public static void main(String[] args) {
        List<Element> elements1 = Element.buildElementList(1000000L);
        List<Element> elements2 = new ArrayList<>(elements1);

        Long time1 = System.currentTimeMillis();
        sortByJDK(elements1);
        Long time2 = System.currentTimeMillis();
        System.out.println("------------sorted : " + (time2 - time1));


        Long time3 = System.currentTimeMillis();
        noSort(elements2);
        Long time4 = System.currentTimeMillis();
        System.out.println("------------noSort : " + (time4 - time3));
    }

    private static void sortByJDK(List<Element> elements) {
        elements.sort((e1, e2) -> e1.getVal().compareTo(e2.getVal()));
    }

    private static void noSort(List<Element> elements) {
        Map<Integer, Element> map = new HashMap<>(1000000);
        for (Element e : elements) {
            if (map.containsKey(e.getKey())) {
                if (e.getVal() > map.get(e.getKey()).getVal()) {
                    map.put(e.getKey(), e);
                }
            } else {
                map.put(e.getKey(), e);
            }
        }
    }
}

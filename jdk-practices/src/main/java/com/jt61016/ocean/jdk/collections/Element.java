package com.jt61016.ocean.jdk.collections;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author jiangtao
 * @date 2018/12/26 下午3:56.
 */
@Data
@NoArgsConstructor
public class Element implements Serializable, Cloneable {
    private static final long serialVersionUID = 699357274379486161L;

    private Integer key;
    private Integer val;

    public Element(Integer key, Integer val) {
        this.key = key;
        this.val = val;
    }

    public static List<Element> buildElementList(Long size) {
        List<Element> elements = new ArrayList<>();
        if (size <= 0) {
            return elements;
        }
        Random random = new Random();
        while (size-- >0) {
            Element e = new Element(random.nextInt(1000), random.nextInt());
            elements.add(e);
        }
        return elements;
    }
}

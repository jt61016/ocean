package com.jt61016.ocean.spring.springinaction.ch02.xmlconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jiangtao
 * @date 2019/7/22 下午10:46.
 */
public class XmlConfigTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/spring/ch2xmlconfig.xml");

        CompactDisc cd = context.getBean(CompactDisc.class);

        System.out.println(cd);
    }
}

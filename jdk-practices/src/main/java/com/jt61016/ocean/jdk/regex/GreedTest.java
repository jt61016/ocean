package com.jt61016.ocean.jdk.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 贪婪 和 非贪婪 模式
 *
 * @author jiangtao
 * @date 2018/11/12 下午4:26.
 */
public class GreedTest {
    static final String source = "xx<H1>Chapter1 - regular expression</H1>ww";
    /**
     * 贪婪模式,尽量多匹配: * 和 + 通配符属于贪婪模式
     */
    static final String greedPattern = "<.*>";
    /**
     * 非贪婪模式,尽量少匹配
     */
    static final String nonGreedPattern = "<.*?>";

    public static void main(String[] args) {
        GreedTest test = new GreedTest();
        test.regex(source, greedPattern);
        System.out.println("--------");
        test.regex(source, nonGreedPattern);
    }

    private void regex(String source, String patternStr) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            System.out.println(matcher.replaceAll("XX"));
        }

    }
}

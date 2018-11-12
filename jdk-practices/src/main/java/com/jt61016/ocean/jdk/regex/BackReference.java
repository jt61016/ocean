package com.jt61016.ocean.jdk.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 反向引用
 *
 * @author jiangtao
 * @date 2018/11/12 下午8:38.
 */
public class BackReference {
    public static void main(String[] args) {
        BackReference bf = new BackReference();
        //bf.duplicatedWord();
        bf.processURL();
    }

    private void duplicatedWord() {
        String source = "Is is the the cost of of of gasoline going up upp";
        String patternStr = "\\b([a-z]+) \\1\\b";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(source);
        System.out.println(matcher.replaceAll("XX"));
    }

    private void processURL() {
        String url = "http://www.runoob.com:80/html/html-tutorial.html";
        String patternStr = "(\\w+):\\/\\/([^/:]+)(:\\d*)?([^# ]*)";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(url);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

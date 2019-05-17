package com.jt61016.ocean.jdk.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author jiangtao
 * @date 2018/11/6 上午11:36.
 */
public class FileTest {
    public static void main(String[] args) {

        writeFile();
    }
    private static void writeFile() {
        String filePath = "/opt/zcy/modules/inquiryCenter/";
        //String filePath = "/tmp/jiangtao/test/";
        String filename = "fileTest.txt";
        String fullName = filePath + filename;

        File myFilePath = new File(fullName);
        try {
            if (!myFilePath.getParentFile().exists()) {
                myFilePath.getParentFile().mkdirs();
            }

            if (!myFilePath.getParentFile().exists()) {
                System.out.println("文件夹创建失败");
                return;
            }

            if (!myFilePath.exists()) {
                myFilePath.createNewFile();
            }
            //FileWriter resultFile = new FileWriter(myFilePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFilePath));
            PrintWriter myFile = new PrintWriter(writer);
            myFile.println(filePath);
            myFile.println("随便写点啥bijiaohao呢");
            myFile.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("新建文件操作出错");
            e.printStackTrace();
        }

    }
}

package com.kongzhu.demo.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 本示例在HelloWorld3的基础上添加自带缓冲区的字符输入流读取TXT文本文件
 * @author caiwenlong
 */
public class HelloWorld5 {

    /**
     * Java程序主入口：Main方法
     * 该方法整体结构不能变更：public static void main(String[] args)
     * @param args
     */
    public static void main(String[] args) {
        // 声明一个变量，
        // 变量类型是java.lang.String，变量名是s，
        // 变量的值是静态方法getMessage的返回值
        String s = getMessage();
        // 控制台Console打印变量s的值，然后换行
        System.out.println(s);
    }

    /**
     * 声明一个静态方法，该方法返回字符串"Hello World"
     * @return
     */
    public static String getMessage() {
        // 声明一个变量，变量类型是自带缓冲区的字符输入流BufferedReader
        BufferedReader reader = null;
        try {
            // 创建自带缓冲区的字符输入流（缓冲区默认大小为8192个字符）
            reader = new BufferedReader(new FileReader("src/com/kongzhu/demo/base/message.txt"));
            // 按行读取文本，并将文本返回给方法调用者
            return reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭物理资源（必须执行）
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {}
                reader = null;
            }
        }
        // 读取文件失败时，返回提示信息
        return "读取文件失败";
    }
}

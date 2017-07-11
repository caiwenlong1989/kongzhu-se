package com.kongzhu.demo.base;

import java.io.FileReader;
import java.util.Properties;

/**
 * 本示例在HelloWorld3的基础上添加Properties读取Java属性文件
 * @author caiwenlong
 */
public class HelloWorld6 {

    /**
     * Java程序主入口：Main方法
     * 该方法整体结构不能变更：public static void main(String[] args)
     * @param args
     */
    public static void main(String[] args) {
        // 声明一个变量，
        // 变量类型是java.lang.String，变量名是s，
        // 变量的值是Another类中静态方法getMessage的返回值
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
        Properties properties = null;
        try {
            // 创建无默认值的空属性列表
            properties = new Properties();
            // 使用简单的面向行格式从字符输入流中读取属性列表（键和元素对）
            properties.load(new FileReader("src/com/kongzhu/demo/base/message.properties"));
            // 在该属性列表中搜索具有指定键的属性，并将搜索结果返回给方法调用者
            return properties.getProperty("text");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 读取文件失败时，返回提示信息
        return "读取文件失败";
    }
}

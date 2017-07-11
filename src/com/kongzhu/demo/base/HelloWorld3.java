package com.kongzhu.demo.base;

/**
 * 本示例在HelloWorld2的基础上添加静态方法
 * @author caiwenlong
 */
public class HelloWorld3 {

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
        // 返回字符串"Hello World"给方法调用者
        return "Hello World";
    }
}

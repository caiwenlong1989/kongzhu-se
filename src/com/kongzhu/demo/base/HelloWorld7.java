package com.kongzhu.demo.base;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 本示例在HelloWorld3的基础上添加Document读取XML配置文件
 * @author caiwenlong
 */
public class HelloWorld7 {

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
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src/com/kongzhu/demo/base/message.xml");
            // 根据标签名称获取节点集合
            NodeList nodeList = document.getElementsByTagName("text");
            // 获取第一个节点
            Node node = nodeList.item(0);
            // 判断节点是否为元素
            if (node instanceof Element) {
                // 将节点强转为元素
                Element element = (Element) node;
                // 获取该节点的文本内容，并返回给方法调用者
                return element.getTextContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 读取文件失败时，返回提示信息
        return "读取文件失败";
    }
}

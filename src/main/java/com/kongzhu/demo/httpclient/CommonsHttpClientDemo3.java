package com.kongzhu.demo.httpclient;

import java.io.File;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;

public class CommonsHttpClientDemo3 {

    public static void main(String[] args) {
        // 请求地址
        String uri = "http://f.apiplus.net/cqssc-10.json";
        // 创建HTTP客户端
        HttpClient client = new HttpClient();
        // 将地址输入地址栏
        PostMethod method = new PostMethod(uri);
        // 设置请求参数编码
        method.addRequestHeader("Content-Type", "text/html; charset=UTF-8");
        try {
            // 设置请求参数(上传文件)
            File targetFile = new File("文件存储路径");
            Part[] parts = {
                    new FilePart(targetFile.getName(), targetFile)
            };
            method.setRequestEntity(new MultipartRequestEntity(parts, method.getParams()));
            // 发起请求，获取状态码
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }
            // 获取响应
            String responseBody = method.getResponseBodyAsString();
            // 处理响应
            System.out.println(responseBody);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 释放连接
            method.releaseConnection();
        }
    }

}

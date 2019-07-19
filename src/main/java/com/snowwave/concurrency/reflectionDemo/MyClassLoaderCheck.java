package com.snowwave.concurrency.reflectionDemo;

/**
 * Created by zhangfuqiang on 2019/5/19.
 */
public class MyClassLoaderCheck {
    public static void main(String[] args) throws Exception{
        MyClassLoader m = new MyClassLoader("D:/code/","myClassLoader");
        Class clazz = m.loadClass("ClassLoaderTest");
        System.out.println(clazz.getClassLoader());
        clazz.newInstance();
    }
}

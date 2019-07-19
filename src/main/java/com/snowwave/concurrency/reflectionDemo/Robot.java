package com.snowwave.concurrency.reflectionDemo;

/**
 * Created by zhangfuqiang on 2019/5/19.
 */
public class Robot {
    private String name;
    private String sayHello(String name){
        return name + "hello";
    }
    public void sayHi(String arg) {
        System.out.println(arg + " " + name);
    }

}

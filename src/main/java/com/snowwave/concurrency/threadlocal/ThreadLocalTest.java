package com.snowwave.concurrency.threadlocal;

/**
 * Created by zhangfuqiang on 2018/11/14.
 */
public class ThreadLocalTest {

    private static void print(String str) {
        System.out.println(str + ":" + localVariable.get());

        //localVariable.remove();
    }

    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread one = new Thread(() ->{
                localVariable.set("one local variable");
                print("one");
                System.out.println("one remove after" + ":" + localVariable.get());

        });

        Thread two = new Thread(() -> {
                localVariable.set("two local variable");
                print("two");
                System.out.println("two remove after" + ":" + localVariable.get());
        });

        one.start();
        two.start();
    }

}